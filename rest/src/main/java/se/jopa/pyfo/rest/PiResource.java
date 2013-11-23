package se.jopa.pyfo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import se.jopa.pifo.core.dao.PiDao;
import se.jopa.pifo.core.model.Pi;

@Path("pi")
public class PiResource {
	private Pi pi;
	
	public PiResource() {
		System.out.println("PiResource::");

    	pi = PiDao.instance.getPi();
    	System.out.println(pi);
	}

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPi() {
		System.out.println("PiResource::");    	
        return "Name: " + pi.getName();
    }
    
    @GET
    @Produces(MediaType.TEXT_XML)
    public Pi getPiXml() { 
        return pi;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Pi getPiApplicationXml() { 
        return pi;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Pi getPiJson() {
        return pi;
    }
}
