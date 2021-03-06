package com.thalidocument.control.documento;

import com.thalidocument.model.documento.Detalle_Soportes_FV;
import com.thalidocument.model.documento.Factura_Venta;
import com.thalidocument.model.documento.Factura_VentaDao;
import com.thalidocument.model.punto_entrega.PuntoEntrega;
import com.thalidocument.model.punto_entrega.PuntoEntregaDAO;
import com.thalidocument.util.DateUtil;
import com.thalidocument.util.Utilidades;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
public class DocumentoBean {

    private Factura_Venta factura_Venta;
    Factura_VentaDao fvdao;
    private List<PuntoEntrega> list_punto;
    PuntoEntregaDAO puntoDao;
    Utilidades util = new Utilidades();
    private UploadedFile Soporte;
    String RUTA_DOCUMENTO = "D://Soportes/";

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

    public UploadedFile getSoporte() {
        return Soporte;
    }

    public void setSoporte(UploadedFile Soporte) {
        this.Soporte = Soporte;
    }

    public void saved_factura_venta(ActionEvent event) {
        System.out.println("Factura Venta: " + factura_Venta);
        System.out.println("idradicado: " + factura_Venta.getFecha_paquete());
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
        Object[] key = new Object[7];
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
        key[2] = "'" + util.formatearFecha(factura_Venta.getFecha_paquete()) + "'";
        key[3] = fvdao.ID_PUNTO_ENTREGA(factura_Venta.getPuntoEntrega().getNombre());
        key[4] = "'" + factura_Venta.getNota() + "'";
        key[5] = "'" + factura_Venta.getFactinicio() + "'";
        key[6] = "'" + factura_Venta.getFactfinal() + "'";
        return key;

    }

    public void loadfile(FileUploadEvent event) {
        factura_Venta.getDetalle_Soportes_FV().setExtencion(event.getFile().getContentType());
        factura_Venta.getDetalle_Soportes_FV().setFichero(event.getFile().getFileName());
        factura_Venta.getDetalle_Soportes_FV().setSize("" + event.getFile().getSize());
        subirFichero(event.getFile(), event.getFile().getFileName());
    }

    public void saved_soporte_factura(ActionEvent ae) {
        String ruta_soporte = "D://FACTURACION/SOPORTES/" + DateUtil.getDate(factura_Venta.getFecha_paquete());
        System.out.println(ruta_soporte);
        util.lanzarMSJ(FacesContext.getCurrentInstance(), 1, ruta_soporte);
    }

    private void NUMERO_RADICADO() {
        factura_Venta.setIdradicado(fvdao.PROXIMO_RADICADO());
    }

    public void subirFichero(UploadedFile uploadFile,
            String nombreFichero) {
        FileOutputStream fos = null;
        try {
            String ruta = "D://FACTURACION/SOPORTES/" + nombreFichero;
            File file = new File(ruta);
            fos = new FileOutputStream(file);
            IOUtils.copy(uploadFile.getInputstream(), fos);
            util.lanzarMSJ(FacesContext.getCurrentInstance(), 1, "documento enviado correctamente");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DocumentoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentoBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(DocumentoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private Object rutapaquete() {
        String path = RUTA_DOCUMENTO + "/" + DateUtil.getYear(factura_Venta.getFecha_paquete()) + "/" + ""
                + util.mesDeFecha(DateUtil.getMonth(factura_Venta.getFecha_paquete())) + "/"
                + fvdao.CIUDAD_PUNTO_ENTREGA(factura_Venta.getPuntoEntrega().getNombre()) + "/"
                + DateUtil.getDate(factura_Venta.getFecha_paquete()) + "/";
        System.out.println("ruta: " + path);
        File ruta = new File(path);
        if (ruta.isDirectory() != true) {
            File nuevaruta = new File(ruta.getPath());
            nuevaruta.mkdirs();
        }
        return ruta.getPath();
    }
}
