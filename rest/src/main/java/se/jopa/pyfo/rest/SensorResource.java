package se.jopa.pyfo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import se.jopa.pifo.core.dao.PiDao;
import se.jopa.pifo.core.model.Sensor;

public class SensorResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;

	public SensorResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}

	  //Application integration     
	  @GET
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Sensor getSensor() {
	    Sensor sensor = PiDao.instance.getSensor(id);
	    if(sensor==null)
	      throw new RuntimeException("Get: Sensor with " + id +  " not found");
	    return sensor;
	  }
	  
	  // for the browser
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public Sensor getSensorHTML() {
	    Sensor sensor = PiDao.instance.getSensor(id);
	    if(sensor==null)
	      throw new RuntimeException("Get: Sensor with " + id +  " not found");
	    return sensor;
	  }
	  
//	  @PUT
//	  @Consumes(MediaType.APPLICATION_XML)
//	  public Response putTodo(JAXBElement<Sensor> sensor) {
//	    Sensor c = sensor.getValue();
//	    return putAndGetResponse(c);
//	  }
	  
//	  @DELETE
//	  public void deleteTodo() {
//	    Sensor c = PiDao.instance.getModel().remove(id);
//	    if(c==null)
//	      throw new RuntimeException("Delete: Todo with " + id +  " not found");
//	  }
	  
//	  private Response putAndGetResponse(Sensor sensor) {
//	    Response res;
//	    if(PiDao.instance.getModel().containsKey(sensor.getId())) {
//	      res = Response.noContent().build();
//	    } else {
//	      res = Response.created(uriInfo.getAbsolutePath()).build();
//	    }
//	    PiDao.instance.getModel().put(sensor.getId(), sensor);
//	    return res;
//	  }
	  
}
