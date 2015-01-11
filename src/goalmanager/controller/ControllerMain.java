package goalmanager.controller;

import goalmanager.beans.ActionStateDated;
import goalmanager.beans.Credentials;
import goalmanager.beans.Goal;
import goalmanager.beans.GoalAction;
import goalmanager.beans.User;
import goalmanager.dao.FakeObjectsFactory;
import goalmanager.dao.IDao;
import goalmanager.dao.NewFakeDao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

// Will map the resource to the URL
@Path("/")
public class ControllerMain {
	
	private IDao dao = new NewFakeDao();
	
	private final static Logger LOGGER = Logger.getLogger(ControllerMain.class.getName());
	
	@GET
	@Path("health")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		String healthText = "app is healthy";
		LOGGER.log(Level.INFO, "---------- health check: " + healthText+ "-------------");
		return healthText;
	}

	@POST
	@Path("userlogin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public User getUserByCredentials(Credentials credentials) {
		User user = dao.getUserByCredentials(credentials);
		return user;
	}

	
	// API 
	
// get users
	@GET
	@Path("users")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<User> getUsers() {
		List<User> userList = dao.getUsers();
		return userList;
	}

// add a new user
	@POST
	@Path("users")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public User addUser() {
		User user = dao.addUser();
		return user;
	}

// update / delete user using a user resource file
	@Path("users/{userId}")
	public UserResource getUserResource(@PathParam("userId") int userId) {
		LOGGER.log(Level.INFO, "--------------- get record requested, record id: " + userId+ "------------------");
		return new UserResource(userId);
	}
	
// get all goals for a user
	@GET
	@Path("users/{userId}/goals")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Goal> getGoalListForUser(@PathParam("userId") int userId) {
		// User user = dao.getUserById(userId);
		
		 List<Goal> goalList = dao.getGoalListForUser(userId);
		 FakeObjectsFactory.counter = 1;
		 for (Goal goal : goalList) {
		
		 goal.setActionList(dao.getActionListForAGoal(33, goal.getId()));
		
		 }
		 FakeObjectsFactory.counter = 1;
		 
		 // debug
		 // FakeObjectsFactory.printToConsole(goalList);
			 
		return goalList;
	}
	
// post a new goal
	@POST
	@Path("users/{userId}/goals")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Goal addGoal(@PathParam("userId") int userId) {
		Goal goal = dao.addGoal();
		return goal;
	}
	
// update / delete a goal using GaolRecource class
	@Path("users/{userId}/goals/{goalId}")
	public GoalResource getGoalResource(@PathParam("userId") int userId, @PathParam("goalId") int goalId) {
		LOGGER.log(Level.INFO, "--------------- get record requested, record id: " + userId + "------------------");
		return new GoalResource(goalId);
	}
	
// get goal actions list for a goal
	@GET
	@Path("users/{userId}/goals/{goalId}/actions")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<GoalAction> getActionListForGoal(@PathParam("userId") int userId, @PathParam("goalId") int goalId) {
		
		List<GoalAction> goalList = dao.getActionListForAGoal(userId, goalId);
		
		return goalList;
	}
	
// add a goal action for a goal
	@POST
	@Path("users/{userId}/goals/{goalId}/actions")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public GoalAction addGoalAction(@PathParam("userId") int userId, @PathParam("goalId") int goalId) {
		GoalAction goalAction = dao.addGoalAction();
		return goalAction;
	}

// update / delete a goal action using ActionResource class
	@Path("users/{userId}/goals/{goalId}/actions/{actionId}")
	public ActionResource getActionResource(@PathParam("userId") int userId, @PathParam("goalId") int goalId, @PathParam("actionId") int actionId) {
		LOGGER.log(Level.INFO, "--------------- get record requested, record id: " + actionId+ "------------------");
		return new ActionResource(actionId);
	}
	
// get action states for some period of time
	@GET
	@Path("users/{userId}/goals/{goalId}/actions/{actionId}/states")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ActionStateDated> getActionSates(@PathParam("userId") int userId, @PathParam("goalId") int goalId, @PathParam("actionId") int actionId, @QueryParam("from") String fromDate, @QueryParam("duration") String duration) {
		List<ActionStateDated> actionList = dao.getStatesListForAnAction(actionId, fromDate, duration);
		return actionList;
	}
	
	@POST
	@Path("users/{userId}/goals/{goalId}/actions/{actionId}/states")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public ActionStateDated addActionSate(@PathParam("userId") int userId, @PathParam("goalId") int goalId, @PathParam("actionId") int actionId) {
		ActionStateDated actionStateDated = dao.addActionStateDated();
		return actionStateDated;
	}
	
// update / delete a state using ActionStateDatedResource class
	@Path("users/{userId}/goals/{goalId}/actions/{actionId}/states/{stateId}")
	public ActionStateDatedResource changeActionSate(@PathParam("userId") int userId, @PathParam("goalId") int goalId, @PathParam("actionId") int actionId, @PathParam("stateId") int stateId) {
		LOGGER.log(Level.INFO, "--------------- get record requested, record id: " + stateId+ "------------------");
		return new ActionStateDatedResource(stateId);
	}
	
}
