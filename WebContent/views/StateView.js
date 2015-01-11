define(['libs/text!templates/stateSection.html'], function(stateSectionTmpl) {
    var StateView = Backbone.View.extend({
        tagName : "span",
        template : _.template($(stateSectionTmpl).html()),
           initialize : function() {
        },
        render : function() {
            this.$el.html(this.template());
            // console.log(this.model.toJSON());
            // this.$el.html(this.template(this.model.toJSON()));
            return this;  // to enable chained calls
        }
    });
    return StateView;
});