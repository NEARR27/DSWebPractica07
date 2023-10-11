/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UsuarioDAO {

    private SessionFactory factory;

    public UsuarioDAO() {
        factory = new Configuration().configure().addAnnotatedClass(Usuario.class).buildSessionFactory();
    }

    public Usuario getUsuarioByNombre(String nombre) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Usuario WHERE nombre_usuario = :nombre", Usuario.class)
                          .setParameter("nombre", nombre)
                          .uniqueResult();
        }
    }
}
