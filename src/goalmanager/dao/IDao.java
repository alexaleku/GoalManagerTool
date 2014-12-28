package goalmanager.dao;

import goalmanager.beans.Credentials;
import goalmanager.beans.Goal;
import goalmanager.beans.GoalAction;
import goalmanager.beans.User;

import java.util.List;

public interface IDao {

	// api
	boolean createNewUser(User user);

	List<User> getUsers();

	// main view usage

	User getUserByCredentials(Credentials credentials);

	List<Goal> getGoalListForUser(int userId); // then set goals to user

	List<GoalAction> getActionListForGoalById(int goalId);
//
//	ActionStateDated getStateByActionIdForDate(int actionId, Date date);
//
//	List<ActionStateDated> getActionStatesByPeriod(int actionId,
//			Date startDateInclusive, int numberOfDates);

	void createNewGoal(int userId, Goal goal);

	
	

}
