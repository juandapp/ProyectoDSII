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
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdentificacionEmpleado", query = "SELECT e FROM Empleado e WHERE e.identificacionEmpleado = :identificacionEmpleado"),
    @NamedQuery(name = "Empleado.findByNombreEmpleado", query = "SELECT e FROM Empleado e WHERE e.nombreEmpleado = :nombreEmpleado"),
    @NamedQuery(name = "Empleado.findByDireccionEmpleado", query = "SELECT e FROM Empleado e WHERE e.direccionEmpleado = :direccionEmpleado"),
    @NamedQuery(name = "Empleado.findByTelefonoEmpleado", query = "SELECT e FROM Empleado e WHERE e.telefonoEmpleado = :telefonoEmpleado"),
    @NamedQuery(name = "Empleado.findByEmailEmpleado", query = "SELECT e FROM Empleado e WHERE e.emailEmpleado = :emailEmpleado"),
    @NamedQuery(name = "Empleado.findByTipoEmpleado", query = "SELECT e FROM Empleado e WHERE e.tipoEmpleado = :tipoEmpleado"),
    @NamedQuery(name = "Empleado.findByPasswordEmpleado", query = "SELECT e FROM Empleado e WHERE e.passwordEmpleado = :passwordEmpleado")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "identificacion_empleado", nullable = false, length = 50)
    private String identificacionEmpleado;
    @Size(max = 50)
    @Column(name = "nombre_empleado", length = 50)
    private String nombreEmpleado;
    @Size(max = 50)
    @Column(name = "direccion_empleado", length = 50)
    private String direccionEmpleado;
    @Size(max = 50)
    @Column(name = "telefono_empleado", length = 50)
    private String telefonoEmpleado;
    @Size(max = 50)
    @Column(name = "email_empleado", length = 50)
    private String emailEmpleado;
    @Size(max = 50)
    @Column(name = "tipo_empleado", length = 50)
    private String tipoEmpleado;
    @Size(max = 50)
    @Column(name = "password_empleado", length = 50)
    private String passwordEmpleado;
    @OneToMany(mappedBy = "identificacionAuxservicio")
    private List<TarjetaPersonalizada> tarjetaPersonalizadaList;
    @OneToMany(mappedBy = "identificacionDirectorestacion")
    private List<Reclamo> reclamoList;
    @OneToMany(mappedBy = "identificacionAuxservicio")
    private List<Reclamo> reclamoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<ConductorBus> conductorBusList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Recarga> recargaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<EstacionDirectorestacion> estacionDirectorestacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<EstacionAuxservicio> estacionAuxservicioList;

    public Empleado() {
    }

    public Empleado(String identificacionEmpleado) {
        this.identificacionEmpleado = identificacionEmpleado;
    }

    public String getIdentificacionEmpleado() {
        return identificacionEmpleado;
    }

    public void setIdentificacionEmpleado(String identificacionEmpleado) {
        this.identificacionEmpleado = identificacionEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getEmailEmpleado() {
        return emailEmpleado;
    }

    public void setEmailEmpleado(String emailEmpleado) {
        this.emailEmpleado = emailEmpleado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getPasswordEmpleado() {
        return passwordEmpleado;
    }

    public void setPasswordEmpleado(String passwordEmpleado) {
        this.passwordEmpleado = passwordEmpleado;
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

    public List<Reclamo> getReclamoList1() {
        return reclamoList1;
    }

    public void setReclamoList1(List<Reclamo> reclamoList1) {
        this.reclamoList1 = reclamoList1;
    }

    public List<ConductorBus> getConductorBusList() {
        return conductorBusList;
    }

    public void setConductorBusList(List<ConductorBus> conductorBusList) {
        this.conductorBusList = conductorBusList;
    }

    public List<Recarga> getRecargaList() {
        return recargaList;
    }

    public void setRecargaList(List<Recarga> recargaList) {
        this.recargaList = recargaList;
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
        hash += (identificacionEmpleado != null ? identificacionEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.identificacionEmpleado == null && other.identificacionEmpleado != null) || (this.identificacionEmpleado != null && !this.identificacionEmpleado.equals(other.identificacionEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Empleado[ identificacionEmpleado=" + identificacionEmpleado + " ]";
    }
    
}
