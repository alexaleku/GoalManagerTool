define(['libs/text!templates/goalSection.html', 'views/goalRecordView', 'models/goalModel', 'libs/text!json/model.json', 'plugins/jquery-sortable-min'], function(goalSectionTmpl, GoalRecord, GoalCollection, json, drag) {
    var GoalSectionView = Backbone.View.extend({
        el : "#content",
        template : _.template($(goalSectionTmpl).html()),
        render : function() {
            this.$el.html(this.template);

            
            _.each(this.goalCollection.models, function(goalModel) {

                goalRecord = new GoalRecord({
                    model : goalModel
                });
                this.$('#itemslist').append(goalRecord.render().el);

            });
            this.input = this.$('#new-todo');
           console.log(this.input);
        },

        initialize : function() {
            this.goalCollection = new GoalCollection();
            
            // when new elements are added to the collection render then with addOne
            this.goalCollection.on('add', this.addOne, this);
            this.goalCollection.on('reset', this.addAll, this);
            this.goalCollection.fetch();
            
            // Loads list from local storage
        },
        events : {
            'keypress #new-todo' : 'createTodoOnEnter'
        },
        createTodoOnEnter : function(e) {
            // if key is not Enter then just return
            if (e.which !== 13 || !this.input.val().trim()) {// ENTER_KEY = 13
                return;
            }
            // if key is Enter do next
            this.goalCollection.create(this.newAttributes());
            this.input.val('');
            // clean input box
        },
        addOne : function(goal) {
            var view = new GoalRecord({
                model : goal
            });
            $('#itemslist').append(view.render().el);
        },
        addAll : function() {
            this.$('#itemslist').html('');
            this.goalCollection.each(this.addOne, this);
        },
        newAttributes : function() {
            return {
                title : this.input.val().trim()
            };
        }
    });
    return GoalSectionView;
});
