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
import se.jopa.pifo.core.model.Sensor;

@Path("/pi/sensors")
public class SensorsResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	public SensorsResource() {
		System.out.println("SensorsResource::");
	}

	// @GET
	// @Produces(MediaType.TEXT_PLAIN)
	// public String getPi() {
	// return "Sensors";
	// }

	// Return the list of todos to the user in the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Sensor> getSensorBrowser() {
		List<Sensor> sensors = new ArrayList<Sensor>();
		sensors.addAll(PiDao.instance.getPi().getSensors());
		return sensors;
	}

	// retuns the number of todos
	// use http://localhost:8080/de.vogella.jersey.todo/rest/todos/count
	// to get the total number of records
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = PiDao.instance.getPi().getSensors().size();
		return String.valueOf(count);
	}

	// Defines that the next path parameter after todos is
	// treated as a parameter and passed to the TodoResources
	// Allows to type http://localhost:8080/de.vogella.jersey.todo/rest/todos/1
	// 1 will be treaded as parameter todo and passed to TodoResource
	@Path("{sensor}")
	public SensorResource getSensor(@PathParam("sensor") String id) {
		return new SensorResource(uriInfo, request, id);
	}
}
