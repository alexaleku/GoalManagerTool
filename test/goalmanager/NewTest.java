package goalmanager;

import goalmanager.beans.Credentials;
import goalmanager.beans.Goal;
import goalmanager.beans.User;
import goalmanager.controller.ControllerMain;
import goalmanager.dao.FakeObjectsFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class NewTest {
	@Test
	public void f() {

		new ControllerMain().getGoalListForUserActionsAndStatesIncluded(33);
		Credentials cred = new Credentials();
		Credentials cred1 = new Credentials();
		List<Credentials> list = new ArrayList<>();
		list.add(cred);
		list.add(cred1);
		// User user = DaoFakeData.getUserByID(1);
		//
		// List<Goal> goalList = DaoFakeData.getGoalListForUser(1);
		// for (Goal goal : goalList) {
		//
		// goal.setActionList(DaoFakeData.getActionListForGoalByID(goal.getId()));
		//
		// }
		// user.setGoalList(goalList);
		// ObjectMapper mapper = new ObjectMapper();
		//
		//FakeObjectsFactory.printToConsole(list1);

	}

	@Test(enabled=false)
	public void clientTest() {

		try {

			User st = new User();

			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client
					.resource("http://localhost:9090/JerseyJSONExample/rest/jsonServices/send");

			ClientResponse response = webResource.accept("application/json")
					.type("application/json").post(ClientResponse.class, st);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Server response .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
