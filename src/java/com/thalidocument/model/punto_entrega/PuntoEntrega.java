 
package com.thalidocument.model.punto_entrega;

 
public class PuntoEntrega {
        
    private int idpunto;
    private String nombre;
    private String prefijo;

    public PuntoEntrega() {
    }

    public PuntoEntrega(int idpunto, String nombre, String prefijo) {
        this.idpunto = idpunto;
        this.nombre = nombre;
        this.prefijo = prefijo;
    }

     

    public int getIdpunto() {
        return idpunto;
    }

    public void setIdpunto(int idpunto) {
        this.idpunto = idpunto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }
    
}
