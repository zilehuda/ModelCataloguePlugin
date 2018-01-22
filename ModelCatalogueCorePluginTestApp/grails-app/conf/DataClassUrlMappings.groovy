import org.springframework.http.HttpMethod

class DataClassUrlMappings {

    static mappings = {
        "/api/modelCatalogue/core/dataClass"(controller: 'dataClass', action: 'index', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass"(controller: 'dataClass', action: 'save', method: HttpMethod.POST)
        "/api/modelCatalogue/core/dataClass/search/$search?"(controller: 'dataClass', action: 'search', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/validate"(controller: 'dataClass', action: 'validate', method: HttpMethod.POST)
        "/api/modelCatalogue/core/dataClass/validate"(controller: 'dataClass', action: 'validate', method: HttpMethod.POST)
        "/api/modelCatalogue/core/dataClass/$id"(controller: 'dataClass', action: 'show', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/availableReportDescriptors"(controller: 'dataClass', action: 'availableReportDescriptors', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id"(controller: 'dataClass', action: 'update', method: HttpMethod.PUT)
        "/api/modelCatalogue/core/dataClass/$id"(controller: 'dataClass', action: 'delete', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/dataClass/$id/outgoing/search"(controller: 'dataClass', action: 'searchOutgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/outgoing/$type/search"(controller: 'dataClass', action: 'searchOutgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/outgoing/$type"(controller: 'dataClass', action: 'outgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/outgoing/$type"(controller: 'dataClass', action: 'addOutgoing', method: HttpMethod.POST)
        "/api/modelCatalogue/core/dataClass/$id/outgoing/$type"(controller: 'dataClass', action: 'removeOutgoing', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/dataClass/$id/outgoing/$type"(controller: 'dataClass', action: 'reorderOutgoing', method: HttpMethod.PUT)
        "/api/modelCatalogue/core/dataClass/$id/incoming/search"(controller: 'dataClass', action: 'searchIncoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/incoming/$type/search"(controller: 'dataClass', action: 'searchIncoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/incoming/$type"(controller: 'dataClass', action: 'incoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/incoming/$type"(controller: 'dataClass', action: 'addIncoming', method: HttpMethod.POST)
        "/api/modelCatalogue/core/dataClass/$id/incoming/$type"(controller: 'dataClass', action: 'removeIncoming', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/dataClass/$id/incoming/$type"(controller: 'dataClass', action: 'reorderIncoming', method: HttpMethod.PUT)
        "/api/modelCatalogue/core/dataClass/$id/incoming"(controller: 'dataClass', action: 'incoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/outgoing"(controller: 'dataClass', action: 'outgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/mapping/$destination"(controller: 'dataClass', action: 'addMapping', method: HttpMethod.POST)
        "/api/modelCatalogue/core/dataClass/$id/mapping/$destination"(controller: 'dataClass', action: 'removeMapping', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/dataClass/$id/mapping"(controller: 'dataClass', action: 'mappings', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/typeHierarchy"(controller: 'dataClass', action: 'typeHierarchy', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/history"(controller: 'dataClass', action: 'history', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/path"(controller: 'dataClass', action: 'path', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/archive"(controller: 'dataClass', action: 'archive', method: HttpMethod.POST)
        "/api/modelCatalogue/core/dataClass/$id/restore"(controller: 'dataClass', action: 'restore', method: HttpMethod.POST)
        "/api/modelCatalogue/core/dataClass/$id/clone/$destinationDataModelId"(controller: 'dataClass', action: 'cloneElement', method: HttpMethod.POST)
        "/api/modelCatalogue/core/dataClass/$source/merge/$destination"(controller: 'dataClass', action: 'merge', method: HttpMethod.POST)
        "/api/modelCatalogue/core/dataClass/$id/inventoryDoc"(controller: 'dataClass', action: 'inventoryDoc', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/classificationChangelog"(controller: 'dataClass', action: 'changelogDoc', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/inventorySpreadsheet"(controller: 'dataClass', action: 'inventorySpreadsheet', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/referenceType"(controller: 'dataClass', action: 'referenceTypes', method: HttpMethod.GET)
        "/api/modelCatalogue/core/dataClass/$id/content"(controller: 'dataClass', action: 'content', method: HttpMethod.GET)

        // DataClass
        "/api/modelCatalogue/core/model"(controller: 'dataClass', action: 'index', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model"(controller: 'dataClass', action: 'save', method: HttpMethod.POST)
        "/api/modelCatalogue/core/model/search/$search?"(controller: 'dataClass', action: 'search', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/validate"(controller: 'dataClass', action: 'validate', method: HttpMethod.POST)
        "/api/modelCatalogue/core/model/validate"(controller: 'dataClass', action: 'validate', method: HttpMethod.POST)
        "/api/modelCatalogue/core/model/$id"(controller: 'dataClass', action: 'show', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id"(controller: 'dataClass', action: 'update', method: HttpMethod.PUT)
        "/api/modelCatalogue/core/model/$id"(controller: 'dataClass', action: 'delete', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/model/$id/outgoing/search"(controller: 'dataClass', action: 'searchOutgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/outgoing/$type/search"(controller: 'dataClass', action: 'searchOutgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/outgoing/$type"(controller: 'dataClass', action: 'outgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/outgoing/$type"(controller: 'dataClass', action: 'addOutgoing', method: HttpMethod.POST)
        "/api/modelCatalogue/core/model/$id/outgoing/$type"(controller: 'dataClass', action: 'removeOutgoing', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/model/$id/outgoing/$type"(controller: 'dataClass', action: 'reorderOutgoing', method: HttpMethod.PUT)
        "/api/modelCatalogue/core/model/$id/incoming/search"(controller: 'dataClass', action: 'searchIncoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/incoming/$type/search"(controller: 'dataClass', action: 'searchIncoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/incoming/$type"(controller: 'dataClass', action: 'incoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/incoming/$type"(controller: 'dataClass', action: 'addIncoming', method: HttpMethod.POST)
        "/api/modelCatalogue/core/model/$id/incoming/$type"(controller: 'dataClass', action: 'removeIncoming', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/model/$id/incoming/$type"(controller: 'dataClass', action: 'reorderIncoming', method: HttpMethod.PUT)
        "/api/modelCatalogue/core/model/$id/incoming"(controller: 'dataClass', action: 'incoming', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/outgoing"(controller: 'dataClass', action: 'outgoing', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/mapping/$destination"(controller: 'dataClass', action: 'addMapping', method: HttpMethod.POST)
        "/api/modelCatalogue/core/model/$id/mapping/$destination"(controller: 'dataClass', action: 'removeMapping', method: HttpMethod.DELETE)
        "/api/modelCatalogue/core/model/$id/mapping"(controller: 'dataClass', action: 'mappings', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/typeHierarchy"(controller: 'dataClass', action: 'typeHierarchy', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/history"(controller: 'dataClass', action: 'history', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/path"(controller: 'dataClass', action: 'path', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/archive"(controller: 'dataClass', action: 'archive', method: HttpMethod.POST)
        "/api/modelCatalogue/core/model/$id/restore"(controller: 'dataClass', action: 'restore', method: HttpMethod.POST)
        "/api/modelCatalogue/core/model/$id/clone/$destinationDataModelId"(controller: 'dataClass', action: 'cloneElement', method: HttpMethod.POST)
        "/api/modelCatalogue/core/model/$source/merge/$destination"(controller: 'dataClass', action: 'merge', method: HttpMethod.POST)
        "/api/modelCatalogue/core/model/$id/inventoryDoc"(controller: 'dataClass', action: 'inventoryDoc', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/classificationChangelog"(controller: 'dataClass', action: 'changelogDoc', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/inventorySpreadsheet"(controller: 'dataClass', action: 'inventorySpreadsheet', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/referenceType"(controller: 'dataClass', action: 'referenceTypes', method: HttpMethod.GET)
        "/api/modelCatalogue/core/model/$id/content"(controller: 'dataClass', action: 'content', method: HttpMethod.GET)
    }
}
