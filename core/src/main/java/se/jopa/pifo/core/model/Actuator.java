package se.jopa.pifo.core.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Actuator {

	private String name;
	
	public Actuator() {
		
	}

	public Actuator(String name) {
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
	
}
