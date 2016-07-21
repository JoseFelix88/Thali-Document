package com.thalidocument.control.documento;

import com.thalidocument.model.documento.Detalle_Soportes_FV;
import com.thalidocument.model.documento.Factura_Venta;
import com.thalidocument.model.documento.Factura_VentaDao;
import com.thalidocument.model.punto_entrega.PuntoEntrega;
import com.thalidocument.model.punto_entrega.PuntoEntregaDAO;
import com.thalidocument.util.Utilidades;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class DocumentoBean implements Serializable {

    private Factura_Venta factura_Venta;
    Factura_VentaDao fvdao;
    private List<PuntoEntrega> list_punto;
    PuntoEntregaDAO puntoDao;
    Utilidades util = new Utilidades();
    private UploadedFile SoporteFacturaVenta;
    

    @PostConstruct
    public void init() {
        fvdao = new Factura_VentaDao();
        factura_Venta = new Factura_Venta();
        factura_Venta.setPuntoEntrega(new PuntoEntrega());
        factura_Venta.setDetalle_Soportes_FV(new Detalle_Soportes_FV());
        puntoDao = new PuntoEntregaDAO();
        list_punto = puntoDao.readAll();
        NUMERO_RADICADO();
    }

    public Factura_Venta getFactura_Venta() {
        return factura_Venta;
    }

    public List<PuntoEntrega> getList_punto() {
        return list_punto;
    }

    public void setList_punto(List<PuntoEntrega> list_punto) {
        this.list_punto = list_punto;
    }

    public UploadedFile getSoporteFacturaVenta() {
        return SoporteFacturaVenta;
    }

    public void setSoporteFacturaVenta(UploadedFile SoporteFacturaVenta) {
        this.SoporteFacturaVenta = SoporteFacturaVenta;
    }

    public void saved_factura_venta(ActionEvent event) {
        fvdao = new Factura_VentaDao();
        if (fvdao.READ_FACTURA_VENTA(factura_Venta.getIdradicado()) == null) {
            if (fvdao.CRUD_FACTURA(cargar_data_FV(0)) != false) {
                util.lanzarMSJ(FacesContext.getCurrentInstance(), 1, "factura cargada correctamente.");
            } else {
                util.lanzarMSJ(FacesContext.getCurrentInstance(), 3, "factura no fue cargada.");
            }
        } else {
            util.lanzarMSJ(FacesContext.getCurrentInstance(), 3, "la factura se encuentra cargada. ingresa una nueva.");
        }
    }

    private Object[] cargar_data_FV(int opcion) {
        Object[] key = new Object[10];
        if (opcion == 0) {
            key[0] = opcion;
        }
        if (opcion == 1) {
            key[0] = opcion;
        }
        if (opcion == 2) {
            key[0] = opcion;
        }
        key[1] = factura_Venta.getIdradicado();
        key[2] = util.formatearFecha(factura_Venta.getFecha_paquete());
        key[3] = fvdao.ID_PUNTO_ENTREGA(factura_Venta.getPuntoEntrega().getNombre());
        key[4] = factura_Venta.getDetalle_Soportes_FV().getFacturaInicio();
        key[5] = factura_Venta.getDetalle_Soportes_FV().getFacturaFinal();
        key[6] = factura_Venta.getDetalle_Soportes_FV().getFichero();
        key[7] = factura_Venta.getDetalle_Soportes_FV().getExtencion();
        key[8] = factura_Venta.getDetalle_Soportes_FV().getSize();
        key[9] = factura_Venta.getAutor();
        return key;

    }
    
     public void handleFileUpload(FileUploadEvent event) {
         factura_Venta.getDetalle_Soportes_FV().setExtencion(event.getFile().getContentType());
         factura_Venta.getDetalle_Soportes_FV().setFichero(event.getFile().getFileName());
         factura_Venta.getDetalle_Soportes_FV().setSize(""+event.getFile().getSize());
         String datafactura = "fecha paquete: "+factura_Venta.getFecha_paquete()+" - punto entrega: "+fvdao.ID_PUNTO_ENTREGA(factura_Venta.getPuntoEntrega().getNombre())+"\n"
                 + "inicio: "+factura_Venta.getDetalle_Soportes_FV().getFacturaInicio()+" - final: "+factura_Venta.getDetalle_Soportes_FV().getFacturaFinal();
         util.lanzarMSJ(FacesContext.getCurrentInstance(), 1, datafactura);
   
    }
     
     public void saved_soporte_factura(ActionEvent event) throws IOException{
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String realPath = (String) servletContext.getRealPath("/resources/data/suport/");
       
        File file = new File(realPath);
        if (file.isDirectory() == true) {
            System.out.println("ruta- " + file.getPath() + " es una ruta: " + file.isAbsolute());
            util.agregarImagen( SoporteFacturaVenta, file.getPath(), factura_Venta.getDetalle_Soportes_FV().getFichero(),
                    FacesContext.getCurrentInstance());

        } else {
            util.crearDirecctorio(urlempleado,
                    String.valueOf(empleado.getIdempleados()));

            util.lanzarMSJ(FacesContext.getCurrentInstance(), 1, "FOLDER PARA EL EMPLEADO " + empleado.getApellido1() + ""
                    + " " + empleado.getNombre1() + " CREADO CORRECTAMENTE.");

            util.agregarImagen(fotoEmpleado, urlempleado, String.valueOf(empleado.getIdempleados()),
                    FacesContext.getCurrentInstance());
        }

        String tipoarchivo = fotoEmpleado.getContentType().replace("image/", ".");
        dAO.asignarFotoEmpleado(String.valueOf(empleado.getIdempleados()).concat(tipoarchivo),
                String.valueOf(empleado.getIdempleados()));
     }

    private void NUMERO_RADICADO() {
        factura_Venta.setIdradicado(fvdao.PROXIMO_RADICADO());
    }

    public FileUpload getDocumento() {
        return documento;
    }

    public void setDocumento(FileUpload documento) {
        this.documento = documento;
    }
}
