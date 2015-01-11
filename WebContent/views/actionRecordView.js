define(['libs/text!templates/actionRecord.html'], function(actionRecordTmpl) {
    var ActionRecordView = Backbone.View.extend({
        tagName : "li",
        template : _.template($(actionRecordTmpl).html()),
           initialize : function() {
        },
        render : function() {
            console.log(this.model.toJSON());
            this.$el.html(this.template(this.model.toJSON()));
            this.input = this.$('.edit');
            this.input.hide();
            return this;
            // to enable chained calls
        },
        events : {
            'dblclick .input_title' : 'edit',
            'keypress .edit' : 'updateOnEnter',
            'blur .edit' : 'close',
            'click .destroy' : 'destroy'
        },
        edit : function() {
            this.input.show();
            this.$('.title').hide();
            this.input.focus();
        },
        close : function() {
            var value = this.input.val().trim();
            if (value) {
                this.model.save({
                    title : value
                });
            }
             this.input.hide();
            this.$('.title').show();
        },
        updateOnEnter : function(e) {
            if (e.which == 13) {
                this.close();
            }
        },
        destroy : function() {
            this.model.destroy();
        }
    });
    return ActionRecordView;
});