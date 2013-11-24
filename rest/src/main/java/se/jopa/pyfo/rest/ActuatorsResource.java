package se.jopa.pyfo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import se.jopa.pifo.core.dao.PiDao;
import se.jopa.pifo.core.model.Actuator;

@Path("/pi/actuators")
public class ActuatorsResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	public ActuatorsResource() {
		System.out.println("ActuatorsResource::");
	}

	// @GET
	// @Produces(MediaType.TEXT_PLAIN)
	// public String getPi() {
	// return "Sensors";
	// }

	// Return the list of todos to the user in the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Actuator> getActuatorsBrowser() {
		List<Actuator> actuators = new ArrayList<Actuator>();
		actuators.addAll(PiDao.instance.getPi().getActuators());
		return actuators;
	}

	// retuns the number of todos
	// use http://localhost:8080/de.vogella.jersey.todo/rest/todos/count
	// to get the total number of records
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = PiDao.instance.getPi().getActuators().size();
		return String.valueOf(count);
	}

	// Defines that the next path parameter after todos is
	// treated as a parameter and passed to the TodoResources
	// Allows to type http://localhost:8080/de.vogella.jersey.todo/rest/todos/1
	// 1 will be treaded as parameter todo and passed to TodoResource
	@Path("{actuator}")
	public ActuatorResource getActuator(@PathParam("actuator") String id) {
		return new ActuatorResource(uriInfo, request, id);
	}
}
