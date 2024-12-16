/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author SUJAL
 */
@Entity
@Table(name = "bloodstock")
@NamedQueries({
    @NamedQuery(name = "Bloodstock.findAll", query = "SELECT b FROM Bloodstock b"),
    @NamedQuery(name = "Bloodstock.findByBloodID", query = "SELECT b FROM Bloodstock b WHERE b.bloodID = :bloodID"),
    @NamedQuery(name = "Bloodstock.findByBloodType", query = "SELECT b FROM Bloodstock b WHERE b.bloodType = :bloodType"),
    @NamedQuery(name = "Bloodstock.findByUnitsAvailable", query = "SELECT b FROM Bloodstock b WHERE b.unitsAvailable = :unitsAvailable"),
    @NamedQuery(name = "Bloodstock.findByLastUpdated", query = "SELECT b FROM Bloodstock b WHERE b.lastUpdated = :lastUpdated")})
public class Bloodstock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BloodID")
    private Integer bloodID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "BloodType")
    private String bloodType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UnitsAvailable")
    private int unitsAvailable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastUpdated")
    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    public Bloodstock() {
    }

    public Bloodstock(Integer bloodID) {
        this.bloodID = bloodID;
    }

    public Bloodstock(Integer bloodID, String bloodType, int unitsAvailable, Date lastUpdated) {
        this.bloodID = bloodID;
        this.bloodType = bloodType;
        this.unitsAvailable = unitsAvailable;
        this.lastUpdated = lastUpdated;
    }

    public Integer getBloodID() {
        return bloodID;
    }

    public void setBloodID(Integer bloodID) {
        this.bloodID = bloodID;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public int getUnitsAvailable() {
        return unitsAvailable;
    }

    public void setUnitsAvailable(int unitsAvailable) {
        this.unitsAvailable = unitsAvailable;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bloodID != null ? bloodID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bloodstock)) {
            return false;
        }
        Bloodstock other = (Bloodstock) object;
        if ((this.bloodID == null && other.bloodID != null) || (this.bloodID != null && !this.bloodID.equals(other.bloodID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bloodstock[ bloodID=" + bloodID + " ]";
    }
    
}
