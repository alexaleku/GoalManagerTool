package goalmanager.beans;

import java.util.List;

public class Goal {
	private int id;
	private String title;
	private String description;
	private Priority prioriry;
	private List<GoalAction> actionList;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Priority getPrioriry() {
		return prioriry;
	}

	public void setPrioriry(Priority prioriry) {
		this.prioriry = prioriry;
	}

	public List<GoalAction> getActionList() {
		return actionList;
	}

	public void setActionList(List<GoalAction> actionList) {
		this.actionList = actionList;
	}

}
