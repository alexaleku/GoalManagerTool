define(['libs/text!templates/page.html'], function(pageTpl) {
    var PageView = Backbone.View.extend({
        el: "#content",
        // template: "home.html",
        template: pageTpl,
        initialize: function() {

        },
        render: function() {
            $(this.el).html(_.template(this.template));
        }
    });
    return PageView;
}); 