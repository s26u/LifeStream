/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Patients;
import java.util.List;
import jakarta.ejb.Local;

@Local
public interface PatientsSessionLocal {
    void create(Patients patient);
    void edit(Patients patient);
    void remove(Patients patient);
    Patients find(Object id);
    List<Patients> findAll();
    List<Patients> findRange(int[] range);
    int count();
}
