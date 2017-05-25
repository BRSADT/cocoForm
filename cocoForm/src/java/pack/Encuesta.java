/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Samantha
 */
@Entity
@Table(name = "encuesta", catalog = "coco1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuesta.findAll", query = "SELECT e FROM Encuesta e")
    , @NamedQuery(name = "Encuesta.findByIDEncuesta", query = "SELECT e FROM Encuesta e WHERE e.iDEncuesta = :iDEncuesta")
    , @NamedQuery(name = "Encuesta.findByTitulo", query = "SELECT e FROM Encuesta e WHERE e.titulo = :titulo")
    , @NamedQuery(name = "Encuesta.findByIDUsuario", query = "SELECT e FROM Encuesta e WHERE e.iDUsuario = :iDUsuario")
    , @NamedQuery(name = "Encuesta.findByFechaC", query = "SELECT e FROM Encuesta e WHERE e.fechaC = :fechaC")
    , @NamedQuery(name = "Encuesta.findByFechaE", query = "SELECT e FROM Encuesta e WHERE e.fechaE = :fechaE")
    , @NamedQuery(name = "Encuesta.findByIDCategoria", query = "SELECT e FROM Encuesta e WHERE e.iDCategoria = :iDCategoria")
    , @NamedQuery(name = "Encuesta.findBySuspencion", query = "SELECT e FROM Encuesta e WHERE e.suspencion = :suspencion")})
public class Encuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Encuesta", nullable = false)
    private Integer iDEncuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Titulo", nullable = false, length = 60)
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Usuario", nullable = false)
    private int iDUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_C", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaC;
    @Column(name = "Fecha_E")
    @Temporal(TemporalType.DATE)
    private Date fechaE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Categoria", nullable = false)
    private int iDCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Suspencion", nullable = false)
    private int suspencion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "encuesta")
    private Categoria categoria;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "encuesta")
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDEncuesta")
    private List<Pregunta> preguntaList;

    public Encuesta() {
    }

    public Encuesta(Integer iDEncuesta) {
        this.iDEncuesta = iDEncuesta;
    }

    public Encuesta(Integer iDEncuesta, String titulo, int iDUsuario, Date fechaC, int iDCategoria, int suspencion) {
        this.iDEncuesta = iDEncuesta;
        this.titulo = titulo;
        this.iDUsuario = iDUsuario;
        this.fechaC = fechaC;
        this.iDCategoria = iDCategoria;
        this.suspencion = suspencion;
    }

    public Integer getIDEncuesta() {
        return iDEncuesta;
    }

    public void setIDEncuesta(Integer iDEncuesta) {
        this.iDEncuesta = iDEncuesta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIDUsuario() {
        return iDUsuario;
    }

    public void setIDUsuario(int iDUsuario) {
        this.iDUsuario = iDUsuario;
    }

    public Date getFechaC() {
        return fechaC;
    }

    public void setFechaC(Date fechaC) {
        this.fechaC = fechaC;
    }

    public Date getFechaE() {
        return fechaE;
    }

    public void setFechaE(Date fechaE) {
        this.fechaE = fechaE;
    }

    public int getIDCategoria() {
        return iDCategoria;
    }

    public void setIDCategoria(int iDCategoria) {
        this.iDCategoria = iDCategoria;
    }

    public int getSuspencion() {
        return suspencion;
    }

    public void setSuspencion(int suspencion) {
        this.suspencion = suspencion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDEncuesta != null ? iDEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuesta)) {
            return false;
        }
        Encuesta other = (Encuesta) object;
        if ((this.iDEncuesta == null && other.iDEncuesta != null) || (this.iDEncuesta != null && !this.iDEncuesta.equals(other.iDEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Encuesta[ iDEncuesta=" + iDEncuesta + " ]";
    }
    
}
