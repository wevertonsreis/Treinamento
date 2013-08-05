package com.system.models;

import java.io.Serializable;

public class ItemRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private int quantity;
	private double valueProducts;
	private Product product;
	private Request req;
	
	public void setValueProducts(double valueProducts) {
		this.valueProducts = valueProducts;
	}
	
	public double getValueProducts() {
		return valueProducts;
	}
	
	public Request getReq() {
		return req;
	}
	
	public void setReq(Request req) {
		this.req = req;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
