/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Samantha
 */
@Entity
@Table(name = "categoria", catalog = "coco1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByIDCategoria", query = "SELECT c FROM Categoria c WHERE c.iDCategoria = :iDCategoria")
    , @NamedQuery(name = "Categoria.findByNombre", query = "SELECT c FROM Categoria c WHERE c.nombre = :nombre")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Categoria", nullable = false)
    private Integer iDCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre", nullable = false, length = 30)
    private String nombre;
    @JoinColumn(name = "ID_Categoria", referencedColumnName = "ID_Categoria", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Encuesta encuesta;

    public Categoria() {
    }

    public Categoria(Integer iDCategoria) {
        this.iDCategoria = iDCategoria;
    }

    public Categoria(Integer iDCategoria, String nombre) {
        this.iDCategoria = iDCategoria;
        this.nombre = nombre;
    }

    public Integer getIDCategoria() {
        return iDCategoria;
    }

    public void setIDCategoria(Integer iDCategoria) {
        this.iDCategoria = iDCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCategoria != null ? iDCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.iDCategoria == null && other.iDCategoria != null) || (this.iDCategoria != null && !this.iDCategoria.equals(other.iDCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Categoria[ iDCategoria=" + iDCategoria + " ]";
    }
    
}
