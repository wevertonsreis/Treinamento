package com.system.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.system.forms.AddProductForm;
import com.system.models.Product;
import com.system.persistence.HibernateUtil;

public class LoadProductAction extends DispatchAction {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		/*
		 * Searching products in the database.
		 */
		AddProductForm addProductForm = (AddProductForm) form;
		
		Session session = HibernateUtil.currentSession();
		Transaction tx= session.beginTransaction();				

		Query query = session.createQuery("from Product");
		
		@SuppressWarnings("unchecked")
		List<Product> results = query.list();

		addProductForm.setListProducts(results);	

		tx.commit();
		HibernateUtil.closeSession();
		return mapping.findForward("index");
		
	}
}
