package se.jopa.pyfo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import se.jopa.pifo.core.dao.PiDao;
import se.jopa.pifo.core.model.Actuator;

public class ActuatorResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;

	public ActuatorResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}

	// Application integration
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Actuator getActuator() {
		Actuator actuator = PiDao.instance.getActuator(id);
		if (actuator == null)
			throw new RuntimeException("Get: Actuator with " + id
					+ " not found");
		return actuator;
	}

	// for the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public Actuator getActuatorHTML() {
		Actuator actuator = PiDao.instance.getActuator(id);
		if (actuator == null)
			throw new RuntimeException("Get: Actuator with " + id
					+ " not found");
		return actuator;
	}

	// @PUT
	// @Consumes(MediaType.APPLICATION_XML)
	// public Response putTodo(JAXBElement<Sensor> sensor) {
	// Sensor c = sensor.getValue();
	// return putAndGetResponse(c);
	// }

	// @DELETE
	// public void deleteTodo() {
	// Sensor c = PiDao.instance.getModel().remove(id);
	// if(c==null)
	// throw new RuntimeException("Delete: Todo with " + id + " not found");
	// }

	// private Response putAndGetResponse(Sensor sensor) {
	// Response res;
	// if(PiDao.instance.getModel().containsKey(sensor.getId())) {
	// res = Response.noContent().build();
	// } else {
	// res = Response.created(uriInfo.getAbsolutePath()).build();
	// }
	// PiDao.instance.getModel().put(sensor.getId(), sensor);
	// return res;
	// }

}
