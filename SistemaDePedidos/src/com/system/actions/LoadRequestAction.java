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
import com.system.models.Request;
import com.system.persistence.HibernateUtil;

public class LoadRequestAction extends Action {
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AddProductForm loadRequestForm = (AddProductForm) form;
		
		try{
			loadRequestForm.setCreator(request.getAttribute("username").toString());
		}
		catch(NullPointerException ne){
			
		}
		
		Session session = HibernateUtil.currentSession();
		Transaction tx= session.beginTransaction();		
		
		try{
			Query query = session.createQuery("From Request r where r.creator= :creator");
			query.setParameter("creator", loadRequestForm.getCreator());

			@SuppressWarnings("unchecked")
			List<Request> list = query.list();

			loadRequestForm.setListRequest(list);

			tx.commit();
			HibernateUtil.closeSession();
		}
		catch(NullPointerException ne){
			tx.commit();
			HibernateUtil.closeSession();
		}

		return mapping.findForward("requests");
		
	}

}
