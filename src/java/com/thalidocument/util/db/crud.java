package com.thalidocument.util.db;

//CONSULTAR: TIPOS DE DATOS GENERICOS O GENERIC

import java.util.List;

public interface crud<Cualquiercosa> {

    public boolean create(Cualquiercosa c);

    public boolean delete(Object key);

    public boolean update(Cualquiercosa c);

    public Cualquiercosa read(Object key);
    
    public List<Cualquiercosa> readAll();
     
    public List<Cualquiercosa> readAll(Object object[]);
    
}
