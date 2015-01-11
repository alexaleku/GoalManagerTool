require(['views/headerView', 'views/homeView', 'views/footerView', 'views/goalSectionView', 'views/userSectionView'], function(HeaderView, HomeView, FooterView, GoalSectionView, UserSectionView) {

    var ApplicationRouter = Backbone.Router.extend({
        routes : {
            "" : "userpage",
            "goals" : "goals",
            "home" : "home"
        },
        initialize : function() {
            this.headerView = new HeaderView();
            this.headerView.render();
            this.footerView = new FooterView();
            this.footerView.render();
        },        
        userpage : function() {
            this.userSectionView = new UserSectionView();
            $('#userSection').html(this.userSectionView.render().render().el);
        },
        goals : function() {
        // if user opened goal page before userpage page then next redirects him to userpage
//            if (this.userSectionView == null) {
//                window.location.assign('');
//                return;
//            };
            
        //NEXT LINE FOR TEST ONLY - ERASE AFTER TESTS and uncomment user id field check above
            this.userSectionView = new UserSectionView();

            // initializing main view behind the scene the view initializes goal collection and all action collections
            this.goalSectionView = new GoalSectionView({
                userId : this.userSectionView.input
            });
            
            console.log('view was initialized (router message), should start rendering next');
            $('#userSection').html(this.userSectionView.render().render().el);
            $('#content').html(this.goalSectionView.render().el);
           // this.allActionsSectionView.render();
        },
        
        /// NOT IN USE FOR NOW
        home : function() {
            this.homeView = new HomeView();
            this.homeView.render();
        },
    });

    app = new ApplicationRouter();
    
    
    // reorganize app to call this function when all initialization and calls to api are done (put to done() method, or to success parameter)
    Backbone.history.start();
});

