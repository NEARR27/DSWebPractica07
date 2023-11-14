/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ventas.beans;

import com.uv.HibernateUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ventas.clases.Cliente;
import ventas.clases.Producto;
import ventas.clases.Venta;
import ventas.clases.VentaDetalle;

/**
 *
 * @author near
 */
@Named(value = "beanIndex")
@SessionScoped
public class BeanIndex implements Serializable {

    private Venta venta = new Venta();
    private Producto producto = new Producto();
    private int cantidad;
    private List<VentaDetalle> lista = new ArrayList();

    public List<VentaDetalle> getLista() {
        return lista;
    }

    public void setLista(List<VentaDetalle> lista) {
        this.lista = lista;
    }
    
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Venta getVenta() {
        return venta;
    }
    
    public void Agregar(){
        VentaDetalle vet = new VentaDetalle();
        vet.setCantidad(cantidad);
        vet.setProducto(producto);
        this.lista.add(vet);
    }
    
    

}
