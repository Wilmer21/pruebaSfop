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
@Table(name = "entrega")
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e")
    , @NamedQuery(name = "Entrega.findByCodentrega", query = "SELECT e FROM Entrega e WHERE e.codentrega = :codentrega")
    , @NamedQuery(name = "Entrega.findByMaterialentregado", query = "SELECT e FROM Entrega e WHERE e.materialentregado = :materialentregado")
    , @NamedQuery(name = "Entrega.findByNombreabastecedor", query = "SELECT e FROM Entrega e WHERE e.nombreabastecedor = :nombreabastecedor")
    , @NamedQuery(name = "Entrega.findByFechaentrega", query = "SELECT e FROM Entrega e WHERE e.fechaentrega = :fechaentrega")})
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_entrega")
    private Integer codentrega;
    @Size(max = 30)
    @Column(name = "Material_entregado")
    private String materialentregado;
    @Size(max = 30)
    @Column(name = "Nombre_abastecedor")
    private String nombreabastecedor;
    @Size(max = 30)
    @Column(name = "Fecha_entrega")
    private String fechaentrega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codentrega", fetch = FetchType.LAZY)
    private List<OrdenCompra> ordenCompraList;

    public Entrega() {
    }

    public Entrega(Integer codentrega) {
        this.codentrega = codentrega;
    }

    public Integer getCodentrega() {
        return codentrega;
    }

    public void setCodentrega(Integer codentrega) {
        this.codentrega = codentrega;
    }

    public String getMaterialentregado() {
        return materialentregado;
    }

    public void setMaterialentregado(String materialentregado) {
        this.materialentregado = materialentregado;
    }

    public String getNombreabastecedor() {
        return nombreabastecedor;
    }

    public void setNombreabastecedor(String nombreabastecedor) {
        this.nombreabastecedor = nombreabastecedor;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codentrega != null ? codentrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) object;
        if ((this.codentrega == null && other.codentrega != null) || (this.codentrega != null && !this.codentrega.equals(other.codentrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Entrega[ codentrega=" + codentrega + " ]";
    }
    
}
