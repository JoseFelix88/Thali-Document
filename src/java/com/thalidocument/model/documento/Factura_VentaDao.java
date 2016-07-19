package com.thalidocument.model.documento;

import com.thalidocument.model.punto_entrega.PuntoEntregaDAO;
import com.thalidocument.util.DateUtil;
import com.thalidocument.util.db.database;
import java.util.ArrayList;
import java.util.List;

public class Factura_VentaDao extends database {

    public boolean CRUD_FACTURA(Object[] values) {
        return EJECUTAR_SP("CRUD_FACTURA_VENTA", values);
    }

    public Factura_Venta READ_FACTURA_VENTA(Object key) {
        Factura_Venta fv = null;
        PuntoEntregaDAO pedao;
        Object[][] rs = SELECT_SP("SELECT_FACTURA_VENTA", key);
        if (rs.length > 0) {
            pedao = new PuntoEntregaDAO();
            fv = new Factura_Venta();
            fv.setIdfactura(Integer.parseInt(rs[0][0].toString()));
            fv.setFecha_paquete(DateUtil.getDate(rs[0][1]));
            fv.setPuntoEntrega(pedao.read(rs[0][2]));
            fv.setFacturaInicio(rs[0][3].toString());
            fv.setFacturaFinal(rs[0][4].toString());
            fv.setFichero(rs[0][5].toString());
            fv.setExtencion(rs[0][6].toString());
            fv.setSize(rs[0][7].toString());
            fv.setAutor(rs[0][8].toString());
            fv.setFechahoraingreso(DateUtil.getTimestamp(rs[0][9]));
        }
        return fv;
    }
    
    public List<Factura_Venta> READ_ALL_FACTURA_VENTA(Object key) {
        Factura_Venta  fv = new Factura_Venta();
        List<Factura_Venta> list = new ArrayList<>();
        PuntoEntregaDAO pedao = new PuntoEntregaDAO();
        Object[][] rs = SELECT_SP("SELECT_FACTURA_VENTA", key);
        while (rs.length > 0) {
            fv.setIdfactura(Integer.parseInt(rs[0][0].toString()));
            fv.setFecha_paquete(DateUtil.getDate(rs[0][1]));
            fv.setPuntoEntrega(pedao.read(rs[0][2]));
            fv.setFacturaInicio(rs[0][3].toString());
            fv.setFacturaFinal(rs[0][4].toString());
            fv.setFichero(rs[0][5].toString());
            fv.setExtencion(rs[0][6].toString());
            fv.setSize(rs[0][7].toString());
            fv.setAutor(rs[0][8].toString());
            fv.setFechahoraingreso(DateUtil.getTimestamp(rs[0][9]));
            list.add(fv);
        }
        return list;
    }

}
