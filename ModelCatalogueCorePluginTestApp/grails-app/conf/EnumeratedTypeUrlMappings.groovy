import org.springframework.http.HttpMethod

class EnumeratedTypeUrlMappings {

    static mappings = {

// EnumeratedType
        "/api/modelCatalogue/core/enumeratedType"(controller: 'enumeratedType', action: 'index', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType"(controller: 'enumeratedType', action: 'save', method: HttpMethod.POST)
        "/api/modelCatalogue/core/enumeratedType/search/$search?"(controller: 'enumeratedType', action: 'search', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/validate"(controller: 'enumeratedType', action: 'validate', method: HttpMethod.POST)
        "/api/modelCatalogue/core/enumeratedType/$id/setDeprecated"(controller: 'enumeratedType', action: 'setDeprecated', method: HttpMethod.POST)
        "/api/modelCatalogue/core/enumeratedType/validate"(controller: 'enumeratedType', action: 'validate', method: HttpMethod.POST)
        "/api/modelCatalogue/core/enumeratedType/$id"(controller: 'enumeratedType', action: 'show', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id"(controller: 'enumeratedType', action: 'update', method: HttpMethod.PUT)
        "/api/modelCatalogue/core/enumeratedType/$id"(controller: 'enumeratedType', action: 'delete', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/enumeratedType/$id/outgoing/search"(controller: 'enumeratedType', action: 'searchOutgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/outgoing/$type/search"(controller: 'enumeratedType', action: 'searchOutgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/outgoing/$type"(controller: 'enumeratedType', action: 'outgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/outgoing/$type"(controller: 'enumeratedType', action: 'addOutgoing', method: HttpMethod.POST)
        "/api/modelCatalogue/core/enumeratedType/$id/outgoing/$type"(controller: 'enumeratedType', action: 'removeOutgoing', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/enumeratedType/$id/outgoing/$type"(controller: 'enumeratedType', action: 'reorderOutgoing', method: HttpMethod.PUT)
        "/api/modelCatalogue/core/enumeratedType/$id/incoming/search"(controller: 'enumeratedType', action: 'searchIncoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/incoming/$type/search"(controller: 'enumeratedType', action: 'searchIncoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/incoming/$type"(controller: 'enumeratedType', action: 'incoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/incoming/$type"(controller: 'enumeratedType', action: 'addIncoming', method: HttpMethod.POST)
        "/api/modelCatalogue/core/enumeratedType/$id/incoming/$type"(controller: 'enumeratedType', action: 'removeIncoming', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/enumeratedType/$id/incoming/$type"(controller: 'enumeratedType', action: 'reorderIncoming', method: HttpMethod.PUT)
        "/api/modelCatalogue/core/enumeratedType/$id/incoming"(controller: 'enumeratedType', action: 'incoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/outgoing"(controller: 'enumeratedType', action: 'outgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/mapping/$destination"(controller: 'enumeratedType', action: 'addMapping', method: HttpMethod.POST)
        "/api/modelCatalogue/core/enumeratedType/$id/mapping/$destination"(controller: 'enumeratedType', action: 'removeMapping', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/enumeratedType/$id/mapping"(controller: 'enumeratedType', action: 'mappings', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/typeHierarchy"(controller: 'enumeratedType', action: 'typeHierarchy', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/history"(controller: 'enumeratedType', action: 'history', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/path"(controller: 'enumeratedType', action: 'path', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/archive"(controller: 'enumeratedType', action: 'archive', method: HttpMethod.POST)
        "/api/modelCatalogue/core/enumeratedType/$id/restore"(controller: 'enumeratedType', action: 'restore', method: HttpMethod.POST)
        "/api/modelCatalogue/core/enumeratedType/$id/finalize"(controller: 'enumeratedType', action: 'finalizeElement', method: HttpMethod.POST)
        "/api/modelCatalogue/core/enumeratedType/$id/clone/$destinationDataModelId"(controller: 'enumeratedType', action: 'cloneElement', method: HttpMethod.POST)
        "/api/modelCatalogue/core/enumeratedType/$source/merge/$destination"(controller: 'enumeratedType', action: 'merge', method: HttpMethod.POST)
        "/api/modelCatalogue/core/enumeratedType/$id/dataElement"(controller: 'enumeratedType', action: 'dataElements', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/convert/$destination"(controller: 'enumeratedType', action: 'convert', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/validateValue"(controller: 'enumeratedType', action: 'validateValue', method: HttpMethod.GET)
        "/api/modelCatalogue/core/enumeratedType/$id/content"(controller: 'enumeratedType', action: 'content', method: HttpMethod.GET)
    }
}