/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;

/**
 *
 * @author hachi
 */
@Entity
@Table(name = "producto_cotizacion")
@NamedQueries({
    @NamedQuery(name = "ProductoCotizacion.findAll", query = "SELECT p FROM ProductoCotizacion p")
    , @NamedQuery(name = "ProductoCotizacion.findByCodproductocotizacion", query = "SELECT p FROM ProductoCotizacion p WHERE p.codproductocotizacion = :codproductocotizacion")
    , @NamedQuery(name = "ProductoCotizacion.findByValortotal", query = "SELECT p FROM ProductoCotizacion p WHERE p.valortotal = :valortotal")})
public class ProductoCotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_producto_cotizacion")
    private Integer codproductocotizacion;
    @Column(name = "Valor_total")
    private Integer valortotal;
    @JoinColumn(name = "Cod_producto", referencedColumnName = "Cod_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto codproducto;
    @JoinColumn(name = "Cod_cotizacion", referencedColumnName = "Cod_cotizacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cotizacion codcotizacion;

    public ProductoCotizacion() {
    }

    public ProductoCotizacion(Integer codproductocotizacion) {
        this.codproductocotizacion = codproductocotizacion;
    }

    public Integer getCodproductocotizacion() {
        return codproductocotizacion;
    }

    public void setCodproductocotizacion(Integer codproductocotizacion) {
        this.codproductocotizacion = codproductocotizacion;
    }

    public Integer getValortotal() {
        return valortotal;
    }

    public void setValortotal(Integer valortotal) {
        this.valortotal = valortotal;
    }

    public Producto getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(Producto codproducto) {
        this.codproducto = codproducto;
    }

    public Cotizacion getCodcotizacion() {
        return codcotizacion;
    }

    public void setCodcotizacion(Cotizacion codcotizacion) {
        this.codcotizacion = codcotizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codproductocotizacion != null ? codproductocotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoCotizacion)) {
            return false;
        }
        ProductoCotizacion other = (ProductoCotizacion) object;
        if ((this.codproductocotizacion == null && other.codproductocotizacion != null) || (this.codproductocotizacion != null && !this.codproductocotizacion.equals(other.codproductocotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ProductoCotizacion[ codproductocotizacion=" + codproductocotizacion + " ]";
    }
    
}
