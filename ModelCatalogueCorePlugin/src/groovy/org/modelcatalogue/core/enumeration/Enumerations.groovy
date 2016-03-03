package org.modelcatalogue.core.enumeration

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovy.json.internal.Exceptions.JsonInternalException
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@CompileStatic class Enumerations implements Map<String, String>, Iterable<Enumeration> {

    static Enumerations from(Object o) {
        if (o == null) {
            return new Enumerations()
        }

        if (o instanceof String) {
            return from(o as String)
        }

        if (o instanceof Map) {
            return from(o as Map<String, String>)
        }

        throw new IllegalArgumentException("Cannot create enumeration from $o")
    }

    @CompileDynamic
    static Enumerations from(String text) {
        if (!text) {
            return new Enumerations()
        }
        try {
            JsonSlurper slurper = new JsonSlurper()
            def payload =  slurper.parseText(text)

            Enumerations enumerations = new Enumerations()

            if (payload.type && payload.type == 'orderedMap' && payload.values != null && payload.values instanceof List) {
                for (value in payload.values) {
                    if (!value.id && !value.key && !value.value) {
                        continue
                    }

                    if (!value.id) {
                        enumerations.put(value.key?.toString(), value.value?.toString())
                    }

                    Long id
                    if (value.id instanceof Number) {
                        id = (value.id as Number).longValue()
                    } else {
                        id = Long.parseLong(value.id.toString(), 10)
                    }

                    enumerations.put(id, value.key?.toString(), value.value?.toString())
                }

                return enumerations
            }

            throw new IllegalArgumentException("Unparsable enumeration JSON string $text")
        } catch (JsonInternalException ignored) {}

        return from(LegacyEnumerations.stringToMap(text))

    }

    @CompileDynamic
    static Enumerations from(Map<String, String> enumerations) {
        if (!enumerations) {
            return new Enumerations()
        }
        Enumerations enums = new Enumerations()

        if (enumerations.type && enumerations.type == 'orderedMap') {
            for (value in (enumerations.values ?: [])) {
                if (!value.id && !value.key && !value.value) {
                    continue
                }
                Long id = (value.id as Number)?.longValue()
                if (id != null) {
                    enums.put(id, value.key?.toString(), value.value?.toString())
                } else {
                    enums.put(value.key?.toString(), value.value?.toString())
                }
            }
            return enums
        }

        enumerations.each { String key, String value ->
            enums.put(key,value)
        }

        return enums
    }

    static Enumerations create() {
        return new Enumerations()
    }

    private final Set<Enumeration> enumerations = new LinkedHashSet<Enumeration>()
    private final Map<String, Enumeration> enumerationsByKeys = new LinkedHashMap<String, Enumeration>()
    private final Map<Long, Enumeration> enumerationsById = new LinkedHashMap<Long, Enumeration>()
    private long genid = 1;

    private Enumerations() {}

    Enumerations copy() {
        Enumerations enumerations = new Enumerations()
        enumerations.@genid = this.@genid
        for (Enumeration e in this) {
            enumerations.put(e.id, e.key, e.value)
        }
        return enumerations
    }

    @Override
    Iterator<Enumeration> iterator() {
        return enumerations.iterator()
    }

    @Override
    int size() {
        return enumerationsByKeys.size()
    }

    @Override
    boolean isEmpty() {
        return enumerationsByKeys.isEmpty()
    }

    @Override
    boolean containsKey(Object key) {
        return enumerationsByKeys.containsKey(key)
    }

    @Override
    boolean containsValue(Object value) {
        return enumerations.any { it.value == value }
    }

    @Override
    String get(Object key) {
        return enumerationsByKeys.get(key)?.value
    }

    Enumeration getEnumerationById(Long id){
        return enumerationsById.get(id)
    }

    String put(Long id, String key, String value) {
        genid = Math.max(genid, id) + 1

        Enumeration existing = enumerationsById.get(id)

        if (existing) {
            return replaceExistingEnumeration(id, key, value, existing)
        }

        existing = enumerationsByKeys.get(key)
        if (existing) {
            return replaceExistingEnumeration(id, key, value, existing)
        }

        Enumeration newOne = Enumeration.create(id, key, value)
        enumerations.add(newOne)
        enumerationsByKeys.put(key, newOne)
        enumerationsById.put(id, newOne)
        return null
    }

    private String replaceExistingEnumeration(long id, String key, String value, Enumeration existing) {
        Enumeration newOne = Enumeration.create(id, key, value)
        enumerationsByKeys.remove(existing.key)
        enumerationsByKeys.put(key, newOne)
        enumerationsById.remove(existing.id)
        enumerationsById.put(id, newOne)
        enumerations.remove(existing)
        enumerations.add(newOne)
        return existing.value
    }

    @Override
    String put(String key, String value) {
        put(genid, key, value)
    }

    @Override
    String remove(Object key) {
        Enumeration existing = enumerationsByKeys.get(key)
        if (existing) {
            enumerations.remove(existing)
            enumerationsByKeys.remove(key)
            enumerationsById.remove(existing.id)
            return existing.value
        }
        return null
    }

    Enumeration removeEnumerationById(Long id) {
        Enumeration existing = getEnumerationById(id)

        if (!existing) {
            return null
        }

        remove(existing.key)

        return existing
    }

    @Override
    void putAll(Map<? extends String, ? extends String> m) {
        m.each { String key, String value ->
            put(key, value)
        }
    }

    @Override
    void clear() {
        enumerations.clear()
        enumerationsByKeys.clear()
        enumerationsById.clear()
        genid = 1
    }

    @Override
    Set<String> keySet() {
        return enumerationsByKeys.keySet()
    }

    @Override
    Collection<String> values() {
        return enumerationsByKeys.values().collect { it.value }
    }

    @Override
    Set<Map.Entry<String, String>> entrySet() {
        return (enumerationsByKeys.collectEntries { String key, Enumeration value -> [key, value.value] } as Map<String, String>).entrySet()
    }

    @Override
    String toString() {
        return toJsonString()
    }

    String toJsonString() {
        JsonBuilder json = new JsonBuilder()
        json (toJsonMap())
        json.toString()
    }

    Map<String, Object> toJsonMap() {
        [type: 'orderedMap', values: enumerations.collect { [id: it.id, key: it.key, value: it.value ] }]
    }
}