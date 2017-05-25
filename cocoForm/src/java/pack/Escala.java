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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Samantha
 */
@Entity
@Table(name = "escala", catalog = "coco1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escala.findAll", query = "SELECT e FROM Escala e")
    , @NamedQuery(name = "Escala.findByIDEscala", query = "SELECT e FROM Escala e WHERE e.iDEscala = :iDEscala")
    , @NamedQuery(name = "Escala.findByMin", query = "SELECT e FROM Escala e WHERE e.min = :min")
    , @NamedQuery(name = "Escala.findByMax", query = "SELECT e FROM Escala e WHERE e.max = :max")})
public class Escala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Escala", nullable = false)
    private Integer iDEscala;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min", nullable = false)
    private int min;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max", nullable = false)
    private int max;
    @JoinColumn(name = "ID_Pregunta", referencedColumnName = "ID_Pregunta", nullable = false)
    @ManyToOne(optional = false)
    private Pregunta iDPregunta;

    public Escala() {
    }

    public Escala(Integer iDEscala) {
        this.iDEscala = iDEscala;
    }

    public Escala(Integer iDEscala, int min, int max) {
        this.iDEscala = iDEscala;
        this.min = min;
        this.max = max;
    }

    public Integer getIDEscala() {
        return iDEscala;
    }

    public void setIDEscala(Integer iDEscala) {
        this.iDEscala = iDEscala;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
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
        hash += (iDEscala != null ? iDEscala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escala)) {
            return false;
        }
        Escala other = (Escala) object;
        if ((this.iDEscala == null && other.iDEscala != null) || (this.iDEscala != null && !this.iDEscala.equals(other.iDEscala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Escala[ iDEscala=" + iDEscala + " ]";
    }
    
}
