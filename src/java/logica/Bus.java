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
@Table(name = "bus")
@NamedQueries({
    @NamedQuery(name = "Bus.findAll", query = "SELECT b FROM Bus b"),
    @NamedQuery(name = "Bus.findByNumerochasisBus", query = "SELECT b FROM Bus b WHERE b.numerochasisBus = :numerochasisBus"),
    @NamedQuery(name = "Bus.findByPlacaBus", query = "SELECT b FROM Bus b WHERE b.placaBus = :placaBus"),
    @NamedQuery(name = "Bus.findByNumeropasajerosBus", query = "SELECT b FROM Bus b WHERE b.numeropasajerosBus = :numeropasajerosBus"),
    @NamedQuery(name = "Bus.findByTipoBus", query = "SELECT b FROM Bus b WHERE b.tipoBus = :tipoBus")})
public class Bus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numerochasis_bus", nullable = false, length = 50)
    private String numerochasisBus;
    @Size(max = 50)
    @Column(name = "placa_bus", length = 50)
    private String placaBus;
    @Size(max = 50)
    @Column(name = "numeropasajeros_bus", length = 50)
    private String numeropasajerosBus;
    @Size(max = 50)
    @Column(name = "tipo_bus", length = 50)
    private String tipoBus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bus")
    private List<ConductorBus> conductorBusList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bus")
    private List<BusRuta> busRutaList;

    public Bus() {
    }

    public Bus(String numerochasisBus) {
        this.numerochasisBus = numerochasisBus;
    }

    public String getNumerochasisBus() {
        return numerochasisBus;
    }

    public void setNumerochasisBus(String numerochasisBus) {
        this.numerochasisBus = numerochasisBus;
    }

    public String getPlacaBus() {
        return placaBus;
    }

    public void setPlacaBus(String placaBus) {
        this.placaBus = placaBus;
    }

    public String getNumeropasajerosBus() {
        return numeropasajerosBus;
    }

    public void setNumeropasajerosBus(String numeropasajerosBus) {
        this.numeropasajerosBus = numeropasajerosBus;
    }

    public String getTipoBus() {
        return tipoBus;
    }

    public void setTipoBus(String tipoBus) {
        this.tipoBus = tipoBus;
    }

    public List<ConductorBus> getConductorBusList() {
        return conductorBusList;
    }

    public void setConductorBusList(List<ConductorBus> conductorBusList) {
        this.conductorBusList = conductorBusList;
    }

    public List<BusRuta> getBusRutaList() {
        return busRutaList;
    }

    public void setBusRutaList(List<BusRuta> busRutaList) {
        this.busRutaList = busRutaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerochasisBus != null ? numerochasisBus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bus)) {
            return false;
        }
        Bus other = (Bus) object;
        if ((this.numerochasisBus == null && other.numerochasisBus != null) || (this.numerochasisBus != null && !this.numerochasisBus.equals(other.numerochasisBus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Bus[ numerochasisBus=" + numerochasisBus + " ]";
    }
    
}
