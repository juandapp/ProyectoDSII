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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JUANPAULO
 */
@Entity
@Table(name = "tarjeta")
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t"),
    @NamedQuery(name = "Tarjeta.findByPinTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.pinTarjeta = :pinTarjeta"),
    @NamedQuery(name = "Tarjeta.findBySaldo", query = "SELECT t FROM Tarjeta t WHERE t.saldo = :saldo"),
    @NamedQuery(name = "Tarjeta.findByEstado", query = "SELECT t FROM Tarjeta t WHERE t.estado = :estado")})
public class Tarjeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pin_tarjeta", nullable = false, length = 50)
    private String pinTarjeta;
    @Column(name = "saldo")
    private Integer saldo;
    @Size(max = 50)
    @Column(name = "estado", length = 50)
    private String estado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tarjeta")
    private TarjetaPersonalizada tarjetaPersonalizada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarjeta")
    private List<TarjetaEstacion> tarjetaEstacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarjeta")
    private List<Recarga> recargaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tarjeta")
    private TarjetaGenerica tarjetaGenerica;

    public Tarjeta() {
    }

    public Tarjeta(String pinTarjeta) {
        this.pinTarjeta = pinTarjeta;
    }

    public String getPinTarjeta() {
        return pinTarjeta;
    }

    public void setPinTarjeta(String pinTarjeta) {
        this.pinTarjeta = pinTarjeta;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TarjetaPersonalizada getTarjetaPersonalizada() {
        return tarjetaPersonalizada;
    }

    public void setTarjetaPersonalizada(TarjetaPersonalizada tarjetaPersonalizada) {
        this.tarjetaPersonalizada = tarjetaPersonalizada;
    }

    public List<TarjetaEstacion> getTarjetaEstacionList() {
        return tarjetaEstacionList;
    }

    public void setTarjetaEstacionList(List<TarjetaEstacion> tarjetaEstacionList) {
        this.tarjetaEstacionList = tarjetaEstacionList;
    }

    public List<Recarga> getRecargaList() {
        return recargaList;
    }

    public void setRecargaList(List<Recarga> recargaList) {
        this.recargaList = recargaList;
    }

    public TarjetaGenerica getTarjetaGenerica() {
        return tarjetaGenerica;
    }

    public void setTarjetaGenerica(TarjetaGenerica tarjetaGenerica) {
        this.tarjetaGenerica = tarjetaGenerica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pinTarjeta != null ? pinTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.pinTarjeta == null && other.pinTarjeta != null) || (this.pinTarjeta != null && !this.pinTarjeta.equals(other.pinTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pinTarjeta;
    }
    
}
