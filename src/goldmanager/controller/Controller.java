package goldmanager.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Will map the resource to the URL samples
@Path("/samples")
public class Controller {
	private final static Logger LOGGER = Logger.getLogger(Controller.class.getName());
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		String count = "10";
		LOGGER.log(Level.INFO, "---------- size requested, size is: " + count+ "-------------");
		return String.valueOf(count);
	}
}
