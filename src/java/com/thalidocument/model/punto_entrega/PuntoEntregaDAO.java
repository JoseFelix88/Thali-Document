 
package com.thalidocument.model.punto_entrega;


import com.thalidocument.util.db.crud;
import com.thalidocument.util.db.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

 
public class PuntoEntregaDAO extends database implements crud<PuntoEntrega>{

    @Override
    public boolean create(PuntoEntrega c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PuntoEntrega c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PuntoEntrega read(Object key) {
        PuntoEntrega pe = null;
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "Select cod_punto, nombre , prefijo from puntos where nombre = ? or cod_punto = ?";
        try {
            ps = getConnection().prepareStatement(SQL);
            ps.setObject(1, key);
            ps.setObject(2, key);
            rs = ps.executeQuery();
            if (rs.next()) {
                pe = new PuntoEntrega(rs.getInt("cod_punto"), rs.getString("nombre"), rs.getString("prefijo"));
            }
        } catch (Exception e) {
        }
        
        return pe;
    }

    @Override
    public List<PuntoEntrega> readAll() {
        PuntoEntrega pe = null;
        List<PuntoEntrega> list = null;
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "Select cod_punto, nombre , prefijo from puntos order by nombre";
        try {
            ps = getConnection().prepareStatement(SQL);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                pe = new PuntoEntrega(rs.getInt("cod_punto"), rs.getString("nombre"), rs.getString("prefijo"));
                list.add(pe);
            }
        } catch (Exception e) {
        }
        
        return list;
        
    }

    @Override
    public List<PuntoEntrega> readAll(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
