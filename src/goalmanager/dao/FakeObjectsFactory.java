package goalmanager.dao;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.codehaus.jackson.map.ObjectMapper;

import goalmanager.beans.ActionLable;
import goalmanager.beans.ActionType;
import goalmanager.beans.Goal;
import goalmanager.beans.GoalAction;
import goalmanager.beans.Priority;
import goalmanager.beans.User;
import goalmanager.controller.ControllerMain;

public class FakeObjectsFactory {

	private final static Logger LOGGER = Logger.getLogger(ControllerMain.class.getName());
	
	public static User generateUser(int id, String name, String nickname,
			String pass) {

		User user = new User();

		user.setId(id);
		user.setName(name);
		user.setNickname(nickname);
		user.setPass(pass);

		return user;
	}

	public static Goal generateGoal(int id, String title, String description,
			Priority priority1) {
		Goal goal = new Goal();

		goal.setId(id);
		goal.setTitle(title);
		goal.setDescription(description);
		goal.setPrioriry(priority1);

		return goal;
	}

	public static Priority generatePriority(int id, String name, String image) {
		Priority priority = new Priority();

		priority.setId(id);
		priority.setName(name);
		priority.setImage(image);

		return priority;
	}

	public static GoalAction generateGoalAction(int id, String title,
			String group, String description, Priority priority,
			ActionLable actionLable, ActionType actionType) {
		GoalAction goalAction = new GoalAction();
		goalAction.setActionGroup(group);
		goalAction.setActionLable(actionLable);
		goalAction.setDescription(description);
		goalAction.setId(id);
		goalAction.setPriority(priority);
		goalAction.setTitle(title);
		goalAction.setType(actionType);

		return goalAction;
	}

	public static ActionType generateActionType(int id, String name,
			String image) {
		ActionType actionType = new ActionType();

		actionType.setId(id);
		actionType.setName(name);
		actionType.setImage(image);

		return actionType;
	}

	public static ActionLable generateActionLable(int id, String name,
			String description) {
		ActionLable actionLable = new ActionLable();

		actionLable.setId(id);
		actionLable.setName(name);
		actionLable.setDescription(description);

		return actionLable;
	}

	public static User generateDefaultUser() {
		return generateUser(1, "Vlad", "vovan", "pass");
	}

	public static Goal generateDefaultGoal() {
		return generateGoal(1, "bestGoal", "my goal", generateDefaultPriority());
	}

	public static Priority generateDefaultPriority() {
		return generatePriority(1, "hight", "image_url");
	}

	public static GoalAction generateDefaultGoalAction() {
		return generateGoalAction(1, "goal action", "action group",
				"action desc", generateDefaultPriority(),
				generateDefaultActionLable(), generateDefaultActionType());
	}

	public static ActionType generateDefaultActionType() {
		return generateActionType(1, "actionType", "imagetype_url");
	}

	public static ActionLable generateDefaultActionLable() {
		return generateActionLable(1, "actionLable", "my act lable desc");
	}

	public static void printToConsole(Object objToPrint) {
		ObjectMapper mapper = new ObjectMapper();
		LOGGER.log(Level.INFO, "---------- printToConsole -------------");
		//
		try {
			mapper.writeValue(System.out, objToPrint);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
