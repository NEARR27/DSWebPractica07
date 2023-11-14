/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas.dao;

import com.uv.HibernateUtil;
import com.uv.IDAOGeneral;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ventas.clases.Cliente;
import java.util.List;

/**
 *
 * @author near
 */
public class ClienteDAO implements IDAOGeneral<Cliente, Integer>{
    
     @Override
    public Cliente create(Cliente cliente) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(cliente);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cliente;
    }

    @Override
    public boolean delete(Integer idCliente) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        boolean successful = false;
        try {
            tx = session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, idCliente);
            if (cliente != null) {
                session.delete(cliente);
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
    public Cliente update(Integer idCliente, Cliente clienteNuevo) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Cliente clienteExistente = null;
        try {
            tx = session.beginTransaction();
            clienteExistente = session.get(Cliente.class, idCliente);
            if (clienteExistente != null) {
                clienteExistente.setNombre(clienteNuevo.getNombre());
                clienteExistente.setRfc(clienteNuevo.getRfc());
                // Actualizar otros campos si es necesario
                session.update(clienteExistente);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clienteExistente;
    }

    @Override
    public List<Cliente> findAll() {
        Session session = HibernateUtil.getSession();
        List<Cliente> clientes = null;
        try {
            clientes = session.createQuery("from Cliente", Cliente.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clientes;
    }

    @Override
    public Cliente findById(Integer idCliente) {
        Session session = HibernateUtil.getSession();
        Cliente cliente = null;
        try {
            cliente = session.get(Cliente.class, idCliente);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cliente;
    }
    
}
