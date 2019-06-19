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
@Table(name = "herramienta_produccion")
@NamedQueries({
    @NamedQuery(name = "HerramientaProduccion.findAll", query = "SELECT h FROM HerramientaProduccion h")
    , @NamedQuery(name = "HerramientaProduccion.findByCodherramientaproduccion", query = "SELECT h FROM HerramientaProduccion h WHERE h.codherramientaproduccion = :codherramientaproduccion")})
public class HerramientaProduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_herramienta_produccion")
    private Integer codherramientaproduccion;
    @JoinColumn(name = "Cod_herramienta", referencedColumnName = "Cod_herramienta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Herramienta codherramienta;
    @JoinColumn(name = "Cod_produccion", referencedColumnName = "Cod_produccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produccion codproduccion;

    public HerramientaProduccion() {
    }

    public HerramientaProduccion(Integer codherramientaproduccion) {
        this.codherramientaproduccion = codherramientaproduccion;
    }

    public Integer getCodherramientaproduccion() {
        return codherramientaproduccion;
    }

    public void setCodherramientaproduccion(Integer codherramientaproduccion) {
        this.codherramientaproduccion = codherramientaproduccion;
    }

    public Herramienta getCodherramienta() {
        return codherramienta;
    }

    public void setCodherramienta(Herramienta codherramienta) {
        this.codherramienta = codherramienta;
    }

    public Produccion getCodproduccion() {
        return codproduccion;
    }

    public void setCodproduccion(Produccion codproduccion) {
        this.codproduccion = codproduccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codherramientaproduccion != null ? codherramientaproduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HerramientaProduccion)) {
            return false;
        }
        HerramientaProduccion other = (HerramientaProduccion) object;
        if ((this.codherramientaproduccion == null && other.codherramientaproduccion != null) || (this.codherramientaproduccion != null && !this.codherramientaproduccion.equals(other.codherramientaproduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HerramientaProduccion[ codherramientaproduccion=" + codherramientaproduccion + " ]";
    }
    
}
