package goalmanager.controller;

import goalmanager.beans.ActionStateDated;
import goalmanager.beans.Goal;
import goalmanager.beans.GoalAction;
import goalmanager.beans.User;

import java.util.Date;
import java.util.List;

public interface 
IControllerMain {

	// GUI
	User getUserByCredentials(String name, String pass);

	List<Goal> getGoalListForUserActionsAndStatesIncluded(int userId);

	Goal addGoalForUser(int userId, Goal goal);

	Goal updateGoalById(int goalId);

	Goal deleteGoalById(int goalId);

	GoalAction addActionForGoal(int goalId, GoalAction goalAction);

	GoalAction updateActionById(int actionId);

	GoalAction deleteActionById(int actionId);

	ActionStateDated changeStateOfActionStateDatedBy(int actionId, Date date);

	// optional
	List<ActionStateDated> getStatesForActionForPeriod(int actionId,
			Date startDateInclusive, int numberOfDates);

	// api

	// User
	boolean createNewUser(User user);

	boolean updateUser(User user);

	List<User> getUsers();

	User getUserByCredentials(String jsonRequest);

	// Goal

	// GoalAction

	// ActionState for period

	// Priority
	// ActionLable
	// ActionType
	// ActionState
}