/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Instalacion;
import entidades.Pedido;
import facade.InstalacionFacade;
import facade.PedidoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author hachi
 */
@Named(value = "controladorInstalacion")
@RequestScoped
public class controladorInstalacion {

    /**
     * Creates a new instance of controladorInstalacion
     */
    public controladorInstalacion() {
    }
    @EJB
    private InstalacionFacade instalacionFacade;
    @EJB
    private PedidoFacade pedidoFacade;

    @PostConstruct
    public void init() {
        instalacion = new Instalacion();
        pedido = new Pedido();
        id = 0;
    }
    private Instalacion instalacion;
    private Pedido pedido;
    private Integer id;

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void registrar() {
        pedido.setCodpedido(id);
        instalacion.setCodpedido(pedido);
        instalacionFacade.create(instalacion);
    }

    public String eliminar(Instalacion instalacion) {

        this.instalacion = instalacion;
        instalacionFacade.remove(instalacion);
        return "lista";

    }

    public List<SelectItem> getItems() {
        return instalacionFacade.getItems();
    }
    
    public List<Instalacion> Consultartodo() {

        return instalacionFacade.findAll();

    }

    public String preEditar(Instalacion instalacion) {

        this.setInstalacion(instalacion);
        return "actualizar";
    }

    public String editar(Instalacion instalacion) {
        instalacion.setCodpedido(pedidoFacade.find(pedido.getCodpedido()));
        instalacionFacade.edit(instalacion);
        return "registrar";

    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
