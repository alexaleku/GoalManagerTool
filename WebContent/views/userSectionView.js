define(['libs/text!templates/userSection.html', 'models/userModel'], function(userSectionTmpl, UserModel) {
    var UserSectionView = Backbone.View.extend({
        initialize : function() {
            // DEFAULT USER ID (INPUT) VALUE
        	this.input = 0;
        },
        render : function() {
        // renders view tamplate (we can provide some model to the template if needed to populate html template with model data)
        	this.template = _.template($(userSectionTmpl).html());
        // updates this.el with the new HTML.
            this.$el.html(this.template);
            this.$('#userIdInput').focus();
            return this;
        },
        events : {
            'click #setUserSubmit' : 'setUser'
        },
        setUser : function() {
            this.input = this.$('#userIdInput').val().trim();
         // check not empty and is integer otherwise do nothing
            if (this.input == "" || this.input % 1 !== 0) {
            	return;
            }
         // create user model and send user id
            this.model = new UserModel(this.input);
        
         //  when fetch done redirect to /goals page ("goals" on router)
            this.model.fetch().done( function(){
            	window.location.assign('#goals');
            });
        }
    });
    return UserSectionView;
}); 