package com.system.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.system.forms.AddProductForm;
import com.system.models.ItemRequest;
import com.system.models.Product;
import com.system.persistence.HibernateUtil;

public class AddProductAction extends Action {
	
	//Constant for representation of business.
	private static final String CNPJ = "62807253000129";
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * Adding items in the request.
		 */
		AddProductForm addProductForm = (AddProductForm) form;
		
		try {
			Session session = HibernateUtil.currentSession();
			Transaction tx= session.beginTransaction();		
			
			//Searching products in database.
			Query queryProduct = session.createQuery("From Product where id= :idSelect");
			queryProduct.setString("idSelect", request.getParameter("id").toString());
			
			//Catching a one result in database according with the select option.
			Product p = (Product) queryProduct.uniqueResult();	
					
			//Setting the request in form.
			addProductForm.getReq().setCnpj(CNPJ);
			addProductForm.getReq().setCnpjClient(addProductForm.getCnpj());
			addProductForm.getReq().setCreationDate(new Date());
			addProductForm.getReq().setCreator(addProductForm.getCreator());
			
			//Creating new item request.
			ItemRequest it = new ItemRequest();
			it.setQuantity(addProductForm.getQuantity());	
			it.setProduct(p);	
			it.setReq(addProductForm.getReq());
			
			//Saving item request in database.
			session.saveOrUpdate(it);
			
			//adding item request in form.
			addProductForm.getListItems().add(it);
			
			tx.commit();
			HibernateUtil.closeSession();	
		} 
		catch (Exception e) {
			e.getMessage();
		}
		//Loading page with the new item added.
		return mapping.findForward("loadItemsRequest");
	}
}
