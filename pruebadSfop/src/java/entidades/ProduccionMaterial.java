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
@Table(name = "produccion_material")
@NamedQueries({
    @NamedQuery(name = "ProduccionMaterial.findAll", query = "SELECT p FROM ProduccionMaterial p")
    , @NamedQuery(name = "ProduccionMaterial.findByCodproduccionmaterial", query = "SELECT p FROM ProduccionMaterial p WHERE p.codproduccionmaterial = :codproduccionmaterial")})
public class ProduccionMaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_produccion_material")
    private Integer codproduccionmaterial;
    @JoinColumn(name = "Cod_material", referencedColumnName = "Cod_material")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Material codmaterial;
    @JoinColumn(name = "Cod_produccion", referencedColumnName = "Cod_produccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produccion codproduccion;

    public ProduccionMaterial() {
    }

    public ProduccionMaterial(Integer codproduccionmaterial) {
        this.codproduccionmaterial = codproduccionmaterial;
    }

    public Integer getCodproduccionmaterial() {
        return codproduccionmaterial;
    }

    public void setCodproduccionmaterial(Integer codproduccionmaterial) {
        this.codproduccionmaterial = codproduccionmaterial;
    }

    public Material getCodmaterial() {
        return codmaterial;
    }

    public void setCodmaterial(Material codmaterial) {
        this.codmaterial = codmaterial;
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
        hash += (codproduccionmaterial != null ? codproduccionmaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduccionMaterial)) {
            return false;
        }
        ProduccionMaterial other = (ProduccionMaterial) object;
        if ((this.codproduccionmaterial == null && other.codproduccionmaterial != null) || (this.codproduccionmaterial != null && !this.codproduccionmaterial.equals(other.codproduccionmaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ProduccionMaterial[ codproduccionmaterial=" + codproduccionmaterial + " ]";
    }
    
}
