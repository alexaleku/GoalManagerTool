define([], function() {

    var appCollections = {};

    /// MODEL

    var Action = Backbone.Model.extend();

    var ActionList = Backbone.Collection.extend({

        model : Action,

        initialize : function(json, ids) {
            // console.log(this.userId.userId);
            this.url = '/GoalManagerTool/rest/users/' + ids.userId + '/goals/' + ids.goalId + '/actions';
            console.log(this.url);
        }
    });

    var Goal = Backbone.Model.extend({

        initialize : function() {
            this.actionJson = this.get('actionList');
            if (this.actionJson != null) {
            this.actions = new ActionList(this.actionJson, {
                userId : this.userId.userId,
                goalId : this.get('id')
            });
            };
            
        }
    });

    /// COLLECTION

    var GoalList = Backbone.Collection.extend({

        model : Goal,

        initialize : function(userId) {
            this.model.prototype.userId = userId;
            this.url = '/GoalManagerTool/rest/users/' + userId.userId + '/goals';
        }
    });

    return GoalList;

});
