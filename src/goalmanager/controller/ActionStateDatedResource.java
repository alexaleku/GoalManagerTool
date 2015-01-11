package goalmanager.controller;

import goalmanager.beans.ActionStateDated;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class ActionStateDatedResource {
	int id;

	public ActionStateDatedResource(int id) {
		this.id = id;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public ActionStateDated getAction() {
		return null;
	}
}
