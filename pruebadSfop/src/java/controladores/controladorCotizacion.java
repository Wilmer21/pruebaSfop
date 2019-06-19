/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Cotizacion;
import entidades.Usuario;
import facade.CotizacionFacade;
import facade.UsuarioFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author hachi
 */
@Named(value = "controladorCotizacion")
@RequestScoped
public class controladorCotizacion {
    public controladorCotizacion(){
    }
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private CotizacionFacade cotizacionFacade;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        cotizacion = new Cotizacion();
        id = 0;
    }
    private Usuario usuario;
    private Cotizacion cotizacion;
    private Integer id;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }
    
    public void registrar(){
        usuario.setCodusuario(id);
        cotizacion.setCodusuario(usuario);
        
        cotizacionFacade.create(cotizacion);
    }
    public String eliminar(Cotizacion cotizacion)
    {
        this.cotizacion=cotizacion;
        cotizacionFacade.remove(cotizacion);
        return "listaCO";
    }
    public List<Cotizacion> consultarTodos()
    {
        return cotizacionFacade.findAll();
    }  
    
    public String preEditar(Cotizacion cotizacion)
    {
        this.setCotizacion(cotizacion);
        return "actualizarCO";
    }
    public String editar(Cotizacion cotizacion){
        cotizacion.setCodusuario(usuarioFacade.find((usuario.getCodusuario())));
        cotizacionFacade.edit(cotizacion);
        return "registrarCO";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
