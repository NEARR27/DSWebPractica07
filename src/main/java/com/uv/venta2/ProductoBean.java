/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.venta2;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


/**
 *
 * @author near
 */
@Named(value = "productoBean")
@SessionScoped
public class ProductoBean implements Serializable {
    
    private ProductoDAO productoDAO;
    private Producto productoSeleccionado;
    private List<Producto> listaProductos;

    public ProductoBean() {
        productoDAO = new ProductoDAO();
        productoSeleccionado = new Producto();
        cargarListaProductos();
    }

    private void cargarListaProductos() {
        listaProductos = productoDAO.findAll();
    }

    public void createProducto() {
        productoDAO.create(productoSeleccionado);
        productoSeleccionado = new Producto(); 
        cargarListaProductos();
    }

    public void updateProducto() {
        productoDAO.update(productoSeleccionado.getIdProducto(), productoSeleccionado);
        cargarListaProductos();
    }

    public void deleteProducto() {
        if (productoSeleccionado != null && productoSeleccionado.getIdProducto() != 0) {
            productoDAO.delete(productoSeleccionado.getIdProducto());
            productoSeleccionado = new Producto(); 
            cargarListaProductos();
        }
    }

    
    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Producto producto) {
        this.productoSeleccionado = producto;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
