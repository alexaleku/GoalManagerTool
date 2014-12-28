define(['libs/text!templates/goalRecord.html'], function(goalRecordTmpl) {
    var GoalRecordView = Backbone.View.extend({
        tagName : "li",
        template : _.template($(goalRecordTmpl).html()),
        render : function() {
            this.$el.html(this.template(this.model.toJSON()));
            this.input = this.$('.edit');
            this.input.hide();
            return this;
            // to enable chained calls
        },
        initialize : function() {
            this.model.on('change', this.render, this);
            this.model.on('destroy', this.remove, this);
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
    return GoalRecordView;
});
