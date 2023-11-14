/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ventas.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.event.RowEditEvent;
import ventas.clases.Producto;
import ventas.dao.productoDAO;

/**
 *
 * @author near
 */
@Named(value = "productoBean")
@SessionScoped
public class productoBean implements Serializable {

    private Producto producto = new Producto();
    private List<Producto> productos;
    private final productoDAO productoDAO = new productoDAO();

    // Métodos para operaciones CRUD
    public void addProducto() {
        productoDAO.create(producto);
        producto = new Producto();
        loadProductos();
    }

    public void deleteProducto(Long idProducto) {
        productoDAO.delete(idProducto);
        loadProductos();
    }

    public void updateProducto() {
        productoDAO.update(producto.getIdProducto(), producto);
        producto = new Producto();
        loadProductos();
    }

    public void loadProductos() {
        productos = productoDAO.findAll();
    }
    
    @PostConstruct
    public void init() {
        loadProductos();
    }

    public void onRowEdit(RowEditEvent<Producto> event) {
        Producto productoEditado = event.getObject();
        productoDAO.update(productoEditado.getIdProducto(), productoEditado);
        // Opcional: Agregar mensaje de confirmación
    }

    // Getters y Setters
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

}
