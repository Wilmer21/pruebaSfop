/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "perfil")
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.findByCodperfil", query = "SELECT p FROM Perfil p WHERE p.codperfil = :codperfil")
    , @NamedQuery(name = "Perfil.findByCargo", query = "SELECT p FROM Perfil p WHERE p.cargo = :cargo")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_perfil")
    private Integer codperfil;
    @Size(max = 30)
    @Column(name = "Cargo")
    private String cargo;
    @OneToMany(mappedBy = "codperfil", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;
    @OneToMany(mappedBy = "codperfil", fetch = FetchType.LAZY)
    private List<Modulo> moduloList;

    public Perfil() {
    }

    public Perfil(Integer codperfil) {
        this.codperfil = codperfil;
    }

    public Integer getCodperfil() {
        return codperfil;
    }

    public void setCodperfil(Integer codperfil) {
        this.codperfil = codperfil;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Modulo> getModuloList() {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList) {
        this.moduloList = moduloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codperfil != null ? codperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.codperfil == null && other.codperfil != null) || (this.codperfil != null && !this.codperfil.equals(other.codperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Perfil[ codperfil=" + codperfil + " ]";
    }
    
}
