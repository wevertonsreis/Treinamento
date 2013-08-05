package com.system.actions;

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

public class ListItemsRequestAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AddProductForm addProductForm = (AddProductForm) form;
		
		try {
			Session session = HibernateUtil.currentSession();
			Transaction tx= session.beginTransaction();		
			
			List<ItemRequest> list = addProductForm.getListItems();
			
			double total = 0;
			for(ItemRequest i : list){
				i.setValueProducts(i.getQuantity()*i.getProduct().getUnitaryValue());
				total = i.getValueProducts() + total;
			}
			addProductForm.setTotal(total);
			
			addProductForm.setListItems(list);
			
			addProductForm.getReq().setStatus("Em aberto");
			addProductForm.getReq().setCreator(addProductForm.getCreator());
			session.save(addProductForm.getReq());
			
			for(ItemRequest it : list){
				it.setReq(addProductForm.getReq());
				session.update(it);
			}
			
			tx.commit();
			HibernateUtil.closeSession();
		
		} 
		catch (Exception e) {
			e.getMessage();
		}

		return mapping.getInputForward();
	}
}
