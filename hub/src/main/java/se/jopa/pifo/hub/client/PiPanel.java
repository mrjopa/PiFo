package se.jopa.pifo.hub.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * The top panel, which contains the 'welcome' message and various links.
 */
public class PiPanel extends Composite {

  interface Binder extends UiBinder<Widget, PiPanel> { }
  private static final Binder binder = GWT.create(Binder.class);



  public PiPanel() {
    initWidget(binder.createAndBindUi(this));
  }
}