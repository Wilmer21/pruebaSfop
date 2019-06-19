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
@Table(name = "produccion")
@NamedQueries({
    @NamedQuery(name = "Produccion.findAll", query = "SELECT p FROM Produccion p")
    , @NamedQuery(name = "Produccion.findByCodproduccion", query = "SELECT p FROM Produccion p WHERE p.codproduccion = :codproduccion")
    , @NamedQuery(name = "Produccion.findByFechainicioproduccion", query = "SELECT p FROM Produccion p WHERE p.fechainicioproduccion = :fechainicioproduccion")
    , @NamedQuery(name = "Produccion.findByTipoproduccion", query = "SELECT p FROM Produccion p WHERE p.tipoproduccion = :tipoproduccion")})
public class Produccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_produccion")
    private Integer codproduccion;
    @Size(max = 30)
    @Column(name = "Fecha_inicio_produccion")
    private String fechainicioproduccion;
    @Size(max = 30)
    @Column(name = "Tipo_produccion")
    private String tipoproduccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codproduccion", fetch = FetchType.LAZY)
    private List<ProduccionMaterial> produccionMaterialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codproduccion", fetch = FetchType.LAZY)
    private List<HerramientaProduccion> herramientaProduccionList;
    @JoinColumn(name = "Cod_producto", referencedColumnName = "Cod_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto codproducto;

    public Produccion() {
    }

    public Produccion(Integer codproduccion) {
        this.codproduccion = codproduccion;
    }

    public Integer getCodproduccion() {
        return codproduccion;
    }

    public void setCodproduccion(Integer codproduccion) {
        this.codproduccion = codproduccion;
    }

    public String getFechainicioproduccion() {
        return fechainicioproduccion;
    }

    public void setFechainicioproduccion(String fechainicioproduccion) {
        this.fechainicioproduccion = fechainicioproduccion;
    }

    public String getTipoproduccion() {
        return tipoproduccion;
    }

    public void setTipoproduccion(String tipoproduccion) {
        this.tipoproduccion = tipoproduccion;
    }

    public List<ProduccionMaterial> getProduccionMaterialList() {
        return produccionMaterialList;
    }

    public void setProduccionMaterialList(List<ProduccionMaterial> produccionMaterialList) {
        this.produccionMaterialList = produccionMaterialList;
    }

    public List<HerramientaProduccion> getHerramientaProduccionList() {
        return herramientaProduccionList;
    }

    public void setHerramientaProduccionList(List<HerramientaProduccion> herramientaProduccionList) {
        this.herramientaProduccionList = herramientaProduccionList;
    }

    public Producto getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(Producto codproducto) {
        this.codproducto = codproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codproduccion != null ? codproduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produccion)) {
            return false;
        }
        Produccion other = (Produccion) object;
        if ((this.codproduccion == null && other.codproduccion != null) || (this.codproduccion != null && !this.codproduccion.equals(other.codproduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Produccion[ codproduccion=" + codproduccion + " ]";
    }
    
}
