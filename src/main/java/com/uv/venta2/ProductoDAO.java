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
public class ProductoDAO implements IDAOGeneral<Producto, Integer>{
    
     @Override
    public Producto create(Producto producto) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(producto);
            transaction.commit();
            return producto;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            throw e; // Or handle it with a custom exception
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Integer idProducto) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Producto producto = session.get(Producto.class, idProducto);
            if (producto != null) {
                session.delete(producto);
                transaction.commit();
                return true;
            }
            return false;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            throw e; // Or handle it with a custom exception
        } finally {
            session.close();
        }
    }

    @Override
    public Producto update(Integer idProducto, Producto productoNuevo) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Producto producto = session.get(Producto.class, idProducto);
            if (producto != null) {
                producto.setNombre(productoNuevo.getNombre());
                producto.setPrecio(productoNuevo.getPrecio());
                producto.setDescripcion(productoNuevo.getDescripcion());
                // Update other fields if necessary
                session.update(producto);
                transaction.commit();
                return producto;
            }
            return null;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            throw e; // Or handle it with a custom exception
        } finally {
            session.close();
        }
    }

    @Override
    public List<Producto> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return session.createQuery("FROM Producto", Producto.class).getResultList();
        } catch (HibernateException e) {
            throw e; // Or handle it with a custom exception
        } finally {
            session.close();
        }
    }

    @Override
    public Producto findById(Integer idProducto) {
        Session session = HibernateUtil.getSession();
        try {
            return session.get(Producto.class, idProducto);
        } catch (HibernateException e) {
            throw e; // Or handle it with a custom exception
        } finally {
            session.close();
        }
    }
}
