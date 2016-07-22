package com.thalidocument.model.documento;

import com.thalidocument.model.punto_entrega.PuntoEntrega;
import java.io.Serializable;
import java.util.Date;

public class Factura_Venta implements Serializable {

    private int Idradicado;
    private Date fecha_paquete;
    private PuntoEntrega puntoEntrega;
    private Detalle_Soportes_FV detalle_Soportes_FV;
    private String autor;
    private Date fechahoraingreso;

    public Factura_Venta() {
    }
 
    public int getIdradicado() {
        return Idradicado;
    }

    public void setIdradicado(int Idradicado) {
        this.Idradicado = Idradicado;
    }

    public Date getFecha_paquete() {
        return fecha_paquete;
    }

    public void setFecha_paquete(Date fecha_paquete) {
        this.fecha_paquete = fecha_paquete;
    }

    public PuntoEntrega getPuntoEntrega() {
        return puntoEntrega;
    }

    public void setPuntoEntrega(PuntoEntrega puntoEntrega) {
        this.puntoEntrega = puntoEntrega;
    }
    public Date getFechahoraingreso() {
        return fechahoraingreso;
    }

    public void setFechahoraingreso(Date fechahoraingreso) {
        this.fechahoraingreso = fechahoraingreso;
    }

    public Detalle_Soportes_FV getDetalle_Soportes_FV() {
        return detalle_Soportes_FV;
    }

    public void setDetalle_Soportes_FV(Detalle_Soportes_FV detalle_Soportes_FV) {
        this.detalle_Soportes_FV = detalle_Soportes_FV;
    }

    public String getAutor() {
        autor = "1102819530";
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

  
}
