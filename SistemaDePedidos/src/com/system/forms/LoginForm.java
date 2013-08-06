package com.system.forms;

import javax.servlet.http.HttpServletRequest;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.system.models.User;
import com.system.persistence.HibernateUtil;
import com.system.validations.SecurityMd5;

@SuppressWarnings("serial")
public class LoginForm extends ActionForm {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.username = null;
		this.password = null;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		/*
		 * Validation of fields, user name and password.
		 */
		ActionErrors errors = new ActionErrors();
		
		if(username == null && password == null){
			errors.add("field", new ActionMessage("error.field.required"));
			return errors;
		}
		
		if(username.length() < 1){
			errors.add("field", new ActionMessage("error.username.required"));
			return errors;
		}
		
		if(password.length() < 1){
			errors.add("field", new ActionMessage("error.password.required"));
			return errors;
		}
		
		try {
			Session session = HibernateUtil.currentSession();
			Transaction tx= session.beginTransaction();				
			Query query = session.createQuery("from User u where u.username = :userName and u.password = :password");
			query.setString("userName", this.getUsername());
			query.setString("password", SecurityMd5.transform(this.getPassword()));
			
			User user = (User) query.uniqueResult();			
			
			try {				
				if(user.getUsername().equals(this.getUsername()) && user.getPassword().equals(SecurityMd5.transform(this.getPassword()))){
					return errors;
				}
			} 
			catch (NullPointerException e) {
				errors.add("field", new ActionMessage("error.password.invalid"));
			}	
			
			tx.commit();
			HibernateUtil.closeSession();
			return errors;
				
		} 
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errors;
	}
}
