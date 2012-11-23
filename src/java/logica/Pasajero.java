/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JUANPAULO
 */
@Entity
@Table(name = "pasajero")
@NamedQueries({
    @NamedQuery(name = "Pasajero.findAll", query = "SELECT p FROM Pasajero p"),
    @NamedQuery(name = "Pasajero.findByIdentificacionPasajero", query = "SELECT p FROM Pasajero p WHERE p.identificacionPasajero = :identificacionPasajero"),
    @NamedQuery(name = "Pasajero.findByNombrePasajero", query = "SELECT p FROM Pasajero p WHERE p.nombrePasajero = :nombrePasajero"),
    @NamedQuery(name = "Pasajero.findByDireccionPasajero", query = "SELECT p FROM Pasajero p WHERE p.direccionPasajero = :direccionPasajero"),
    @NamedQuery(name = "Pasajero.findByTelefonoPasajero", query = "SELECT p FROM Pasajero p WHERE p.telefonoPasajero = :telefonoPasajero"),
    @NamedQuery(name = "Pasajero.findByEmailPasajero", query = "SELECT p FROM Pasajero p WHERE p.emailPasajero = :emailPasajero")})
public class Pasajero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "identificacion_pasajero", nullable = false, length = 50)
    private String identificacionPasajero;
    @Size(max = 50)
    @Column(name = "nombre_pasajero", length = 50)
    private String nombrePasajero;
    @Size(max = 50)
    @Column(name = "direccion_pasajero", length = 50)
    private String direccionPasajero;
    @Size(max = 50)
    @Column(name = "telefono_pasajero", length = 50)
    private String telefonoPasajero;
    @Size(max = 50)
    @Column(name = "email_pasajero", length = 50)
    private String emailPasajero;
    @OneToMany(mappedBy = "identificacionPasajero")
    private List<TarjetaPersonalizada> tarjetaPersonalizadaList;
    @OneToMany(mappedBy = "identificacionPasajero")
    private List<Reclamo> reclamoList;

    public Pasajero() {
    }

    public Pasajero(String identificacionPasajero) {
        this.identificacionPasajero = identificacionPasajero;
    }

    public String getIdentificacionPasajero() {
        return identificacionPasajero;
    }

    public void setIdentificacionPasajero(String identificacionPasajero) {
        this.identificacionPasajero = identificacionPasajero;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public String getDireccionPasajero() {
        return direccionPasajero;
    }

    public void setDireccionPasajero(String direccionPasajero) {
        this.direccionPasajero = direccionPasajero;
    }

    public String getTelefonoPasajero() {
        return telefonoPasajero;
    }

    public void setTelefonoPasajero(String telefonoPasajero) {
        this.telefonoPasajero = telefonoPasajero;
    }

    public String getEmailPasajero() {
        return emailPasajero;
    }

    public void setEmailPasajero(String emailPasajero) {
        this.emailPasajero = emailPasajero;
    }

    public List<TarjetaPersonalizada> getTarjetaPersonalizadaList() {
        return tarjetaPersonalizadaList;
    }

    public void setTarjetaPersonalizadaList(List<TarjetaPersonalizada> tarjetaPersonalizadaList) {
        this.tarjetaPersonalizadaList = tarjetaPersonalizadaList;
    }

    public List<Reclamo> getReclamoList() {
        return reclamoList;
    }

    public void setReclamoList(List<Reclamo> reclamoList) {
        this.reclamoList = reclamoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacionPasajero != null ? identificacionPasajero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasajero)) {
            return false;
        }
        Pasajero other = (Pasajero) object;
        if ((this.identificacionPasajero == null && other.identificacionPasajero != null) || (this.identificacionPasajero != null && !this.identificacionPasajero.equals(other.identificacionPasajero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Pasajero[ identificacionPasajero=" + identificacionPasajero + " ]";
    }
    
}
