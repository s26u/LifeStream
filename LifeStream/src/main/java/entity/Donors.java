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
@Table(name = "donors")
@NamedQueries({
    @NamedQuery(name = "Donors.findAll", query = "SELECT d FROM Donors d"),
    @NamedQuery(name = "Donors.findByDonorID", query = "SELECT d FROM Donors d WHERE d.donorID = :donorID"),
    @NamedQuery(name = "Donors.findByFirstName", query = "SELECT d FROM Donors d WHERE d.firstName = :firstName"),
    @NamedQuery(name = "Donors.findByLastName", query = "SELECT d FROM Donors d WHERE d.lastName = :lastName"),
    @NamedQuery(name = "Donors.findByDateOfBirth", query = "SELECT d FROM Donors d WHERE d.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Donors.findByGender", query = "SELECT d FROM Donors d WHERE d.gender = :gender"),
    @NamedQuery(name = "Donors.findByBloodType", query = "SELECT d FROM Donors d WHERE d.bloodType = :bloodType"),
    @NamedQuery(name = "Donors.findByContactNumber", query = "SELECT d FROM Donors d WHERE d.contactNumber = :contactNumber"),
    @NamedQuery(name = "Donors.findByEmail", query = "SELECT d FROM Donors d WHERE d.email = :email"),
    @NamedQuery(name = "Donors.findByLastDonationDate", query = "SELECT d FROM Donors d WHERE d.lastDonationDate = :lastDonationDate")})
public class Donors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DonorID")
    private Integer donorID;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "BloodType")
    private String bloodType;
    @Basic(optional = false)
    @Column(name = "ContactNumber")
    private String contactNumber;
    @Column(name = "Email")
    private String email;
    @Lob
    @Column(name = "Address")
    private String address;
    @Column(name = "LastDonationDate")
    @Temporal(TemporalType.DATE)
    private Date lastDonationDate;

    public Donors() {
    }

    public Donors(Integer donorID) {
        this.donorID = donorID;
    }

    public Donors(Integer donorID, String firstName, String lastName, Date dateOfBirth, String gender, String bloodType, String contactNumber) {
        this.donorID = donorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bloodType = bloodType;
        this.contactNumber = contactNumber;
    }

    public Integer getDonorID() {
        return donorID;
    }

    public void setDonorID(Integer donorID) {
        this.donorID = donorID;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
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

    public Date getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(Date lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donorID != null ? donorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donors)) {
            return false;
        }
        Donors other = (Donors) object;
        if ((this.donorID == null && other.donorID != null) || (this.donorID != null && !this.donorID.equals(other.donorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Donors[ donorID=" + donorID + " ]";
    }
    
}
