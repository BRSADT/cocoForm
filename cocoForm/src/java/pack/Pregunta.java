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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pregunta", catalog = "coco1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p")
    , @NamedQuery(name = "Pregunta.findByIDPregunta", query = "SELECT p FROM Pregunta p WHERE p.iDPregunta = :iDPregunta")
    , @NamedQuery(name = "Pregunta.findByTexto", query = "SELECT p FROM Pregunta p WHERE p.texto = :texto")
    , @NamedQuery(name = "Pregunta.findByTipo", query = "SELECT p FROM Pregunta p WHERE p.tipo = :tipo")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Pregunta", nullable = false)
    private Integer iDPregunta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "Texto", nullable = false, length = 80)
    private String texto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tipo", nullable = false)
    private int tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDPregunta")
    private List<TRespuestas> tRespuestasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDPregunta")
    private List<Opcmultiple> opcmultipleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDPregunta")
    private List<Escala> escalaList;
    @JoinColumn(name = "ID_Encuesta", referencedColumnName = "ID_Encuesta", nullable = false)
    @ManyToOne(optional = false)
    private Encuesta iDEncuesta;

    public Pregunta() {
    }

    public Pregunta(Integer iDPregunta) {
        this.iDPregunta = iDPregunta;
    }

    public Pregunta(Integer iDPregunta, String texto, int tipo) {
        this.iDPregunta = iDPregunta;
        this.texto = texto;
        this.tipo = tipo;
    }

    public Integer getIDPregunta() {
        return iDPregunta;
    }

    public void setIDPregunta(Integer iDPregunta) {
        this.iDPregunta = iDPregunta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<TRespuestas> getTRespuestasList() {
        return tRespuestasList;
    }

    public void setTRespuestasList(List<TRespuestas> tRespuestasList) {
        this.tRespuestasList = tRespuestasList;
    }

    @XmlTransient
    public List<Opcmultiple> getOpcmultipleList() {
        return opcmultipleList;
    }

    public void setOpcmultipleList(List<Opcmultiple> opcmultipleList) {
        this.opcmultipleList = opcmultipleList;
    }

    @XmlTransient
    public List<Escala> getEscalaList() {
        return escalaList;
    }

    public void setEscalaList(List<Escala> escalaList) {
        this.escalaList = escalaList;
    }

    public Encuesta getIDEncuesta() {
        return iDEncuesta;
    }

    public void setIDEncuesta(Encuesta iDEncuesta) {
        this.iDEncuesta = iDEncuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDPregunta != null ? iDPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.iDPregunta == null && other.iDPregunta != null) || (this.iDPregunta != null && !this.iDPregunta.equals(other.iDPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Pregunta[ iDPregunta=" + iDPregunta + " ]";
    }
    
}
