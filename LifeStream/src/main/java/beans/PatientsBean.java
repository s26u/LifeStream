/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;
import ejb.PatientsSessionLocal;
import entity.Patients;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.util.List;

@Named("patientsBean") // Name accessible in JSF
@RequestScoped
public class PatientsBean {

    @Inject
    private PatientsSessionLocal patientsSession; // Injecting the session bean

    private List<Patients> patientsList;
    private Patients patient = new Patients(); // For adding or editing a patient

    @PostConstruct
    public void init() {
        // Load all patients at initialization
        patientsList = patientsSession.findAll();
    }

    public List<Patients> getPatientsList() {
        return patientsList;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public String savePatient() {
        if (patient.getPatientID() == null) {
            patientsSession.create(patient); // Add new patient
        } else {
            patientsSession.edit(patient); // Update existing patient
        }
        return "patients.xhtml?faces-redirect=true"; // Redirect to patients page
    }

    public String editPatient(Patients patient) {
        this.patient = patient;
        return "patient_form.xhtml"; // Navigate to form for editing
    }

    public void deletePatient(Patients patient) {
        patientsSession.remove(patient);
        patientsList = patientsSession.findAll(); // Refresh the list
    }
}
