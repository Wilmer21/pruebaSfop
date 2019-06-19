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
@Table(name = "instalacion_herramienta")
@NamedQueries({
    @NamedQuery(name = "InstalacionHerramienta.findAll", query = "SELECT i FROM InstalacionHerramienta i")
    , @NamedQuery(name = "InstalacionHerramienta.findByCodinstalacionherramienta", query = "SELECT i FROM InstalacionHerramienta i WHERE i.codinstalacionherramienta = :codinstalacionherramienta")})
public class InstalacionHerramienta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_instalacion_herramienta")
    private Integer codinstalacionherramienta;
    @JoinColumn(name = "Cod_herramienta", referencedColumnName = "Cod_herramienta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Herramienta codherramienta;
    @JoinColumn(name = "Cod_instalacion", referencedColumnName = "Cod_instalacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Instalacion codinstalacion;

    public InstalacionHerramienta() {
    }

    public InstalacionHerramienta(Integer codinstalacionherramienta) {
        this.codinstalacionherramienta = codinstalacionherramienta;
    }

    public Integer getCodinstalacionherramienta() {
        return codinstalacionherramienta;
    }

    public void setCodinstalacionherramienta(Integer codinstalacionherramienta) {
        this.codinstalacionherramienta = codinstalacionherramienta;
    }

    public Herramienta getCodherramienta() {
        return codherramienta;
    }

    public void setCodherramienta(Herramienta codherramienta) {
        this.codherramienta = codherramienta;
    }

    public Instalacion getCodinstalacion() {
        return codinstalacion;
    }

    public void setCodinstalacion(Instalacion codinstalacion) {
        this.codinstalacion = codinstalacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codinstalacionherramienta != null ? codinstalacionherramienta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstalacionHerramienta)) {
            return false;
        }
        InstalacionHerramienta other = (InstalacionHerramienta) object;
        if ((this.codinstalacionherramienta == null && other.codinstalacionherramienta != null) || (this.codinstalacionherramienta != null && !this.codinstalacionherramienta.equals(other.codinstalacionherramienta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.InstalacionHerramienta[ codinstalacionherramienta=" + codinstalacionherramienta + " ]";
    }
    
}
