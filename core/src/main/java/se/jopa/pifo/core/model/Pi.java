/**
 * 
 */
package se.jopa.pifo.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author jopa
 *
 */
@XmlRootElement
@XmlType(propOrder = { "name", "sensors", "actuators" })
public class Pi {

	/**
	 * 
	 */
	
	private String name;
	//@XmlElementWrapper(name = "sensors")
	//@XmlElement(name = "sensor")
	private List<Sensor> sensors = new ArrayList<Sensor>();
	private List<Actuator> actuators = new ArrayList<Actuator>();
	
	public Pi() {
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
