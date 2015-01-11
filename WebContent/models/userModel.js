define([], function() {
    var User = Backbone.Model.extend({
    	  initialize : function(id) {
              this.url = '/GoalManagerTool/rest/users/' + id;
              console.log(this.url);
          }
    });
    return User;
});
