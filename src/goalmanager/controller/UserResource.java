package goalmanager.controller;

import goalmanager.beans.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class UserResource {

	int id;

	public UserResource(int id) {
		this.id = id;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public User getUser() {
		User user = new User();
		user.setName("hey user Workds id: " + id);
		return user;
	}

	// for the browser
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public User getTodoHTML() {
//		User user = new User();
//		user.setName("hey this TEXT Workds" + id);
//		return user;
//	}

	// @PUT
	// @Consumes(MediaType.APPLICATION_XML)
	// public Response putTodo(JAXBElement<SavedJsonBean> todo) {
	// SavedJsonBean c = todo.getValue();
	// return putAndGetResponse(c);
	// }
	//
	// @DELETE
	// public void deleteTodo() {
	// boolean c = resourceDao.deleteSample(id);
	// if (!c)
	// throw new RuntimeException("Delete: Todo with " + id + " not found");
	// }

	// private Response putAndGetResponse(SavedJsonBean todo) {
	// Response res;
	// if (resourceDao.getContentProviderModel().containsKey(todo.getId())) {
	// res = Response.noContent().build();
	// } else {
	// res = Response.created(uriInfo.getAbsolutePath()).build();
	// }
	// resourceDao.getContentProviderModel().put(todo.getId(), todo);
	// return res;
	// }

}
