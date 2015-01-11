package goalmanager.dao;

import goalmanager.beans.ActionStateDated;
import goalmanager.beans.Credentials;
import goalmanager.beans.Goal;
import goalmanager.beans.GoalAction;
import goalmanager.beans.User;
import static goalmanager.dao.FakeObjectsFactory.*;

import java.util.ArrayList;
import java.util.List;

public class NewFakeDao implements IDao{

	@Override
	public List<GoalAction> getActionListForAGoal(int userId, int goalId) {
		List<GoalAction> list = new ArrayList<GoalAction>();
		list.add(generateDefaultGoalAction());
		list.add(generateDefaultGoalAction());
		list.add(generateDefaultGoalAction());
		list.add(generateDefaultGoalAction());
		list.add(generateDefaultGoalAction());
		return list;
	}

	@Override
	public List<ActionStateDated> getStatesListForAnAction(int actionId,
			String fromDate, String duration) {
		List<ActionStateDated> list = new ArrayList<ActionStateDated>();
		list.add(generateDefaultActionStateDated());
		list.add(generateDefaultActionStateDated());
		list.add(generateDefaultActionStateDated());
		return list;
	}
	
	@Override
	public User getUserByCredentials(Credentials credentials) {
		User user = generateUser(12, "asdf", "aksjdnf", "pass");
		return user;
	}

	@Override
	public List<Goal> getGoalListForUser(int userId) {
		List<Goal> list = new ArrayList<Goal>();
		list.add(generateDefaultGoal());
		list.add(generateDefaultGoal());
		list.add(generateDefaultGoal());
		list.add(generateDefaultGoal());
		return list;
	}


	@Override
	public List<User> getUsers() {
		List<User> list = new ArrayList<User>();
		list.add(generateDefaultUser());
		list.add(generateDefaultUser());
		list.add(generateDefaultUser());
		list.add(generateDefaultUser());
		return list;
	}

	@Override
	public User addUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goal addGoal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoalAction addGoalAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionStateDated addActionStateDated() {
		// TODO Auto-generated method stub
		return null;
	}

}
