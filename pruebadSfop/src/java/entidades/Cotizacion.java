/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author hachi
 */
@Entity
@Table(name = "cotizacion")
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c")
    , @NamedQuery(name = "Cotizacion.findByCodcotizacion", query = "SELECT c FROM Cotizacion c WHERE c.codcotizacion = :codcotizacion")
    , @NamedQuery(name = "Cotizacion.findByCantidadproducto", query = "SELECT c FROM Cotizacion c WHERE c.cantidadproducto = :cantidadproducto")
    , @NamedQuery(name = "Cotizacion.findByValorcotizacion", query = "SELECT c FROM Cotizacion c WHERE c.valorcotizacion = :valorcotizacion")})
public class Cotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_cotizacion")
    private Integer codcotizacion;
    @Size(max = 30)
    @Column(name = "Cantidad_producto")
    private String cantidadproducto;
    @Size(max = 30)
    @Column(name = "Valor_cotizacion")
    private String valorcotizacion;
    @JoinColumn(name = "Cod_usuario", referencedColumnName = "Cod_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario codusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcotizacion", fetch = FetchType.LAZY)
    private List<ProductoCotizacion> productoCotizacionList;

    public Cotizacion() {
    }

    public Cotizacion(Integer codcotizacion) {
        this.codcotizacion = codcotizacion;
    }

    public Integer getCodcotizacion() {
        return codcotizacion;
    }

    public void setCodcotizacion(Integer codcotizacion) {
        this.codcotizacion = codcotizacion;
    }

    public String getCantidadproducto() {
        return cantidadproducto;
    }

    public void setCantidadproducto(String cantidadproducto) {
        this.cantidadproducto = cantidadproducto;
    }

    public String getValorcotizacion() {
        return valorcotizacion;
    }

    public void setValorcotizacion(String valorcotizacion) {
        this.valorcotizacion = valorcotizacion;
    }

    public Usuario getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(Usuario codusuario) {
        this.codusuario = codusuario;
    }

    public List<ProductoCotizacion> getProductoCotizacionList() {
        return productoCotizacionList;
    }

    public void setProductoCotizacionList(List<ProductoCotizacion> productoCotizacionList) {
        this.productoCotizacionList = productoCotizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcotizacion != null ? codcotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.codcotizacion == null && other.codcotizacion != null) || (this.codcotizacion != null && !this.codcotizacion.equals(other.codcotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cotizacion[ codcotizacion=" + codcotizacion + " ]";
    }
    
}
