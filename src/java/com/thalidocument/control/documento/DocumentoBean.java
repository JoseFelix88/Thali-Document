package com.thalidocument.control.documento;

import com.thalidocument.model.documento.Factura_Venta;
import com.thalidocument.model.documento.Factura_VentaDao;
import com.thalidocument.model.punto_entrega.PuntoEntrega;
import com.thalidocument.model.punto_entrega.PuntoEntregaDAO;
import com.thalidocument.util.DateUtil;
import com.thalidocument.util.Utilidades;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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
        puntoDao = new PuntoEntregaDAO();
        list_punto = puntoDao.readAll();
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
        if (fvdao.READ_FACTURA_VENTA(factura_Venta.getIdfactura()) == null) {
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
        key[1] = factura_Venta.getIdfactura();
        key[2] = util.formatearFecha(factura_Venta.getFecha_paquete());
        key[3] = factura_Venta.getPuntoEntrega().getIdpunto();
        key[4] = factura_Venta.getFacturaInicio();
        key[5] = factura_Venta.getFacturaFinal();
        key[6] = factura_Venta.getFichero();
        key[7] = factura_Venta.getExtencion();
        key[8] = factura_Venta.getSize();
        key[9] = factura_Venta.getAutor();
        return key;

    }
}
