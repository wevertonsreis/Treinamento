package com.system.forms;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.system.models.ItemRequest;
import com.system.models.Product;
import com.system.models.Request;
import com.system.validations.Cnpj;

public class AddProductForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -495195036931344735L;
	private Request req;
	private String cnpj;
	private List<Product> listProducts = new ArrayList<Product>();
	private Integer quantity;
	private Long id;
	private List<ItemRequest> listItems = new ArrayList<ItemRequest>();
	private List<Request> listRequest = new ArrayList<Request>();
	private double total;
	private String creator;
	private String selectId;
	
	public String getSelectId() {
		return selectId;
	}

	public void setSelectId(String selectId) {
		this.selectId = selectId;
	}

	public String getCreator() {
		return creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public List<Request> getListRequest() {
		return listRequest;
	}
	
	public void setListRequest(List<Request> listRequest) {
		this.listRequest = listRequest;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public double getTotal() {
		return total;
	}
		
	public List<ItemRequest> getListItems() {
		return listItems;
	}
	
	public void setListItems(List<ItemRequest> listItems) {
		this.listItems = listItems;
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

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@SuppressWarnings("unused")
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		quantity = null;
		for(Product p : listProducts){
			p = null;
		}
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();
		
		try{
			if(quantity < 1){
				errors.add("quantity", new ActionMessage("error.quantity.required"));
				return errors;
			}
			if(request.getParameter("id").equals("0")){
				errors.add("product", new ActionMessage("error.product.required"));
				return errors;
			}
			if(cnpj.length() < 1){
				errors.add("cnpj", new ActionMessage("error.cnpj.required"));
				return errors;
			}
			if(!Cnpj.validation(cnpj.toString())){
				errors.add("cnpj", new ActionMessage("error.cnpj.invalid"));
				return errors;
			}else{
				return errors;
			}	
			
		}catch(NullPointerException ne){
			ne.getMessage();
		}
		
		return errors;
	}
	
}
