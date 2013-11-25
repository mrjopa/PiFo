package se.jopa.pifo.core.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "id", "name", "value"})
public class Sensor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String value;
	
	public Sensor() {
	}

	public Sensor(String id, String name, String value) {
		this.setId(id);
		this.setName(name);
		this.setValue(value);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
