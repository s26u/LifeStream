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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author SUJAL
 */
@Entity
@Table(name = "patients")
@NamedQueries({
    @NamedQuery(name = "Patients.findAll", query = "SELECT p FROM Patients p"),
    @NamedQuery(name = "Patients.findByPatientID", query = "SELECT p FROM Patients p WHERE p.patientID = :patientID"),
    @NamedQuery(name = "Patients.findByFirstName", query = "SELECT p FROM Patients p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Patients.findByLastName", query = "SELECT p FROM Patients p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Patients.findByBloodTypeRequired", query = "SELECT p FROM Patients p WHERE p.bloodTypeRequired = :bloodTypeRequired"),
    @NamedQuery(name = "Patients.findByRequiredUnits", query = "SELECT p FROM Patients p WHERE p.requiredUnits = :requiredUnits"),
    @NamedQuery(name = "Patients.findByContactNumber", query = "SELECT p FROM Patients p WHERE p.contactNumber = :contactNumber"),
    @NamedQuery(name = "Patients.findByEmail", query = "SELECT p FROM Patients p WHERE p.email = :email"),
    @NamedQuery(name = "Patients.findByRequestDate", query = "SELECT p FROM Patients p WHERE p.requestDate = :requestDate")})
public class Patients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PatientID")
    private Integer patientID;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "BloodTypeRequired")
    private String bloodTypeRequired;
    @Basic(optional = false)
    @Column(name = "RequiredUnits")
    private int requiredUnits;
    @Basic(optional = false)
    @Column(name = "ContactNumber")
    private String contactNumber;
    @Column(name = "Email")
    private String email;
    @Lob
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "RequestDate")
    @Temporal(TemporalType.DATE)
    private Date requestDate;

    public Patients() {
    }

    public Patients(Integer patientID) {
        this.patientID = patientID;
    }

    public Patients(Integer patientID, String firstName, String lastName, String bloodTypeRequired, int requiredUnits, String contactNumber, Date requestDate) {
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bloodTypeRequired = bloodTypeRequired;
        this.requiredUnits = requiredUnits;
        this.contactNumber = contactNumber;
        this.requestDate = requestDate;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBloodTypeRequired() {
        return bloodTypeRequired;
    }

    public void setBloodTypeRequired(String bloodTypeRequired) {
        this.bloodTypeRequired = bloodTypeRequired;
    }

    public int getRequiredUnits() {
        return requiredUnits;
    }

    public void setRequiredUnits(int requiredUnits) {
        this.requiredUnits = requiredUnits;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientID != null ? patientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patients)) {
            return false;
        }
        Patients other = (Patients) object;
        if ((this.patientID == null && other.patientID != null) || (this.patientID != null && !this.patientID.equals(other.patientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Patients[ patientID=" + patientID + " ]";
    }
    
}
