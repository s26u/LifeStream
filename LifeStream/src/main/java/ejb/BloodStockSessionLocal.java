/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import java.util.List;
import jakarta.ejb.Local;
import entity.Bloodstock;

@Local
public interface BloodStockSessionLocal {
    void create(Bloodstock bloodStock);
    void edit(Bloodstock bloodStock);
    void remove(Bloodstock bloodStock);
    Bloodstock find(Object id);
    List<Bloodstock> findAll();
    List<Bloodstock> findRange(int[] range);
    int count();
}


