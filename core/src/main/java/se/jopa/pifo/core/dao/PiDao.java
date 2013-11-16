package se.jopa.pifo.core.dao;

import java.util.ArrayList;
import java.util.List;

import se.jopa.pifo.core.model.Actuator;
import se.jopa.pifo.core.model.Pi;
import se.jopa.pifo.core.model.Sensor;

public enum PiDao {
  instance;
  
  private List<Pi> contentProvider = new ArrayList<Pi>();
  
  private PiDao() {
	System.out.println("PiDao");
	
    Pi pi_1 = new Pi("localhost");

    pi_1.getSensors().add(new Sensor("Thermometer 1"));
    pi_1.getSensors().add(new Sensor("Thermometer 2"));
    pi_1.getActuators().add(new Actuator("Pump 1"));
    
    Pi pi_2 = new Pi("168.1.0.67");

    pi_2.getSensors().add(new Sensor("Thermometer 11"));
    pi_2.getSensors().add(new Sensor("Thermometer 22"));
    pi_2.getActuators().add(new Actuator("Pump 11"));    
    
    contentProvider.add(pi_1);
    contentProvider.add(pi_2);
  }
  
  public List<Pi> getModel(){
    return contentProvider;
  }
  
} 