package com.system.actions;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

public class NewRequestAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		/*
		 * Creating a new request.
		 */
		AddProductForm addProductForm = (AddProductForm) form;
		
		Session session = HibernateUtil.currentSession();
		Transaction tx= session.beginTransaction();		
		
		Request req = new Request();
		addProductForm.setReq(req);
		addProductForm.getReq().setCreationDate(new Date());
		addProductForm.getReq().setStatus("Em aberto");
		addProductForm.getReq().setCreator(addProductForm.getCreator());
		session.save(addProductForm.getReq());

		tx.commit();
		HibernateUtil.closeSession();

		addProductForm.setListItems(new ArrayList<ItemRequest>());
		addProductForm.setTotal(0);
					
		return mapping.findForward("loadProduct");

	}

}
