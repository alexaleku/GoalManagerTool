define(['libs/text!templates/footer.html'], function(footerTmpl) {
    var FooterView = Backbone.View.extend({
        el : "#footer",
        template : footerTmpl,
        render : function() {
            this.$el.html(_.template(this.template));
        }
    });
    return FooterView;
}); 