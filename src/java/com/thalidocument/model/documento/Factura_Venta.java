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

    public Factura_Venta() {
    }

    public Factura_Venta(int idfactura, Date fecha_paquete, PuntoEntrega puntoEntrega, String facturaInicio, String facturaFinal, String fichero, String extencion, String Size, String autor, Date fechahoraingreso) {
        this.idfactura = idfactura;
        this.fecha_paquete = fecha_paquete;
        this.puntoEntrega = puntoEntrega;
        this.facturaInicio = facturaInicio;
        this.facturaFinal = facturaFinal;
        this.fichero = fichero;
        this.extencion = extencion;
        this.Size = Size;
        this.autor = autor;
        this.fechahoraingreso = fechahoraingreso;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
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

    public String getFacturaInicio() {
        return facturaInicio;
    }

    public void setFacturaInicio(String facturaInicio) {
        this.facturaInicio = facturaInicio;
    }

    public String getFacturaFinal() {
        return facturaFinal;
    }

    public void setFacturaFinal(String facturaFinal) {
        this.facturaFinal = facturaFinal;
    }

    public String getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = fichero;
    }

    public String getExtencion() {
        return extencion;
    }

    public void setExtencion(String extencion) {
        this.extencion = extencion;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechahoraingreso() {
        return fechahoraingreso;
    }

    public void setFechahoraingreso(Date fechahoraingreso) {
        this.fechahoraingreso = fechahoraingreso;
    }
}
