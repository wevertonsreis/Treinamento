package com.system.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.system.forms.AddProductForm;
import com.system.persistence.HibernateUtil;

public class SaveRequestAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AddProductForm addProductForm = (AddProductForm) form;
		
		try {
			Session session = HibernateUtil.currentSession();
			Transaction tx= session.beginTransaction();		
			
			addProductForm.setCnpj(request.getParameter("cnpj").toString());
			
			tx.commit();
			HibernateUtil.closeSession();
		
		} 
		catch (Exception e) {
			e.getMessage();
		}
					
		return mapping.findForward("loadRequest");
	
	}
}
