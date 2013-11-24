package se.jopa.pifo.hub.client;

import se.jopa.pifo.core.model.Pi;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * The top panel, which contains the 'welcome' message and various links.
 */
public class PiPanel extends Composite {

	Pi pi = new Pi();
  interface Binder extends UiBinder<Widget, PiPanel> { }
  private static final Binder binder = GWT.create(Binder.class);

  PiFoServiceAsync piFoServiceAsync = null;


  public PiPanel(PiFoServiceAsync piFoServiceAsync) {
    initWidget(binder.createAndBindUi(this));
    
    this.piFoServiceAsync = piFoServiceAsync;
  }
  
  @UiHandler("refreshButton")
  void onSignOutClicked(ClickEvent event) {
	  System.out.println("refreshButton -->");
	  
	  piFoServiceAsync.getPi("host", new AsyncCallback<String>() {
          public void onFailure(Throwable caught) {
            // Show the RPC error message to the user
        	  System.out.println("Error: " + caught.getMessage());
//            dialogBox.setText("Remote Procedure Call - Failure");
//            serverResponseLabel.addStyleName("serverResponseLabelError");
//            serverResponseLabel.setHTML(SERVER_ERROR);
//            dialogBox.center();
//            closeButton.setFocus(true);
          }

          public void onSuccess(String result) {
        	  System.out.println("Success");
        	  
//            dialogBox.setText("Remote Procedure Call");
//            serverResponseLabel.removeStyleName("serverResponseLabelError");
//            serverResponseLabel.setHTML(result);
//            dialogBox.center();
//            closeButton.setFocus(true);
          }
        });
  }
}
