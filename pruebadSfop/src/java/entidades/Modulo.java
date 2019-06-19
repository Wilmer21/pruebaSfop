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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hachi
 */
@Entity
@Table(name = "modulo")
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m")
    , @NamedQuery(name = "Modulo.findByCodmodulo", query = "SELECT m FROM Modulo m WHERE m.codmodulo = :codmodulo")
    , @NamedQuery(name = "Modulo.findByNamemodulo", query = "SELECT m FROM Modulo m WHERE m.namemodulo = :namemodulo")
    , @NamedQuery(name = "Modulo.findByUrl", query = "SELECT m FROM Modulo m WHERE m.url = :url")
    , @NamedQuery(name = "Modulo.findByCodpadre", query = "SELECT m FROM Modulo m WHERE m.codpadre = :codpadre")})
public class Modulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_modulo")
    private Integer codmodulo;
    @Size(max = 30)
    @Column(name = "Name_modulo")
    private String namemodulo;
    @Size(max = 30)
    @Column(name = "Url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cod_padre")
    private int codpadre;
    @JoinColumn(name = "Cod_perfil", referencedColumnName = "Cod_perfil")
    @ManyToOne(fetch = FetchType.LAZY)
    private Perfil codperfil;

    public Modulo() {
    }

    public Modulo(Integer codmodulo) {
        this.codmodulo = codmodulo;
    }

    public Modulo(Integer codmodulo, int codpadre) {
        this.codmodulo = codmodulo;
        this.codpadre = codpadre;
    }

    public Integer getCodmodulo() {
        return codmodulo;
    }

    public void setCodmodulo(Integer codmodulo) {
        this.codmodulo = codmodulo;
    }

    public String getNamemodulo() {
        return namemodulo;
    }

    public void setNamemodulo(String namemodulo) {
        this.namemodulo = namemodulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCodpadre() {
        return codpadre;
    }

    public void setCodpadre(int codpadre) {
        this.codpadre = codpadre;
    }

    public Perfil getCodperfil() {
        return codperfil;
    }

    public void setCodperfil(Perfil codperfil) {
        this.codperfil = codperfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmodulo != null ? codmodulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.codmodulo == null && other.codmodulo != null) || (this.codmodulo != null && !this.codmodulo.equals(other.codmodulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Modulo[ codmodulo=" + codmodulo + " ]";
    }
    
}
