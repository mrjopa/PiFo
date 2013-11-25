package se.jopa.pifo.hub.client;

import se.jopa.pifo.core.model.Pi;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * The top panel, which contains the 'welcome' message and various links.
 */
public class PiPanel extends Composite {
	@UiField Label ipLabel;
	@UiField Label nameLabel;
	
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
	  
	  piFoServiceAsync.getPi("host", new AsyncCallback<Pi>() {
          public void onFailure(Throwable caught) {
        	  System.out.println("Error: " + caught.getMessage());
           }

          public void onSuccess(Pi result) {
        	  pi = result;
        	  System.out.println("Success: " + result.getName());
          	  
        	  ipLabel.setText(result.getIp());
        	  nameLabel.setText(result.getName());
          }
        });
  }
}
