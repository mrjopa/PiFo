package se.jopa.pifo.hub.client;

import se.jopa.pifo.core.model.Pi;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("pifo")
public interface PiFoService extends RemoteService {
  Pi getPi(String host) throws IllegalArgumentException;
}