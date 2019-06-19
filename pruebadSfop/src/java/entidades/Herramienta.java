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
@Table(name = "herramienta")
@NamedQueries({
    @NamedQuery(name = "Herramienta.findAll", query = "SELECT h FROM Herramienta h")
    , @NamedQuery(name = "Herramienta.findByCodherramienta", query = "SELECT h FROM Herramienta h WHERE h.codherramienta = :codherramienta")
    , @NamedQuery(name = "Herramienta.findByHerramienta", query = "SELECT h FROM Herramienta h WHERE h.herramienta = :herramienta")
    , @NamedQuery(name = "Herramienta.findByDescripcion", query = "SELECT h FROM Herramienta h WHERE h.descripcion = :descripcion")})
public class Herramienta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_herramienta")
    private Integer codherramienta;
    @Size(max = 30)
    @Column(name = "Herramienta")
    private String herramienta;
    @Size(max = 30)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codherramienta", fetch = FetchType.LAZY)
    private List<HerramientaProduccion> herramientaProduccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codherramienta", fetch = FetchType.LAZY)
    private List<InstalacionHerramienta> instalacionHerramientaList;

    public Herramienta() {
    }

    public Herramienta(Integer codherramienta) {
        this.codherramienta = codherramienta;
    }

    public Integer getCodherramienta() {
        return codherramienta;
    }

    public void setCodherramienta(Integer codherramienta) {
        this.codherramienta = codherramienta;
    }

    public String getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<HerramientaProduccion> getHerramientaProduccionList() {
        return herramientaProduccionList;
    }

    public void setHerramientaProduccionList(List<HerramientaProduccion> herramientaProduccionList) {
        this.herramientaProduccionList = herramientaProduccionList;
    }

    public List<InstalacionHerramienta> getInstalacionHerramientaList() {
        return instalacionHerramientaList;
    }

    public void setInstalacionHerramientaList(List<InstalacionHerramienta> instalacionHerramientaList) {
        this.instalacionHerramientaList = instalacionHerramientaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codherramienta != null ? codherramienta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Herramienta)) {
            return false;
        }
        Herramienta other = (Herramienta) object;
        if ((this.codherramienta == null && other.codherramienta != null) || (this.codherramienta != null && !this.codherramienta.equals(other.codherramienta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Herramienta[ codherramienta=" + codherramienta + " ]";
    }
    
}
