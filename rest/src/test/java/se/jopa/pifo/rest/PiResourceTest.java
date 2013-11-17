/**
 * 
 */
package se.jopa.pifo.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.jopa.pifo.core.model.Pi;
import se.jopa.pyfo.rest.Main;
import static org.junit.Assert.assertEquals;

/**
 * @author jopa
 *
 */

public class PiResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
    	
        String responseMsgXml = target.path("pi").request(MediaType.APPLICATION_XML).get(String.class);
        System.out.println(responseMsgXml);
    
        String responseMsgJson = target.path("pi").request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(responseMsgJson);

        
        Pi pi = target.path("pi").request(MediaType.APPLICATION_JSON).get(Pi.class);
        System.out.println(pi.getIp());
        //assertEquals("Got it!", responseMsg);
        
        
//        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
//
//        if (response.getStatus() == 200) {      
//           return response.readEntity(JSONObject.class);
//        }        
        
        
    }
}
