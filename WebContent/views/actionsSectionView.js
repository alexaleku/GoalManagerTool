define(['libs/text!templates/actionsSection.html', 'views/actionRecordView', 'views/StateView'], function(actionsSectionTmpl, ActionRecord, StateView) {
    var ActionsSectionView = Backbone.View.extend({
        initialize : function() {
        	this.template = _.template($(actionsSectionTmpl).html())
        },
        render : function() {
          var modelId = this.model.get('id');
          
          this.$el.html(this.template({title: modelId}));
            
          var self = this;
          _.each(this.model.actions.models, function(actionModel) {

              actionRecord = new ActionRecord({
                  model : actionModel
              });
              var elem = actionRecord.render().el;
              
              /// ADD COLLECTION OF STATES HERE TO THE ACTION RECORD
              
              var stateView = new StateView();
              $(elem).find('.states_collection').append(stateView.render().el);
              
              
              // add action to the current (in the loop) action section
              self.$('.actions-list').append(elem);
               });
               
            console.log('rendering finished for ' + modelId);
            return this;            // to enable chained calls
        }
    });
    return ActionsSectionView;
});
