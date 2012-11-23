/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JUANPAULO
 */
@Entity
@Table(name = "reclamo")
@NamedQueries({
    @NamedQuery(name = "Reclamo.findAll", query = "SELECT r FROM Reclamo r"),
    @NamedQuery(name = "Reclamo.findByTicketReclamo", query = "SELECT r FROM Reclamo r WHERE r.ticketReclamo = :ticketReclamo"),
    @NamedQuery(name = "Reclamo.findByMotivoReclamo", query = "SELECT r FROM Reclamo r WHERE r.motivoReclamo = :motivoReclamo"),
    @NamedQuery(name = "Reclamo.findByDescripcionReclamo", query = "SELECT r FROM Reclamo r WHERE r.descripcionReclamo = :descripcionReclamo"),
    @NamedQuery(name = "Reclamo.findBySolucionReclamo", query = "SELECT r FROM Reclamo r WHERE r.solucionReclamo = :solucionReclamo"),
    @NamedQuery(name = "Reclamo.findByEstadoReclamo", query = "SELECT r FROM Reclamo r WHERE r.estadoReclamo = :estadoReclamo"),
    @NamedQuery(name = "Reclamo.findByFechaReclamo", query = "SELECT r FROM Reclamo r WHERE r.fechaReclamo = :fechaReclamo"),
    @NamedQuery(name = "Reclamo.findByFechaSolucion", query = "SELECT r FROM Reclamo r WHERE r.fechaSolucion = :fechaSolucion")})
public class Reclamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ticket_reclamo", nullable = false, length = 50)
    private String ticketReclamo;
    @Size(max = 50)
    @Column(name = "motivo_reclamo", length = 50)
    private String motivoReclamo;
    @Size(max = 50)
    @Column(name = "descripcion_reclamo", length = 50)
    private String descripcionReclamo;
    @Size(max = 50)
    @Column(name = "solucion_reclamo", length = 50)
    private String solucionReclamo;
    @Size(max = 50)
    @Column(name = "estado_reclamo", length = 50)
    private String estadoReclamo;
    @Column(name = "fecha_reclamo")
    @Temporal(TemporalType.DATE)
    private Date fechaReclamo;
    @Column(name = "fecha_solucion")
    @Temporal(TemporalType.DATE)
    private Date fechaSolucion;
    @JoinColumn(name = "identificacion_pasajero", referencedColumnName = "identificacion_pasajero")
    @ManyToOne
    private Pasajero identificacionPasajero;
    @JoinColumn(name = "identificacion_directorestacion", referencedColumnName = "identificacion_empleado")
    @ManyToOne
    private Empleado identificacionDirectorestacion;
    @JoinColumn(name = "identificacion_auxservicio", referencedColumnName = "identificacion_empleado")
    @ManyToOne
    private Empleado identificacionAuxservicio;

    public Reclamo() {
    }

    public Reclamo(String ticketReclamo) {
        this.ticketReclamo = ticketReclamo;
    }

    public String getTicketReclamo() {
        return ticketReclamo;
    }

    public void setTicketReclamo(String ticketReclamo) {
        this.ticketReclamo = ticketReclamo;
    }

    public String getMotivoReclamo() {
        return motivoReclamo;
    }

    public void setMotivoReclamo(String motivoReclamo) {
        this.motivoReclamo = motivoReclamo;
    }

    public String getDescripcionReclamo() {
        return descripcionReclamo;
    }

    public void setDescripcionReclamo(String descripcionReclamo) {
        this.descripcionReclamo = descripcionReclamo;
    }

    public String getSolucionReclamo() {
        return solucionReclamo;
    }

    public void setSolucionReclamo(String solucionReclamo) {
        this.solucionReclamo = solucionReclamo;
    }

    public String getEstadoReclamo() {
        return estadoReclamo;
    }

    public void setEstadoReclamo(String estadoReclamo) {
        this.estadoReclamo = estadoReclamo;
    }

    public Date getFechaReclamo() {
        return fechaReclamo;
    }

    public void setFechaReclamo(Date fechaReclamo) {
        this.fechaReclamo = fechaReclamo;
    }

    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(Date fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public Pasajero getIdentificacionPasajero() {
        return identificacionPasajero;
    }

    public void setIdentificacionPasajero(Pasajero identificacionPasajero) {
        this.identificacionPasajero = identificacionPasajero;
    }

    public Empleado getIdentificacionDirectorestacion() {
        return identificacionDirectorestacion;
    }

    public void setIdentificacionDirectorestacion(Empleado identificacionDirectorestacion) {
        this.identificacionDirectorestacion = identificacionDirectorestacion;
    }

    public Empleado getIdentificacionAuxservicio() {
        return identificacionAuxservicio;
    }

    public void setIdentificacionAuxservicio(Empleado identificacionAuxservicio) {
        this.identificacionAuxservicio = identificacionAuxservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketReclamo != null ? ticketReclamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reclamo)) {
            return false;
        }
        Reclamo other = (Reclamo) object;
        if ((this.ticketReclamo == null && other.ticketReclamo != null) || (this.ticketReclamo != null && !this.ticketReclamo.equals(other.ticketReclamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Reclamo[ ticketReclamo=" + ticketReclamo + " ]";
    }
    
}
