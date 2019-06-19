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
import javax.validation.constraints.Size;

/**
 *
 * @author hachi
 */
@Entity
@Table(name = "orden_compra")
@NamedQueries({
    @NamedQuery(name = "OrdenCompra.findAll", query = "SELECT o FROM OrdenCompra o")
    , @NamedQuery(name = "OrdenCompra.findByCodsolicitud", query = "SELECT o FROM OrdenCompra o WHERE o.codsolicitud = :codsolicitud")
    , @NamedQuery(name = "OrdenCompra.findByValorsolicitud", query = "SELECT o FROM OrdenCompra o WHERE o.valorsolicitud = :valorsolicitud")
    , @NamedQuery(name = "OrdenCompra.findByCantidad", query = "SELECT o FROM OrdenCompra o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "OrdenCompra.findByDescripcion", query = "SELECT o FROM OrdenCompra o WHERE o.descripcion = :descripcion")})
public class OrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_solicitud")
    private Integer codsolicitud;
    @Column(name = "Valor_solicitud")
    private Integer valorsolicitud;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Size(max = 20)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "Cod_entrega", referencedColumnName = "Cod_entrega")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Entrega codentrega;

    public OrdenCompra() {
    }

    public OrdenCompra(Integer codsolicitud) {
        this.codsolicitud = codsolicitud;
    }

    public Integer getCodsolicitud() {
        return codsolicitud;
    }

    public void setCodsolicitud(Integer codsolicitud) {
        this.codsolicitud = codsolicitud;
    }

    public Integer getValorsolicitud() {
        return valorsolicitud;
    }

    public void setValorsolicitud(Integer valorsolicitud) {
        this.valorsolicitud = valorsolicitud;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Entrega getCodentrega() {
        return codentrega;
    }

    public void setCodentrega(Entrega codentrega) {
        this.codentrega = codentrega;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsolicitud != null ? codsolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompra)) {
            return false;
        }
        OrdenCompra other = (OrdenCompra) object;
        if ((this.codsolicitud == null && other.codsolicitud != null) || (this.codsolicitud != null && !this.codsolicitud.equals(other.codsolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.OrdenCompra[ codsolicitud=" + codsolicitud + " ]";
    }
    
}
