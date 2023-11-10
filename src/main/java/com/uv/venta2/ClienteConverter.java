/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.venta2;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import com.uv.venta2.Cliente; 
import com.uv.venta2.ClienteDAO; 
import javax.faces.convert.ConverterException;

/**
 *
 * @author near
 */
@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter{
    
    
     @Inject
    private ClienteDAO clienteDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            int id = Integer.parseInt(value);
            return clienteDAO.findById(id);
        } catch (NumberFormatException e) {
            throw new ConverterException("No es un ID válido: " + value, e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Cliente) {
            Cliente cliente = (Cliente) value;
            return cliente.getIdCliente().toString();
        } else {
            return "";
        }
    }
    
}
