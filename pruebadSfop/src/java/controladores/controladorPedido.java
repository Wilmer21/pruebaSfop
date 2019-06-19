/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Pedido;
import entidades.Producto;
import entidades.Usuario;
import facade.PedidoFacade;
import facade.ProductoFacade;
import facade.UsuarioFacade;
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
@Named(value="controladorPedido")
@RequestScoped
public class controladorPedido {
    public controladorPedido() {}
    @EJB
    private PedidoFacade pedidoFacade;
    @EJB
    private ProductoFacade productoFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    
    @PostConstruct
    public void init(){
        pedido = new Pedido();
        producto= new Producto();
        usuario= new Usuario();
        id1=0;
        id2=0;
    }
    private Pedido pedido;
    private Producto producto;
    private Usuario usuario;
    private Integer id1;
    private Integer id2;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public Integer getId2() {
        return id2;
    }

    public void setId2(Integer id2) {
        this.id2 = id2;
    }
    
    public void registrar(){
        producto.setCodproducto(id1);
        usuario.setCodusuario(id2);
        pedidoFacade.create(pedido);
    }
    
    public String eliminar(Pedido pedido){
        this.pedido=pedido;
        pedidoFacade.remove(pedido);
        return "listaPE";
    }
    public List<SelectItem> getItems(){
        return pedidoFacade.getItems();
    }
    
    public List<Pedido> consultarTodo() {

        return pedidoFacade.findAll();

    }
    public String preEditar(Pedido pedido){
        this.setPedido(pedido);
        return "actualizarPE";
    }
    public String editar(Pedido pedido){
        producto.setCodproducto(id1);
        usuario.setCodusuario(id2);
        pedido.setCodproducto(producto);
        pedido.setCodusuario(usuario);
        pedidoFacade.edit(pedido);
        return "registrarPE";
    }
    
}
