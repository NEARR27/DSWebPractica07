/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author near27
 */
public class HibernateUtil {
    
     private static final SessionFactory sessionFactory;
    private HibernateUtil(){     
    }
    static{
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession(){
        return sessionFactory.openSession();
    }
    
    public static void shutdown() {
    if (sessionFactory != null && !sessionFactory.isClosed()) {
        sessionFactory.close();
    }
}
    
}
