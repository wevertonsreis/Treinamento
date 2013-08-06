package com.system.actions;

import java.util.List;

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
import com.system.models.Request;
import com.system.persistence.HibernateUtil;

public class AlterRequestAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * Searching request in database and preparing the screen for edition.
		 */
		AddProductForm loadRequestForm = (AddProductForm) form;
		
		try {
			Session session = HibernateUtil.currentSession();
			Transaction tx= session.beginTransaction();		

			//Searching request where id equal select id in jsp page.
			Query query = session.createQuery("From Request r where r.id=:id");
			query.setParameter("id", request.getParameter("id").toString());
			
			//Returning only one result.
			Request req = (Request) query.uniqueResult();
			
			//But if request is okay, You can't alter.
			if(req.getStatus().equals("Aprovado")){
				return mapping.findForward("errorAlterRequest");
			}
			
			//Setting form with new request.
			loadRequestForm.setReq(req);
			
			//Searching items of request in database. 
			Query queryI = session.createQuery("From ItemRequest i where i.req.id= :request");
			queryI.setParameter("request", loadRequestForm.getReq().getId());
			
			//Adding items for one list.
			@SuppressWarnings("unchecked")
			List<ItemRequest> list = queryI.list();
			
			//Sum total of items.
			double total = 0;
			for(ItemRequest i : list){
				i.setValueProducts(i.getQuantity()*i.getProduct().getUnitaryValue());
				total = i.getValueProducts() + total;
			}
			
			//Adding this sum for form.
			loadRequestForm.setTotal(total);
			
			//Setting form with the list items.
			loadRequestForm.setListItems(list);

			tx.commit();
			HibernateUtil.closeSession();
						
		} 
		catch (Exception e) {
				e.getMessage();
		}	
		//Go to action responsible for loading products.
		return mapping.findForward("loadProduct");
	}
}
