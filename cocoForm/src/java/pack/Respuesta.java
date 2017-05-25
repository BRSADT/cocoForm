/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Samantha
 */
@Entity
@Table(name = "respuesta", catalog = "coco1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r")
    , @NamedQuery(name = "Respuesta.findByIDRespuesta", query = "SELECT r FROM Respuesta r WHERE r.iDRespuesta = :iDRespuesta")
    , @NamedQuery(name = "Respuesta.findByRespuesta", query = "SELECT r FROM Respuesta r WHERE r.respuesta = :respuesta")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Respuesta", nullable = false)
    private Integer iDRespuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "Respuesta", nullable = false, length = 80)
    private String respuesta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDRespuesta")
    private List<TRespuestas> tRespuestasList;

    public Respuesta() {
    }

    public Respuesta(Integer iDRespuesta) {
        this.iDRespuesta = iDRespuesta;
    }

    public Respuesta(Integer iDRespuesta, String respuesta) {
        this.iDRespuesta = iDRespuesta;
        this.respuesta = respuesta;
    }

    public Integer getIDRespuesta() {
        return iDRespuesta;
    }

    public void setIDRespuesta(Integer iDRespuesta) {
        this.iDRespuesta = iDRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @XmlTransient
    public List<TRespuestas> getTRespuestasList() {
        return tRespuestasList;
    }

    public void setTRespuestasList(List<TRespuestas> tRespuestasList) {
        this.tRespuestasList = tRespuestasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDRespuesta != null ? iDRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.iDRespuesta == null && other.iDRespuesta != null) || (this.iDRespuesta != null && !this.iDRespuesta.equals(other.iDRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Respuesta[ iDRespuesta=" + iDRespuesta + " ]";
    }
    
}
