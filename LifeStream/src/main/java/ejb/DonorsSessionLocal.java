/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Donors;
import java.util.List;
import jakarta.ejb.Local;

@Local
public interface DonorsSessionLocal {
    void create(Donors donor);
    void edit(Donors donor);
    void remove(Donors donor);
    Donors find(Object id);
    List<Donors> findAll();
    List<Donors> findRange(int[] range);
    int count();
}