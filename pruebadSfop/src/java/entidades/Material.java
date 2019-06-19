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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hachi
 */
@Entity
@Table(name = "material")
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m")
    , @NamedQuery(name = "Material.findByCodmaterial", query = "SELECT m FROM Material m WHERE m.codmaterial = :codmaterial")
    , @NamedQuery(name = "Material.findByDescripcion", query = "SELECT m FROM Material m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Material.findByNombrematerial", query = "SELECT m FROM Material m WHERE m.nombrematerial = :nombrematerial")
    , @NamedQuery(name = "Material.findByStock", query = "SELECT m FROM Material m WHERE m.stock = :stock")
    , @NamedQuery(name = "Material.findByValormaterial", query = "SELECT m FROM Material m WHERE m.valormaterial = :valormaterial")
    , @NamedQuery(name = "Material.findByTipomateria", query = "SELECT m FROM Material m WHERE m.tipomateria = :tipomateria")
    , @NamedQuery(name = "Material.findByCodsolicitud", query = "SELECT m FROM Material m WHERE m.codsolicitud = :codsolicitud")})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_material")
    private Integer codmaterial;
    @Size(max = 30)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 30)
    @Column(name = "Nombre_material")
    private String nombrematerial;
    @Column(name = "Stock")
    private Integer stock;
    @Column(name = "Valor_material")
    private Integer valormaterial;
    @Size(max = 30)
    @Column(name = "Tipo_materia")
    private String tipomateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cod_solicitud")
    private int codsolicitud;
    @JoinColumn(name = "Cod_producto", referencedColumnName = "Cod_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto codproducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmaterial", fetch = FetchType.LAZY)
    private List<ProduccionMaterial> produccionMaterialList;

    public Material() {
    }

    public Material(Integer codmaterial) {
        this.codmaterial = codmaterial;
    }

    public Material(Integer codmaterial, int codsolicitud) {
        this.codmaterial = codmaterial;
        this.codsolicitud = codsolicitud;
    }

    public Integer getCodmaterial() {
        return codmaterial;
    }

    public void setCodmaterial(Integer codmaterial) {
        this.codmaterial = codmaterial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombrematerial() {
        return nombrematerial;
    }

    public void setNombrematerial(String nombrematerial) {
        this.nombrematerial = nombrematerial;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getValormaterial() {
        return valormaterial;
    }

    public void setValormaterial(Integer valormaterial) {
        this.valormaterial = valormaterial;
    }

    public String getTipomateria() {
        return tipomateria;
    }

    public void setTipomateria(String tipomateria) {
        this.tipomateria = tipomateria;
    }

    public int getCodsolicitud() {
        return codsolicitud;
    }

    public void setCodsolicitud(int codsolicitud) {
        this.codsolicitud = codsolicitud;
    }

    public Producto getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(Producto codproducto) {
        this.codproducto = codproducto;
    }

    public List<ProduccionMaterial> getProduccionMaterialList() {
        return produccionMaterialList;
    }

    public void setProduccionMaterialList(List<ProduccionMaterial> produccionMaterialList) {
        this.produccionMaterialList = produccionMaterialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmaterial != null ? codmaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.codmaterial == null && other.codmaterial != null) || (this.codmaterial != null && !this.codmaterial.equals(other.codmaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Material[ codmaterial=" + codmaterial + " ]";
    }
    
}
