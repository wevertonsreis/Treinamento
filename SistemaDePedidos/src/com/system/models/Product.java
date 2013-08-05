package com.system.models;

import java.io.Serializable;

public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String description;
	private double unitaryValue;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String description, double unitaryValue) {
		super();
		this.id = id;
		this.description = description;
		this.unitaryValue = unitaryValue;
	}

	public double getUnitaryValue() {
		return unitaryValue;
	}
	
	public void setUnitaryValue(double unitaryValue) {
		this.unitaryValue = unitaryValue;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
