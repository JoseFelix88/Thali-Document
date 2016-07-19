package com.thalidocument.model.documento;

import com.thalidocument.model.punto_entrega.PuntoEntrega;
import java.io.Serializable;
import java.util.Date;

public class Factura_Venta implements Serializable {

    private int idfactura;
    private Date fecha_paquete;
    private PuntoEntrega puntoEntrega;
    private String facturaInicio;
    private String facturaFinal;
    private String fichero;
    private String extencion;
    private String Size;
    private String autor;
    private Date fechahoraingreso;
    
}
