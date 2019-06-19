/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByCodproducto", query = "SELECT p FROM Producto p WHERE p.codproducto = :codproducto")
    , @NamedQuery(name = "Producto.findByExistencia", query = "SELECT p FROM Producto p WHERE p.existencia = :existencia")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByUbicacion", query = "SELECT p FROM Producto p WHERE p.ubicacion = :ubicacion")
    , @NamedQuery(name = "Producto.findByValorunitario", query = "SELECT p FROM Producto p WHERE p.valorunitario = :valorunitario")
    , @NamedQuery(name = "Producto.findByCategoria", query = "SELECT p FROM Producto p WHERE p.categoria = :categoria")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_producto")
    private Integer codproducto;
    @Size(max = 10)
    @Column(name = "Existencia")
    private String existencia;
    @Size(max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 20)
    @Column(name = "Ubicacion")
    private String ubicacion;
    @Column(name = "Valor_unitario")
    private BigInteger valorunitario;
    @Size(max = 20)
    @Column(name = "Categoria")
    private String categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codproducto", fetch = FetchType.LAZY)
    private List<Material> materialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codproducto", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codproducto", fetch = FetchType.LAZY)
    private List<ProductoCotizacion> productoCotizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codproducto", fetch = FetchType.LAZY)
    private List<Produccion> produccionList;

    public Producto() {
    }

    public Producto(Integer codproducto) {
        this.codproducto = codproducto;
    }

    public Integer getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(Integer codproducto) {
        this.codproducto = codproducto;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public BigInteger getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigInteger valorunitario) {
        this.valorunitario = valorunitario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    public List<ProductoCotizacion> getProductoCotizacionList() {
        return productoCotizacionList;
    }

    public void setProductoCotizacionList(List<ProductoCotizacion> productoCotizacionList) {
        this.productoCotizacionList = productoCotizacionList;
    }

    public List<Produccion> getProduccionList() {
        return produccionList;
    }

    public void setProduccionList(List<Produccion> produccionList) {
        this.produccionList = produccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codproducto != null ? codproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codproducto == null && other.codproducto != null) || (this.codproducto != null && !this.codproducto.equals(other.codproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Producto[ codproducto=" + codproducto + " ]";
    }
    
}
