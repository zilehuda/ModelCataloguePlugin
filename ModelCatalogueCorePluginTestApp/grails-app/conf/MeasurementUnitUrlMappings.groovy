import org.springframework.http.HttpMethod

class MeasurementUnitUrlMappings {

    static mappings = {
        // MeasurementUnit
        "/api/modelCatalogue/core/measurementUnit"(controller: 'measurementUnit', action: 'index', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit"(controller: 'measurementUnit', action: 'save', method: HttpMethod.POST)
        "/api/modelCatalogue/core/measurementUnit/search/$search?"(controller: 'measurementUnit', action: 'search', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id/validate"(controller: 'measurementUnit', action: 'validate', method: HttpMethod.POST)
        "/api/modelCatalogue/core/measurementUnit/validate"(controller: 'measurementUnit', action: 'validate', method: HttpMethod.POST)
        "/api/modelCatalogue/core/measurementUnit/$id"(controller: 'measurementUnit', action: 'show', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id"(controller: 'measurementUnit', action: 'update', method: HttpMethod.PUT)
        "/api/modelCatalogue/core/measurementUnit/$id"(controller: 'measurementUnit', action: 'delete', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/measurementUnit/$id/outgoing/search"(controller: 'measurementUnit', action: 'searchOutgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id/outgoing/$type/search"(controller: 'measurementUnit', action: 'searchOutgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id/outgoing/$type"(controller: 'measurementUnit', action: 'outgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id/outgoing/$type"(controller: 'measurementUnit', action: 'addOutgoing', method: HttpMethod.POST)
        "/api/modelCatalogue/core/measurementUnit/$id/outgoing/$type"(controller: 'measurementUnit', action: 'removeOutgoing', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/measurementUnit/$id/outgoing/$type"(controller: 'measurementUnit', action: 'reorderOutgoing', method: HttpMethod.PUT)
        "/api/modelCatalogue/core/measurementUnit/$id/incoming/search"(controller: 'measurementUnit', action: 'searchIncoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id/incoming/$type/search"(controller: 'measurementUnit', action: 'searchIncoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id/incoming/$type"(controller: 'measurementUnit', action: 'incoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id/incoming/$type"(controller: 'measurementUnit', action: 'addIncoming', method: HttpMethod.POST)
        "/api/modelCatalogue/core/measurementUnit/$id/incoming/$type"(controller: 'measurementUnit', action: 'removeIncoming', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/measurementUnit/$id/incoming/$type"(controller: 'measurementUnit', action: 'reorderIncoming', method: HttpMethod.PUT)
        "/api/modelCatalogue/core/measurementUnit/$id/incoming"(controller: 'measurementUnit', action: 'incoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id/outgoing"(controller: 'measurementUnit', action: 'outgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id/mapping/$destination"(controller: 'measurementUnit', action: 'addMapping', method: HttpMethod.POST)
        "/api/modelCatalogue/core/measurementUnit/$id/mapping/$destination"(controller: 'measurementUnit', action: 'removeMapping', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/measurementUnit/$id/mapping"(controller: 'measurementUnit', action: 'mappings', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id/typeHierarchy"(controller: 'measurementUnit', action: 'typeHierarchy', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id/history"(controller: 'measurementUnit', action: 'history', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id/path"(controller: 'measurementUnit', action: 'path', method: HttpMethod.GET)
        "/api/modelCatalogue/core/measurementUnit/$id/archive"(controller: 'measurementUnit', action: 'archive', method: HttpMethod.POST)
        "/api/modelCatalogue/core/measurementUnit/$id/restore"(controller: 'measurementUnit', action: 'restore', method: HttpMethod.POST)
        "/api/modelCatalogue/core/measurementUnit/$id/finalize"(controller: 'measurementUnit', action: 'finalizeElement', method: HttpMethod.POST)
        "/api/modelCatalogue/core/measurementUnit/$id/clone/$destinationDataModelId"(controller: 'measurementUnit', action: 'cloneElement', method: HttpMethod.POST)
        "/api/modelCatalogue/core/measurementUnit/$source/merge/$destination"(controller: 'measurementUnit', action: 'merge', method: HttpMethod.POST)
        "/api/modelCatalogue/core/measurementUnit/$id/primitiveType"(controller: 'measurementUnit', action: 'primitiveTypes', method: HttpMethod.GET)
    }
}