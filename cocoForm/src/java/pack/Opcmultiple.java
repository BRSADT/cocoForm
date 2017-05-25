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
@Table(name = "opcmultiple", catalog = "coco1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opcmultiple.findAll", query = "SELECT o FROM Opcmultiple o")
    , @NamedQuery(name = "Opcmultiple.findByIDOpcion", query = "SELECT o FROM Opcmultiple o WHERE o.iDOpcion = :iDOpcion")
    , @NamedQuery(name = "Opcmultiple.findByTexto", query = "SELECT o FROM Opcmultiple o WHERE o.texto = :texto")})
public class Opcmultiple implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Opcion", nullable = false)
    private Integer iDOpcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "Texto", nullable = false, length = 80)
    private String texto;
    @JoinColumn(name = "ID_Pregunta", referencedColumnName = "ID_Pregunta", nullable = false)
    @ManyToOne(optional = false)
    private Pregunta iDPregunta;

    public Opcmultiple() {
    }

    public Opcmultiple(Integer iDOpcion) {
        this.iDOpcion = iDOpcion;
    }

    public Opcmultiple(Integer iDOpcion, String texto) {
        this.iDOpcion = iDOpcion;
        this.texto = texto;
    }

    public Integer getIDOpcion() {
        return iDOpcion;
    }

    public void setIDOpcion(Integer iDOpcion) {
        this.iDOpcion = iDOpcion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
        hash += (iDOpcion != null ? iDOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcmultiple)) {
            return false;
        }
        Opcmultiple other = (Opcmultiple) object;
        if ((this.iDOpcion == null && other.iDOpcion != null) || (this.iDOpcion != null && !this.iDOpcion.equals(other.iDOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Opcmultiple[ iDOpcion=" + iDOpcion + " ]";
    }
    
}
