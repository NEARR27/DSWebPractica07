/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ventas.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
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
    }

    public void deleteProducto(Long idProducto) {
        productoDAO.delete(idProducto);
    }

    public void updateProducto() {
        productoDAO.update(producto.getIdProducto(), producto);
        producto = new Producto();
    }

    public void loadProductos() {
        productos = productoDAO.findAll();
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
        loadProductos(); // Cargar productos al acceder a la lista
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

}
