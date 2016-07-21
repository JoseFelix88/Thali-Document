package com.thalidocument.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

public class Utilidades implements Serializable {

    public String mesDeFecha(int mes) {
        String result = "";
        switch (mes) {

            case 0:
                result = "01 Enero";
                break;
            case 1:
                result = "02 Febrero";
                break;
            case 2:
                result = "03 Marzo";
                break;
            case 3:
                result = "04 Abril";
                break;
            case 4:
                result = "05 Mayo";
                break;
            case 5:
                result = "06 Junio";
                break;
            case 6:
                result = "07 Julio";
                break;
            case 7:
                result = "08 Agosto";
                break;
            case 8:
                result = "09 Septiembre";
                break;
            case 9:
                result = "10 Octubre";
                break;
            case 10:
                result = "11 Noviembre";
                break;
            case 11:
                result = "12 Diciembre";
                break;
            default:
                result = "Error";
                break;
        }
        return result.toUpperCase();
    }

    public String formatearFecha(Date fecha) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaConFormato = formato.format(fecha);
            return fechaConFormato;
        } catch (Exception er) {
        }
        return null;
    }

    public Date formatearFecha(String fecha) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaConFormato = formato.parse(fecha);
            return fechaConFormato;
        } catch (Exception er) {
        }
        return null;
    }

    public String formatearFechaDMY(Date fecha) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            String fechaConFormato = formato.format(fecha);
            return fechaConFormato;
        } catch (Exception er) {
        }
        return null;
    }

    public boolean crearDirecctorio(String urlOrigen, String nombreCarpeta) {
        File ruta = new File(urlOrigen);
        if (ruta.isDirectory() != true) {
            File nuevaruta = new File(ruta.getPath() + "/" + nombreCarpeta);
            nuevaruta.mkdirs();
            return true;
        }
        return false;
    }

    public void agregar_documento(UploadedFile uf, String rutaFile,
            String nombre_Archivo, FacesContext facesContext) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String[] extenciones = {".jpeg", ".png", ".gif", ".tiff", ".bmp", ".pdf"};
        try {
            outputStream = new FileOutputStream(new File(rutaFile + "/" + nombre_Archivo));
            lanzarMSJ(facesContext, 1, "" + outputStream);
            inputStream = uf.getInputstream();
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            lanzarMSJ(facesContext, 1, "Documento Subido correctamente");

        } catch (Exception ex) {
            lanzarMSJ(facesContext, 4, "Ocurrio un problema al momento de realizar la carga del Documento: " + ex);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void lanzarMSJ(FacesContext facesContext, int tipo, String msj) {
        msj = msj.toUpperCase();
        if (tipo == 1) {
            facesContext.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msj));
        }

        if (tipo == 2) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", msj));
        }

        if (tipo == 3) {
            facesContext.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msj));
        }

        if (tipo == 4) {
            facesContext.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, null, msj));
        }
    }
}
