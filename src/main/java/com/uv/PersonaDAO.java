/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 *
 * @author near27
 */
public class PersonaDAO implements IDAOGeneral<Persona, Long> {

   @Override
    public Persona create(Persona persona) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(persona);
            tx.commit();
            return persona;
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            Persona persona = session.find(Persona.class, id);
            if (persona != null) {
                Transaction tx = session.beginTransaction();
                session.delete(persona);
                tx.commit();
                return true;
            }
            return false;
        }
    }

    @Override
    public Persona update(Long id, Persona updatedPersona) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(updatedPersona);
            tx.commit();
            return updatedPersona;
        }
    }

    @Override
    public List<Persona> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("from Persona", Persona.class).list();
        }
    }

    @Override
    public Persona findById(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.find(Persona.class, id);
        }
    }
}
