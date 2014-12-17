package goalmanager.beans;

import java.util.List;

public class GoalAction {
	private int id;
	private String title;
	private ActionLable actionLable;
	private String actionGroup;
	private String description;
	private Priority priority;
	private ActionType type;
	private List<ActionStateDated> datedStateList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ActionLable getActionLable() {
		return actionLable;
	}

	public void setActionLable(ActionLable actionLable) {
		this.actionLable = actionLable;
	}

	public String getActionGroup() {
		return actionGroup;
	}

	public void setActionGroup(String actionGroup) {
		this.actionGroup = actionGroup;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public ActionType getType() {
		return type;
	}

	public void setType(ActionType type) {
		this.type = type;
	}

	public List<ActionStateDated> getDatedStateList() {
		return datedStateList;
	}

	public void setDatedStateList(List<ActionStateDated> datedStateList) {
		this.datedStateList = datedStateList;
	}

}
