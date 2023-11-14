/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas.dao;

import com.uv.IDAOGeneral;
import ventas.clases.Producto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import com.uv.HibernateUtil;
/**
 *
 * @author near
 */
public class productoDAO implements IDAOGeneral<Producto,Long> {
    
    @Override
    public Producto create(Producto producto) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(producto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return producto;
    }

    @Override
    public boolean delete(Long idProducto) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        boolean successful = false;
        try {
            tx = session.beginTransaction();
            Producto producto = session.get(Producto.class, idProducto);
            if (producto != null) {
                session.delete(producto);
                successful = true;
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return successful;
    }

    @Override
    public Producto update(Long idProducto, Producto productoNuevo) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Producto productoExistente = null;
        try {
            tx = session.beginTransaction();
            productoExistente = session.get(Producto.class, idProducto);
            if (productoExistente != null) {
                productoExistente.setDescripcion(productoNuevo.getDescripcion());
                productoExistente.setPrecio(productoNuevo.getPrecio());
                session.update(productoExistente);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return productoExistente;
    }

    @Override
    public List<Producto> findAll() {
        Session session = HibernateUtil.getSession();
        List<Producto> productos = null;
        try {
            productos = session.createQuery("from Producto", Producto.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return productos;
    }

    @Override
    public Producto findById(Long idProducto) {
        Session session = HibernateUtil.getSession();
        Producto producto = null;
        try {
            producto = session.get(Producto.class, idProducto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return producto;
    }
}
