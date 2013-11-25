/**
 * 
 */
package se.jopa.pifo.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author jopa
 *
 */
@XmlRootElement
@XmlType(propOrder = { "ip", "name", "sensors", "actuators" })
public class Pi implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ip;
	private String name;
	private List<Sensor> sensors = new ArrayList<Sensor>();
	private List<Actuator> actuators = new ArrayList<Actuator>();
	
	public Pi() {
	}
	
	public Pi(String ip, String name) {
		this.setIp(ip);
		this.setName(name);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	//@XmlElementWrapper(name = "sensorList")
	@XmlElement(name = "sensor")
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	public List<Actuator> getActuators() {
		return actuators;
	}

	//@XmlElementWrapper(name = "actuatorList")
	@XmlElement(name = "actuator")
	public void setActuators(List<Actuator> actuators) {
		this.actuators = actuators;
	}
}
