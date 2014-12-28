define([], function() {
    /// MODEL

    var Goal = Backbone.Model.extend();

    /// COLLECTION

    var GoalList = Backbone.Collection.extend({
        model : Goal,
        //localStorage : new Store("goalManager")
        url : 'http://localhost:8080/GoalManagerTool/rest/user/2/goals'
    });

    return GoalList;
});
