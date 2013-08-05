package com.system.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.system.models.ItemRequest;
import com.system.persistence.HibernateUtil;

public class RemoveItemAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * Removing an item request.
		 */
		try {
			Session session = HibernateUtil.currentSession();
			Transaction tx= session.beginTransaction();		
			
			Query queryItem = session.createQuery("from ItemRequest i where i.id = :id");
			queryItem.setString("id", request.getParameter("id").toString());
			
			ItemRequest itemReq = (ItemRequest) queryItem.uniqueResult();	
			
			session.delete(itemReq);
			
			tx.commit();
			HibernateUtil.closeSession();
		
		} 
		catch (Exception e) {
			e.getMessage();
		}
		
		return mapping.findForward("loadItemsRequest");
	}
}
