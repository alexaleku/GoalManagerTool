package goalmanager.controller;

import goalmanager.beans.ActionStateDated;
import goalmanager.beans.Credentials;
import goalmanager.beans.Goal;
import goalmanager.beans.GoalAction;
import goalmanager.beans.User;
import goalmanager.dao.DaoFakeData;
import goalmanager.dao.FakeObjectsFactory;
import goalmanager.dao.IDao;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

// Will map the resource to the URL
@Path("/")
public class ControllerMain {
	
	private IDao dao = new DaoFakeData();
	
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

	@GET
	@Path("user/{userId}/goals")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Goal> getGoalListForUserActionsAndStatesIncluded(@PathParam("userId") int userId) {
		// User user = dao.getUserById(userId);
		
		 List<Goal> goalList = dao.getGoalListForUser(userId);
		 
		 for (Goal goal : goalList) {
		
		 goal.setActionList(dao.getActionListForGoalById(goal.getId()));
		
		 }
		 
		 // debug
		 // FakeObjectsFactory.printToConsole(goalList);
			 
		return goalList;
	}

	@GET
	@Path("user/{userId}/goal")
	@Consumes(MediaType.APPLICATION_JSON)
	public Goal addGoalForUser(@PathParam("userId") int userId, Goal goal) {
		dao.createNewGoal(userId, goal);
		return null;
	}

	public Goal updateGoalById(int goalId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Goal deleteGoalById(int goalId) {
		// TODO Auto-generated method stub
		return null;
	}

	public GoalAction addActionForGoal(int goalId, GoalAction goalAction) {
		// TODO Auto-generated method stub
		return null;
	}

	public GoalAction updateActionById(int actionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public GoalAction deleteActionById(int actionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ActionStateDated changeStateOfActionStateDatedBy(int actionId,
			Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ActionStateDated> getStatesForActionForPeriod(int actionId,
			Date startDateInclusive, int numberOfDates) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean createNewUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	// API 
	@Path("user/{userId}")
	public UserResource getUserResource(@PathParam("userId") int id) {
		LOGGER.log(Level.INFO, "--------------- get record requested, record id: " + id+ "------------------");
		return new UserResource(id);
	}
	
	@Path("goal/{goalId}")
	public GoalResource getGoalResource(@PathParam("goalId") int id) {
		LOGGER.log(Level.INFO, "--------------- get record requested, record id: " + id+ "------------------");
		return new GoalResource(id);
	}

	@Path("action/{actionId}")
	public ActionResource getActionResource(@PathParam("actionId") int id) {
		LOGGER.log(Level.INFO, "--------------- get record requested, record id: " + id+ "------------------");
		return new ActionResource(id);
	}
	
}
