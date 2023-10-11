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

    private final EntityManager entityManager;
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.uv_DSWebPractica07_war_1.0-SNAPSHOTPU");

    private List<Persona> personas;
    private Persona nuevaPersona = new Persona();

    public PersonaBean() {
        this.entityManager = emf.createEntityManager();
    }

    @PostConstruct
    public void init() {
        personas = entityManager.createQuery("FROM Persona e", Persona.class).getResultList();
    }

    public void agregar() {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(nuevaPersona);
            entityManager.getTransaction().commit();
            personas.add(nuevaPersona);
            nuevaPersona = new Persona();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    public void actualizar(Persona persona) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(persona);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    public void eliminar(Persona persona) {

        try {
            entityManager.getTransaction().begin();
            if (!entityManager.contains(persona)) {
                persona = entityManager.merge(persona);
            }
            entityManager.remove(persona);
            entityManager.getTransaction().commit();
            personas.remove(persona);
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
           
        }
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setEjemplos(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getNuevaPersona() {
        return nuevaPersona;
    }

    public void setNuevaPersona(Persona nuevaPersona) {
        this.nuevaPersona = nuevaPersona;
    }

}
