package com.system.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.system.persistence.HibernateUtil;

public class EndRequestAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AddProductForm addProductForm = (AddProductForm) form;
		
		if(addProductForm.getListItems().isEmpty()){
			return mapping.findForward("errorEndRequest");
		}
		
		try {
			Session session = HibernateUtil.currentSession();
			Transaction tx= session.beginTransaction();		
			
			List<ItemRequest> list = addProductForm.getListItems();
			
			for(ItemRequest it : list){
				it.getReq().setCnpj("62807253000129");
				it.getReq().setEmissionDate(new Date());
				it.getReq().setStatus("Aprovado");
				it.getReq().setCreator(addProductForm.getCreator());
				it.getReq().setCnpjClient(addProductForm.getCnpj());
				session.saveOrUpdate(it.getReq());
				session.saveOrUpdate(it);
			}
			
			tx.commit();
			HibernateUtil.closeSession();
		
		} 
		catch (Exception e) {
			e.getMessage();
		}
		
		addProductForm.setListItems(new ArrayList<ItemRequest>());
		addProductForm.setTotal(0);
		
		return mapping.findForward("okEndRequest");
	}

}
