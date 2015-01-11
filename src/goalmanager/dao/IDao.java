package goalmanager.dao;

import goalmanager.beans.ActionStateDated;
import goalmanager.beans.Credentials;
import goalmanager.beans.Goal;
import goalmanager.beans.GoalAction;
import goalmanager.beans.User;

import java.util.List;

public interface IDao {

	// api

	List<GoalAction> getActionListForAGoal(int userId, int goalId);

	List<ActionStateDated> getStatesListForAnAction(int actionId, String fromDate, String duration);

	User getUserByCredentials(Credentials credentials);

	List<Goal> getGoalListForUser(int userId);

	List<User> getUsers();

	User addUser();

	Goal addGoal();
	
	GoalAction addGoalAction();

	ActionStateDated addActionStateDated();

	
//	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
//	Date mDate = new Date();
	//insert in database will be dateFormat.format(mDate)
}
