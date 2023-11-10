/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.venta2;

import com.uv.HibernateUtil;
import com.uv.IDAOGeneral;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author near
 */
public class ClienteDAO implements IDAOGeneral<Cliente,Integer>{
    
     @Override
    public Cliente create(Cliente cliente) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSession();
        try {
            transaction = session.beginTransaction();
            session.save(cliente);
            transaction.commit();
            return cliente;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; 
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Integer idCliente) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSession();
        try {
            transaction = session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, idCliente);
            if (cliente != null) {
                session.delete(cliente);
                transaction.commit();
                return true;
            }
            return false;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; 
        } finally {
            session.close();
        }
    }

    @Override
    public Cliente update(Integer idCliente, Cliente clienteNuevo) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSession();
        try {
            transaction = session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, idCliente);
            if (cliente != null) {
                cliente.setNombre(clienteNuevo.getNombre());
                cliente.setRfc(clienteNuevo.getRfc());
                
                session.update(cliente);
                transaction.commit();
                return cliente;
            }
            return null;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; 
        } finally {
            session.close();
        }
    }

    @Override
    public List<Cliente> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return session.createQuery("FROM Cliente", Cliente.class).getResultList();
        } catch (HibernateException e) {
            throw e; 
        } finally {
            session.close();
        }
    }

    @Override
    public Cliente findById(Integer idCliente) {
        Session session = HibernateUtil.getSession();
        try {
            return session.get(Cliente.class, idCliente);
        } catch (HibernateException e) {
            throw e; 
        } finally {
            session.close();
        }
    }
    
}
