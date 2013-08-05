package com.system.persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Log log = LogFactory.getLog(HibernateUtil.class);

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @SuppressWarnings("rawtypes")
	public static final ThreadLocal session = new ThreadLocal();

    @SuppressWarnings("unchecked")
	public static Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        
        if (s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    @SuppressWarnings("unchecked")
	public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        session.set(null);
        
        if (s != null)
            s.close();
    } 
}