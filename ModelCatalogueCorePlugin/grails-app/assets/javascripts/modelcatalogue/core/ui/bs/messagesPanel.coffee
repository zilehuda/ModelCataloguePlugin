angular.module('mc.core.ui.bs.messagesPanel', ['mc.core.ui.messagesPanel', 'ui.bootstrap']).run [ '$templateCache', ($templateCache) ->
    $templateCache.put 'modelcatalogue/core/ui/messagesPanel.html', '''
      <div class="messages-panel" ng-class="{'growl': growl}">
        <div uib-alert ng-class="'alert-' + message.type" class="alert" ng-repeat="message in getMessages()" close="message.remove()">
          <strong ng-if="message.title">{{message.title}} </strong>{{message.body}}
        </div>
      </div>
    '''
  ]
