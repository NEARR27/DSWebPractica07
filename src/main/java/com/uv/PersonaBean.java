package com.uv;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author near27
 */
@Named(value = "personaBean")
@SessionScoped
public class PersonaBean implements Serializable {

    private Persona persona = new Persona();
    private PersonaDAO dao = new PersonaDAO();

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getPersonas() {
        return dao.findAll();
    }

    public String add() {
        dao.create(persona);
        persona = new Persona();
        return "index?faces-redirect=true";  // navega de nuevo al inicio
    }

    public String delete(Long id) {
        dao.delete(id);
        return "index?faces-redirect=true";
    }

    
    
}
