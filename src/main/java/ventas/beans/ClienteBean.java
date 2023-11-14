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
import ventas.clases.Cliente;
import ventas.dao.ClienteDAO;

/**
 *
 * @author near
 */
@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

    private Cliente cliente = new Cliente();
    private List<Cliente> clientes;
    private final ClienteDAO clienteDAO = new ClienteDAO();

    public ClienteBean() {
    }

    public void addCliente() {
        clienteDAO.create(cliente);
        cliente = new Cliente(); // Reiniciar para el próximo cliente
        loadClientes();
    }

    public void deleteCliente(Integer idCliente) {
        clienteDAO.delete(idCliente);
        loadClientes();
    }

    public void updateCliente(Cliente cliente) {
        clienteDAO.update(cliente.getIdCliente(), cliente);
    }

    public void loadClientes() {
        clientes = clienteDAO.findAll();
    }

    @PostConstruct
    public void init() {
        loadClientes();
    }

    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void onRowEdit(RowEditEvent<Cliente> event) {
        updateCliente(event.getObject());
        // Opcional: Agregar mensaje de confirmación
    }
}
