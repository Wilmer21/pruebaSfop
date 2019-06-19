/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Producto;
import facade.ProductoFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author hachi
 */
@Named(value="controladorProducto")
@RequestScoped

public class controladorProducto {
    
    public controladorProducto(){}
    
    @EJB
    private ProductoFacade productoFacade;
    
    @PostConstruct
    public void init(){
        producto = new Producto();
    }
    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public void registrar(){
        productoFacade.create(producto);
    }
    public String eliminar(Producto producto){
        this.producto = producto;
        productoFacade.remove(producto);
        return "listaPR";
    }
    public List<Producto> consultarTodo(){
        return productoFacade.findAll();
    }
    public String preEditar(Producto producto){
        this.setProducto(producto);
        return "actualizarPR";
    }
    public String editar(Producto producto){
        productoFacade.edit(producto);
        return "registrarPR";
    }
}
