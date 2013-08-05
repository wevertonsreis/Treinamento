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
		
		AddProductForm loadRequestForm = (AddProductForm) form;
		
		try {
			Session session = HibernateUtil.currentSession();
			Transaction tx= session.beginTransaction();		

			Query query = session.createQuery("From Request r where r.id=:id");

			query.setParameter("id", request.getParameter("id").toString());

			Request req = (Request) query.uniqueResult();

			if(req.getStatus().equals("Aprovado")){
				return mapping.findForward("errorAlterRequest");
			}

			loadRequestForm.setReq(req);

			Query queryI = session.createQuery("From ItemRequest i where i.req.id= :request");
			queryI.setParameter("request", loadRequestForm.getReq().getId());

			@SuppressWarnings("unchecked")
			List<ItemRequest> list = queryI.list();

			double total = 0;
			for(ItemRequest i : list){
				i.setValueProducts(i.getQuantity()*i.getProduct().getUnitaryValue());
				total = i.getValueProducts() + total;
			}

			loadRequestForm.setTotal(total);

			loadRequestForm.setListItems(list);

			tx.commit();
			HibernateUtil.closeSession();
						
		} 
		catch (Exception e) {
				e.getMessage();
		}	
		return mapping.findForward("loadProduct");
	}
}
