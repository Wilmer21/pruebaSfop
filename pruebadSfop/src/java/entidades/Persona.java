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
@Table(name = "persona")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByNumdocumento", query = "SELECT p FROM Persona p WHERE p.numdocumento = :numdocumento")
    , @NamedQuery(name = "Persona.findByTipodocumento", query = "SELECT p FROM Persona p WHERE p.tipodocumento = :tipodocumento")
    , @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Persona.findBySnombre", query = "SELECT p FROM Persona p WHERE p.snombre = :snombre")
    , @NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Persona.findBySapellido", query = "SELECT p FROM Persona p WHERE p.sapellido = :sapellido")
    , @NamedQuery(name = "Persona.findByNumcelular", query = "SELECT p FROM Persona p WHERE p.numcelular = :numcelular")
    , @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Num_documento")
    private Integer numdocumento;
    @Size(max = 30)
    @Column(name = "Tipo_documento")
    private String tipodocumento;
    @Size(max = 30)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "S_nombre")
    private String snombre;
    @Size(max = 30)
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "S_apellido")
    private String sapellido;
    @Column(name = "Num_celular")
    private Integer numcelular;
    @Size(max = 30)
    @Column(name = "Correo")
    private String correo;
    @JoinColumn(name = "Cod_usuario", referencedColumnName = "Cod_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario codusuario;

    public Persona() {
    }

    public Persona(Integer numdocumento) {
        this.numdocumento = numdocumento;
    }

    public Persona(Integer numdocumento, String snombre, String sapellido) {
        this.numdocumento = numdocumento;
        this.snombre = snombre;
        this.sapellido = sapellido;
    }

    public Integer getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(Integer numdocumento) {
        this.numdocumento = numdocumento;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSapellido() {
        return sapellido;
    }

    public void setSapellido(String sapellido) {
        this.sapellido = sapellido;
    }

    public Integer getNumcelular() {
        return numcelular;
    }

    public void setNumcelular(Integer numcelular) {
        this.numcelular = numcelular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(Usuario codusuario) {
        this.codusuario = codusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numdocumento != null ? numdocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.numdocumento == null && other.numdocumento != null) || (this.numdocumento != null && !this.numdocumento.equals(other.numdocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Persona[ numdocumento=" + numdocumento + " ]";
    }
    
}
