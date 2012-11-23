/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "estacion")
@NamedQueries({
    @NamedQuery(name = "Estacion.findAll", query = "SELECT e FROM Estacion e"),
    @NamedQuery(name = "Estacion.findByNombreEstacion", query = "SELECT e FROM Estacion e WHERE e.nombreEstacion = :nombreEstacion"),
    @NamedQuery(name = "Estacion.findByDireccionEstacion", query = "SELECT e FROM Estacion e WHERE e.direccionEstacion = :direccionEstacion")})
public class Estacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_estacion", nullable = false, length = 50)
    private String nombreEstacion;
    @Size(max = 50)
    @Column(name = "direccion_estacion", length = 50)
    private String direccionEstacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estacion")
    private List<TarjetaEstacion> tarjetaEstacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estacion")
    private List<EstacionDirectorestacion> estacionDirectorestacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estacion")
    private List<EstacionAuxservicio> estacionAuxservicioList;

    public Estacion() {
    }

    public Estacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }

    public String getNombreEstacion() {
        return nombreEstacion;
    }

    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }

    public String getDireccionEstacion() {
        return direccionEstacion;
    }

    public void setDireccionEstacion(String direccionEstacion) {
        this.direccionEstacion = direccionEstacion;
    }

    public List<TarjetaEstacion> getTarjetaEstacionList() {
        return tarjetaEstacionList;
    }

    public void setTarjetaEstacionList(List<TarjetaEstacion> tarjetaEstacionList) {
        this.tarjetaEstacionList = tarjetaEstacionList;
    }

    public List<EstacionDirectorestacion> getEstacionDirectorestacionList() {
        return estacionDirectorestacionList;
    }

    public void setEstacionDirectorestacionList(List<EstacionDirectorestacion> estacionDirectorestacionList) {
        this.estacionDirectorestacionList = estacionDirectorestacionList;
    }

    public List<EstacionAuxservicio> getEstacionAuxservicioList() {
        return estacionAuxservicioList;
    }

    public void setEstacionAuxservicioList(List<EstacionAuxservicio> estacionAuxservicioList) {
        this.estacionAuxservicioList = estacionAuxservicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreEstacion != null ? nombreEstacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estacion)) {
            return false;
        }
        Estacion other = (Estacion) object;
        if ((this.nombreEstacion == null && other.nombreEstacion != null) || (this.nombreEstacion != null && !this.nombreEstacion.equals(other.nombreEstacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Estacion[ nombreEstacion=" + nombreEstacion + " ]";
    }
    
}
