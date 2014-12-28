define(['libs/text!templates/home.html'], function(homeTpl) {
    var HomeView = Backbone.View.extend({
        el: "#content",
        // template: "home.html",
        template: homeTpl,
        initialize: function() {

        },
        render: function() {
            $(this.el).html(_.template(this.template));
        }
    });
    return HomeView;
}); 