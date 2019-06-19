/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Produccion;
import entidades.Producto;
import facade.ProduccionFacade;
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
@Named(value="controladorProduccion")
@RequestScoped

public class controladorProduccion {
    
    public  controladorProduccion() {}
        @EJB
        private ProduccionFacade produccionFacade;
        @EJB
        private ProductoFacade productoFacade;
        
        @PostConstruct
        public void init()
        {
            produccionFacade = new ProduccionFacade();
            productoFacade = new ProductoFacade();
            id = 0;
        }
        
        private Produccion produccion;
        private Producto producto;
        private Integer id;
        
        //Get&Set//

        public Produccion getProduccion() {
        return produccion;
        }

        public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
        }

        public Producto getProducto() {
        return producto;
        }

        public void setProducto(Producto producto) {
        this.producto = producto;
        }

        public int getId() {
        return id;
        }

        public void setId(int id) {
        this.id = id;
        }
        //
        public void registrar()
        {
            producto.setCodproducto(id);
            produccion.setCodproducto(producto);
            
            produccionFacade.create(produccion);
        }
        public String eliminar(Produccion produccion)
        {
            this.produccion = produccion;
            produccionFacade.remove(produccion);
            return "listaPROD";
        }
        
        public List<SelectItem> getItems()
        {
            return produccionFacade.getItems();
        }      
        public List<Produccion> consultarTodo()
        {
            return produccionFacade.findAll();
        }
        public String preEditar(Produccion produccion)
        {
            this.setProduccion(produccion);
            return "editarPROD";
        }
        public String editar(Produccion produccion)
        {
            produccion.setCodproducto(productoFacade.find(producto.getCodproducto()));
            produccionFacade.edit(produccion);
            return "registrarPROD";
        }
        
        
    
}
