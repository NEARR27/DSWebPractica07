/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.venta2;

import com.uv.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author near
 */
public class ventaDAO {
    
     public void guardarVentaConDetalles(Venta venta, List<VentaDetalle> detallesVenta) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSession();
        try {
            transaction = session.beginTransaction();
            
            
            if (venta.getCliente() != null && venta.getCliente().getIdCliente() > 0) {
                Cliente cliente = session.get(Cliente.class, venta.getCliente().getIdCliente());
                venta.setCliente(cliente);
            }
            
            
            session.saveOrUpdate(venta);
            
            
            for (VentaDetalle detalle : detallesVenta) {
                if (detalle.getProducto() != null && detalle.getProducto().getIdProducto() > 0) {
                    Producto producto = session.get(Producto.class, detalle.getProducto().getIdProducto());
                    detalle.setProducto(producto);
                }
                detalle.setVenta(venta); 
                session.saveOrUpdate(detalle); 
            }
            
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e; 
        } finally {
            session.close();
        }
    }
}
