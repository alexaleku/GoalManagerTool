package goalmanager.controller;

import goalmanager.beans.Goal;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class GoalResource {

	int id;

	public GoalResource(int id) {
		this.id = id;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Goal getGoal() {
		Goal goal = new Goal();
		goal.setTitle("hey goal Workds id: " + id);
		return goal;
	}
}
