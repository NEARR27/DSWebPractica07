/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginBean {

    private String nombre_usuario;
    private String contrasena;

    public String login() {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.getUsuarioByNombre(nombre_usuario);

        if (usuario != null && contrasena.equals(usuario.getContrasena())) {
            return "index?faces-redirect=true";
        } else {
            // Mensaje de error
            return "login";
        }
    }
    
    public String logout() {
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    return "Login?faces-redirect=true";
}


    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
}






