package goalmanager.dao;

import goalmanager.beans.ActionLable;
import goalmanager.beans.ActionStateDated;
import goalmanager.beans.ActionType;
import goalmanager.beans.Credentials;
import goalmanager.beans.Goal;
import goalmanager.beans.GoalAction;
import goalmanager.beans.Priority;
import goalmanager.beans.User;
import static goalmanager.dao.FakeObjectsFactory.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoFakeData implements IDao{


	public List<Goal> getGoalListForUser(int userId) {
		
		List<Goal> goalList = new ArrayList<>();
		
		Priority priority1 = generatePriority(1,"high", "priority1_image");
		Priority priority2 = generatePriority(2,"medium", "priority2_image");
		Priority priority3 = generatePriority(3,"low", "priority3_image");
		
		Goal goal1 = generateGoal(1, "goal1", "goal1 descriprion", priority1);
		Goal goal2 = generateGoal(2, "goal2", "goal2 descriprion", priority2);
		Goal goal3 = generateGoal(3, "goal3", "goal3 descriprion", priority3);
		
		goalList.add(goal1);
		goalList.add(goal2);
		goalList.add(goal3);
		
		return goalList;
	}

	public List<GoalAction> getActionListForGoalById(int id) {
		List<GoalAction> actionList = new ArrayList<>();
		
		Priority priority1 = generatePriority(1,"high", "priority1_image");
		Priority priority2 = generatePriority(2,"medium", "priority2_image");
		Priority priority3 = generatePriority(3,"low", "priority3_image");
		
		ActionLable actionLable = generateActionLable(1, "action lable1", "lable1 desc");
		ActionType actionType = generateActionType(1, "action type1", "type1 desc");
		
		GoalAction goalAction1 = generateGoalAction(id, "action title1", "action group1", "action desc", priority1, actionLable, actionType);
		GoalAction goalAction2 = generateGoalAction(id, "action title2", "action group2", "action desc", priority2, actionLable, actionType);
		GoalAction goalAction3 = generateGoalAction(id, "action title3", "action group3", "action desc", priority3, actionLable, actionType);
		
		actionList.add(goalAction1);
		actionList.add(goalAction2);
		actionList.add(goalAction3);
		
		return actionList;
	}

	@Override
	public boolean createNewUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User getUserByCredentials(Credentials credentials) {
		return  FakeObjectsFactory.generateUser(12, "SSS", credentials.getNickname(), credentials.getPass());
	}

	@Override
	public void createNewGoal(int userId, Goal goal) {
		// TODO Auto-generated method stub
		
	}


	
//
//	@Override
//	public boolean createNewUser(User user) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public List<User> getUsers() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	

//
//
//
//	public ActionStateDated getStateByActionIdForDate(int actionId, Date date) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<ActionStateDated> getActionStatesByPeriod(int actionId,
//			Date startDateInclusive, int numberOfDates) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
