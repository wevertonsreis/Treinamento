package com.system.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Request implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cnpj;
	private String cnpjClient;
	private String status;
	private String creator;
	private Date creationDate;
	private Date emissionDate;
	private List<ItemRequest> itemsRequest;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getCnpjClient() {
		return cnpjClient;
	}
	
	public void setCnpjClient(String cnpjClient) {
		this.cnpjClient = cnpjClient;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCreator() {
		return creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Date getEmissionDate() {
		return emissionDate;
	}
	
	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}
	
	public List<ItemRequest> getItemsRequest() {
		return itemsRequest;
	}
	
	public void setItemsRequest(List<ItemRequest> itemsRequest) {
		this.itemsRequest = itemsRequest;
	}
	
}
