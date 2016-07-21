package com.thalidocument.model.documento;

import java.io.Serializable;
import java.util.Date;

public class Detalle_Soportes_FV implements Serializable{

    private int ID_detalleSoporte;
    private String facturaInicio;
    private String facturaFinal;
    private String fichero;
    private String extencion;
    private String Size;
    private Date fechahoraingreso;

    public Detalle_Soportes_FV() {
    }

    public Detalle_Soportes_FV(int ID_detalleSoporte, String facturaInicio, String facturaFinal, String fichero, String extencion, String Size, Date fechahoraingreso) {
        this.ID_detalleSoporte = ID_detalleSoporte;
        this.facturaInicio = facturaInicio;
        this.facturaFinal = facturaFinal;
        this.fichero = fichero;
        this.extencion = extencion;
        this.Size = Size;
        this.fechahoraingreso = fechahoraingreso;
    }

    public int getID_detalleSoporte() {
        return ID_detalleSoporte;
    }

    public void setID_detalleSoporte(int ID_detalleSoporte) {
        this.ID_detalleSoporte = ID_detalleSoporte;
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

    public Date getFechahoraingreso() {
        return fechahoraingreso;
    }

    public void setFechahoraingreso(Date fechahoraingreso) {
        this.fechahoraingreso = fechahoraingreso;
    }
    
    
    
}
