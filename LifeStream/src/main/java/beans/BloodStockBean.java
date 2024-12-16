/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;
import entity.Bloodstock;
import ejb.BloodStockSessionLocal;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.util.List;

@Named("bloodStockBean") // Name accessible in JSF
@RequestScoped
public class BloodStockBean {

    @Inject
    private BloodStockSessionLocal bloodStockSession; // Injecting the session bean

    private List<Bloodstock> bloodStockList;
    private Bloodstock bloodStock = new Bloodstock(); // For adding or editing a blood stock record

    @PostConstruct
    public void init() {
        // Load all blood stock at initialization
        bloodStockList = bloodStockSession.findAll();
    }

    public List<Bloodstock> getBloodStockList() {
        return bloodStockList;
    }

    public Bloodstock getBloodStock() {
        return bloodStock;
    }

    public void setBloodStock(Bloodstock bloodStock) {
        this.bloodStock = bloodStock;
    }

    public String saveBloodStock() {
        if (bloodStock.getBloodID() == null) {
            bloodStockSession.create(bloodStock); // Add new stock
        } else {
            bloodStockSession.edit(bloodStock); // Update existing stock
        }
        return "blood_stock.xhtml?faces-redirect=true"; // Redirect to blood stock page
    }

    public String editBloodStock(Bloodstock bloodStock) {
        this.bloodStock = bloodStock;
        return "blood_stock_form.xhtml"; // Navigate to form for editing
    }

    public void deleteBloodStock(Bloodstock bloodStock) {
        bloodStockSession.remove(bloodStock);
        bloodStockList = bloodStockSession.findAll(); // Refresh the list
    }
}
