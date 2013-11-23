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
	
    Pi pi_1 = new Pi("127.0.0.1", "Pi_1");

    pi_1.getSensors().add(new Sensor("1", "Thermometer 1", "37"));
    pi_1.getSensors().add(new Sensor("2", "Thermometer 2", "38.5"));
    pi_1.getActuators().add(new Actuator("1", "Pump 1"));
    
    Pi pi_2 = new Pi("192.168.1.64", "Pi_2");

    pi_2.getSensors().add(new Sensor("1", "Thermometer 11", "42.3"));
    pi_2.getSensors().add(new Sensor("2", "Thermometer 22", "41.5"));
    pi_2.getActuators().add(new Actuator("1", "Pump 11"));    
    
    contentProvider.add(pi_1);
    contentProvider.add(pi_2);
  }
  
  public List<Pi> getModel(){
    return contentProvider;
  }
  
  public Pi getPi() {
	  return getModel().get(0);
  }
  
  public Sensor getSensor(String id) {
	  Sensor sensor = null;
	  
	  for(Sensor s : getPi().getSensors()) {
		  if(s.getId().equals(id)) {
			  sensor = s;
			  break;
		  }
	  }
	  
	  return sensor;
  }
  
} 