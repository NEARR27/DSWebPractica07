/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uv;
import java.util.List;


/**
 *
 * @author near27
 */
public interface IDAOGeneral<T, ID> {

    public T create(T v);

    public boolean delete(ID id);

    public T update(ID id, T vN);

    public List<T> findAll();

    public T findById(ID id);
}
