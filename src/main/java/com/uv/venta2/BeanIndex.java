/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.venta2;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author near
 */
@Named(value = "beanIndex")
@SessionScoped
public class BeanIndex implements Serializable {

    private ventaDAO ventaDAO;
    private Venta ventaActual;
    private List<VentaDetalle> detallesVenta;
    private Cliente clienteSeleccionado;
    private List<Cliente> listaClientes;
    private List<Producto> listaProductos;
    private List<Producto> productosSeleccionados;
     private ClienteDAO clienteDAO;
     private ProductoDAO productoDAO;

    // Constructor
    public BeanIndex() {
        ventaDAO = new ventaDAO();
        ventaActual = new Venta();
        
    }

    @PostConstruct
    public void init() {
        clienteDAO = new ClienteDAO();
        listaClientes = clienteDAO.findAll(); 
        productoDAO = new ProductoDAO();
        listaProductos = productoDAO.findAll(); 
    }

    
    public void guardarVenta() {
        try {
            
            ventaActual.setCliente(clienteSeleccionado); 
            ventaDAO.guardarVentaConDetalles(ventaActual, detallesVenta);
            
        } catch (Exception e) {
            
        }
    }

    public List<Producto> getProductosSeleccionados() {
        return productosSeleccionados;
    }

    public void setProductosSeleccionados(List<Producto> productosSeleccionados) {
        this.productosSeleccionados = productosSeleccionados;
    }

    
    public Venta getVentaActual() {
        return ventaActual;
    }

    public void setVentaActual(Venta ventaActual) {
        this.ventaActual = ventaActual;
    }

    public List<VentaDetalle> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(List<VentaDetalle> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

}
