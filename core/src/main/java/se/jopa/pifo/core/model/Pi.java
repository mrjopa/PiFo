/**
 * 
 */
package se.jopa.pifo.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author jopa
 *
 */
@XmlRootElement
public class Pi {

	/**
	 * 
	 */
	
	private String name;
	private List<Sensor> sensors = null;
	private List<Actuator> actuators = null;
	
	public Pi() {
		setSensors(new ArrayList<Sensor>());
		setActuators(new ArrayList<Actuator>());
		
		sensors.add(new Sensor("Thermometer 1"));
		sensors.add(new Sensor("Thermometer 2"));
		
		actuators.add(new Actuator("Pump 1"));
		
	}
	
	public Pi(String name) {
		this.setName(name);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sensors
	 */
	public List<Sensor> getSensors() {
		return sensors;
	}

	/**
	 * @param sensors the sensors to set
	 */
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	/**
	 * @return the actuators
	 */
	public List<Actuator> getActuators() {
		return actuators;
	}

	/**
	 * @param actuators the actuators to set
	 */
	public void setActuators(List<Actuator> actuators) {
		this.actuators = actuators;
	}

}
