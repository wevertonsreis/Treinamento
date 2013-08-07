package com.actions;

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

import com.forms.RegisterForm;
import com.model.Contact;
import com.persistence.HibernateUtil;

public class RegisterAction extends DispatchAction {
	
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RegisterForm registerForm = (RegisterForm) form;
		
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		Contact contact = new Contact();
		contact.setName(registerForm.getName());
		contact.setFone(registerForm.getFone());
		
		session.save(contact);
		
		tx.commit();
		session.close();
		
		return mapping.getInputForward();
	}
	
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("Unspecifield");
		return mapping.getInputForward();
	}

}
