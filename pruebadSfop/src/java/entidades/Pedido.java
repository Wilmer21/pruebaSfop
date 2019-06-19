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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hachi
 */
@Entity
@Table(name = "pedido")
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByCodpedido", query = "SELECT p FROM Pedido p WHERE p.codpedido = :codpedido")
    , @NamedQuery(name = "Pedido.findByTipopedido", query = "SELECT p FROM Pedido p WHERE p.tipopedido = :tipopedido")
    , @NamedQuery(name = "Pedido.findByCantidadmaterial", query = "SELECT p FROM Pedido p WHERE p.cantidadmaterial = :cantidadmaterial")
    , @NamedQuery(name = "Pedido.findByValortotal", query = "SELECT p FROM Pedido p WHERE p.valortotal = :valortotal")
    , @NamedQuery(name = "Pedido.findByFechaentrada", query = "SELECT p FROM Pedido p WHERE p.fechaentrada = :fechaentrada")
    , @NamedQuery(name = "Pedido.findByFechaentrega", query = "SELECT p FROM Pedido p WHERE p.fechaentrega = :fechaentrega")
    , @NamedQuery(name = "Pedido.findByCodusuario", query = "SELECT p FROM Pedido p WHERE p.codusuario = :codusuario")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_pedido")
    private Integer codpedido;
    @Size(max = 30)
    @Column(name = "Tipo_pedido")
    private String tipopedido;
    @Column(name = "Cantidad_material")
    private BigInteger cantidadmaterial;
    @Column(name = "Valor_total")
    private BigInteger valortotal;
    @Size(max = 20)
    @Column(name = "Fecha_entrada")
    private String fechaentrada;
    @Size(max = 20)
    @Column(name = "Fecha_entrega")
    private String fechaentrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cod_usuario")
    private int codusuario;
    @JoinColumn(name = "Cod_producto", referencedColumnName = "Cod_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto codproducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpedido", fetch = FetchType.LAZY)
    private List<Instalacion> instalacionList;

    public Pedido() {
    }

    public Pedido(Integer codpedido) {
        this.codpedido = codpedido;
    }

    public Pedido(Integer codpedido, int codusuario) {
        this.codpedido = codpedido;
        this.codusuario = codusuario;
    }

    public Integer getCodpedido() {
        return codpedido;
    }

    public void setCodpedido(Integer codpedido) {
        this.codpedido = codpedido;
    }

    public String getTipopedido() {
        return tipopedido;
    }

    public void setTipopedido(String tipopedido) {
        this.tipopedido = tipopedido;
    }

    public BigInteger getCantidadmaterial() {
        return cantidadmaterial;
    }

    public void setCantidadmaterial(BigInteger cantidadmaterial) {
        this.cantidadmaterial = cantidadmaterial;
    }

    public BigInteger getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigInteger valortotal) {
        this.valortotal = valortotal;
    }

    public String getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(String fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public int getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    public Producto getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(Producto codproducto) {
        this.codproducto = codproducto;
    }

    public List<Instalacion> getInstalacionList() {
        return instalacionList;
    }

    public void setInstalacionList(List<Instalacion> instalacionList) {
        this.instalacionList = instalacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpedido != null ? codpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.codpedido == null && other.codpedido != null) || (this.codpedido != null && !this.codpedido.equals(other.codpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pedido[ codpedido=" + codpedido + " ]";
    }
    
}
