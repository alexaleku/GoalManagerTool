package goalmanager.controller;

import goalmanager.beans.GoalAction;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class ActionResource {
	int id;

	public ActionResource(int id) {
		this.id = id;
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public GoalAction getAction() {
		GoalAction goalAction = new GoalAction();
		goalAction.setTitle("hey action Workds id: " + id);
		return goalAction;
	}
}
