define(['libs/text!templates/goalSection.html', 'views/goalRecordView', 'models/goalModel', 'libs/text!json/model.json', 'plugins/jquery-sortable-min', 'views/actionsSectionView', 'views/actionRecordView'], function(goalSectionTmpl, GoalRecord, GoalCollection, json, drag, ActionsSectionView, ActionRecord) {
    var GoalSectionView = Backbone.View.extend({
        initialize : function(userId) {
        	this.template = _.template($(goalSectionTmpl).html());
            this.goalCollection = new GoalCollection(userId);
            
            // when new elements are added to the collection render then with addOne
            this.goalCollection.on('add', this.addOne, this);
            this.goalCollection.on('reset', this.addAll, this);
          // this.goalCollection.fetch();
        },
     // render function for population the el object of the view, then external code will decide how and where to show the view (in which element to insert it or which element to assign to it, so we don't specifying existing dom element here because this would be hard coupling to index html)
        render : function() {
        	console.log('goalSection render started');
        	
            this.$el.html('Loading...');
            
            var self = this;
            
            this.goalCollection.fetch().done( function(){
            	
            	console.log('fetch done');
            	
            	
                self.showgoalsection();
                //можно переписать все петли с помощью this.collection.each(this.addItem, this) и тогда переместить тело петель в другие методы объекта GoalSectionView (определить функции как новые свойства (как render))
            	
               // _.each(self.goalCollection.models, function(goalModel) {
                self.goalCollection.each(function(goalModel) {
            	self.showgoal(goalModel);
            	self.showactions(goalModel);
            	 }); 
                 });
            return this;
        },
        showgoalsection : function() {
        	this.$el.html(this.template());
            this.input = this.$('#new-todo');
        },
        showgoal : function(goalModel) {
                var goalRecord = new GoalRecord({
                    model : goalModel
                });
                this.$('#itemslist').append(goalRecord.render().el);
        },
        showactions : function(goalModel) {
            var actionsSectionView = new ActionsSectionView({
                model : goalModel
            });
             this.$('#actionGroups').append(actionsSectionView.render().el);
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
