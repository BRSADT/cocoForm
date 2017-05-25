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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Samantha
 */
@Entity
@Table(name = "t_respuestas", catalog = "coco1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TRespuestas.findAll", query = "SELECT t FROM TRespuestas t")
    , @NamedQuery(name = "TRespuestas.findByIDTres", query = "SELECT t FROM TRespuestas t WHERE t.iDTres = :iDTres")
    , @NamedQuery(name = "TRespuestas.findByCorreo", query = "SELECT t FROM TRespuestas t WHERE t.correo = :correo")})
public class TRespuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Tres", nullable = false)
    private Integer iDTres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "correo", nullable = false, length = 60)
    private String correo;
    @JoinColumn(name = "ID_Respuesta", referencedColumnName = "ID_Respuesta", nullable = false)
    @ManyToOne(optional = false)
    private Respuesta iDRespuesta;
    @JoinColumn(name = "ID_Pregunta", referencedColumnName = "ID_Pregunta", nullable = false)
    @ManyToOne(optional = false)
    private Pregunta iDPregunta;

    public TRespuestas() {
    }

    public TRespuestas(Integer iDTres) {
        this.iDTres = iDTres;
    }

    public TRespuestas(Integer iDTres, String correo) {
        this.iDTres = iDTres;
        this.correo = correo;
    }

    public Integer getIDTres() {
        return iDTres;
    }

    public void setIDTres(Integer iDTres) {
        this.iDTres = iDTres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Respuesta getIDRespuesta() {
        return iDRespuesta;
    }

    public void setIDRespuesta(Respuesta iDRespuesta) {
        this.iDRespuesta = iDRespuesta;
    }

    public Pregunta getIDPregunta() {
        return iDPregunta;
    }

    public void setIDPregunta(Pregunta iDPregunta) {
        this.iDPregunta = iDPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDTres != null ? iDTres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRespuestas)) {
            return false;
        }
        TRespuestas other = (TRespuestas) object;
        if ((this.iDTres == null && other.iDTres != null) || (this.iDTres != null && !this.iDTres.equals(other.iDTres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.TRespuestas[ iDTres=" + iDTres + " ]";
    }
    
}
