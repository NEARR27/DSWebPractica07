/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.uv.venta2;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import com.uv.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 *
 * @author near
 */
@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {
    
    private ClienteDAO clienteDAO;
    private Cliente clienteSeleccionado;
    private List<Cliente> listaClientes;

    public ClienteBean() {
        clienteDAO = new ClienteDAO();
        clienteSeleccionado = new Cliente();
        cargarListaClientes();
    }

    private void cargarListaClientes() {
        listaClientes = clienteDAO.findAll();
    }

    public void createCliente() {
        clienteDAO.create(clienteSeleccionado);
        clienteSeleccionado = new Cliente(); 
        cargarListaClientes();
    }

    public void updateCliente() {
        clienteDAO.update(clienteSeleccionado.getIdCliente(), clienteSeleccionado);
        cargarListaClientes();
    }

    public void deleteCliente() {
        if (clienteSeleccionado != null && clienteSeleccionado.getIdCliente() != 0) {
            clienteDAO.delete(clienteSeleccionado.getIdCliente());
            clienteSeleccionado = new Cliente(); 
            cargarListaClientes();
        }
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

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
}
