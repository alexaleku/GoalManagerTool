require(['views/headerView', 'views/homeView', 'views/footerView', 'views/goalSectionView'], function (HeaderView, HomeView, FooterView, GoalSectionView) {
	
	var ApplicationRouter = Backbone.Router.extend({
		routes: {
		    "page":"page",
			"": "home",
			"*actions": "home"
			
		},
		initialize: function() {
			this.headerView = new HeaderView();
			this.headerView.render();
			this.footerView = new FooterView();
			this.footerView.render();
		},
		home: function() {
			this.homeView = new HomeView();
			this.homeView.render();
		},
		page: function() {
            this.goalSectionView = new GoalSectionView();
            this.goalSectionView.render();
        }
	});





	
	
	app = new ApplicationRouter();
	Backbone.history.start();	
});


