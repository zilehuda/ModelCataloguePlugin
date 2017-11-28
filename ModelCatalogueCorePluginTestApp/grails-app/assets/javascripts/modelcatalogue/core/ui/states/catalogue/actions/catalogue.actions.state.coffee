angular.module('modelcatalogue.core.ui.states.catalogue.actions', [
  'modelcatalogue.core.ui.states.catalogue.actions.show'
]).config(['$stateProvider', ($stateProvider) ->

    $stateProvider.state('catalogue.actions', {
      abstract: true,
      url: "/actions/batch"
      templateUrl: 'modelcatalogue/core/ui/state/parent.html'
    })

])