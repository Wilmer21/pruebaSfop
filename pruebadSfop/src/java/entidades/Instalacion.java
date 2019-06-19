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
@Table(name = "instalacion")
@NamedQueries({
    @NamedQuery(name = "Instalacion.findAll", query = "SELECT i FROM Instalacion i")
    , @NamedQuery(name = "Instalacion.findByCodinstalacion", query = "SELECT i FROM Instalacion i WHERE i.codinstalacion = :codinstalacion")
    , @NamedQuery(name = "Instalacion.findByFechainstalacion", query = "SELECT i FROM Instalacion i WHERE i.fechainstalacion = :fechainstalacion")})
public class Instalacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_instalacion")
    private Integer codinstalacion;
    @Size(max = 20)
    @Column(name = "Fecha_instalacion")
    private String fechainstalacion;
    @JoinColumn(name = "Cod_pedido", referencedColumnName = "Cod_pedido")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido codpedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codinstalacion", fetch = FetchType.LAZY)
    private List<InstalacionHerramienta> instalacionHerramientaList;

    public Instalacion() {
    }

    public Instalacion(Integer codinstalacion) {
        this.codinstalacion = codinstalacion;
    }

    public Integer getCodinstalacion() {
        return codinstalacion;
    }

    public void setCodinstalacion(Integer codinstalacion) {
        this.codinstalacion = codinstalacion;
    }

    public String getFechainstalacion() {
        return fechainstalacion;
    }

    public void setFechainstalacion(String fechainstalacion) {
        this.fechainstalacion = fechainstalacion;
    }

    public Pedido getCodpedido() {
        return codpedido;
    }

    public void setCodpedido(Pedido codpedido) {
        this.codpedido = codpedido;
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
        hash += (codinstalacion != null ? codinstalacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instalacion)) {
            return false;
        }
        Instalacion other = (Instalacion) object;
        if ((this.codinstalacion == null && other.codinstalacion != null) || (this.codinstalacion != null && !this.codinstalacion.equals(other.codinstalacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Instalacion[ codinstalacion=" + codinstalacion + " ]";
    }
    
}
