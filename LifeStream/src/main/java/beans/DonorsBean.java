/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.DonorsSessionLocal;
import entity.Donors;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.util.List;

@Named("donorsBean") // Name accessible in JSF
@RequestScoped
public class DonorsBean {

    @Inject
    private DonorsSessionLocal donorsSession; // Injecting the session bean

    private List<Donors> donorsList;
    private Donors donor = new Donors(); // For adding or editing a donor

    @PostConstruct
    public void init() {
        // Load all donors at initialization
        donorsList = donorsSession.findAll();
    }

    public List<Donors> getDonorsList() {
        return donorsList;
    }

    public Donors getDonor() {
        return donor;
    }

    public void setDonor(Donors donor) {
        this.donor = donor;
    }

    public String saveDonor() {
        if (donor.getDonorID() == null) {
            donorsSession.create(donor); // Add new donor
        } else {
            donorsSession.edit(donor); // Update existing donor
        }
        return "donors.xhtml?faces-redirect=true"; // Redirect to donors page
    }

    public String editDonor(Donors donor) {
        this.donor = donor;
        return "donor_form.xhtml"; // Navigate to form for editing
    }

    public void deleteDonor(Donors donor) {
        donorsSession.remove(donor);
        donorsList = donorsSession.findAll(); // Refresh the list
    }
}
