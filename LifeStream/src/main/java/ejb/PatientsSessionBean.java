/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Patients;
import jakarta.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PatientsSessionBean implements PatientsSessionLocal {

    @PersistenceContext(unitName = "ls_unit")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(Patients patient) {
        em.persist(patient);
    }

    @Override
    public void edit(Patients patient) {
        em.merge(patient);
    }

    @Override
    public void remove(Patients patient) {
        em.remove(em.merge(patient));
    }

    @Override
    public Patients find(Object id) {
        return em.find(Patients.class, id);
    }

    @Override
    public List<Patients> findAll() {
        return em.createQuery("SELECT p FROM Patients p", Patients.class).getResultList();
    }

    @Override
    public List<Patients> findRange(int[] range) {
        javax.persistence.Query q = em.createQuery("SELECT p FROM Patients p", Patients.class);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    @Override
    public int count() {
        javax.persistence.Query q = em.createQuery("SELECT COUNT(p) FROM Patients p");
        return ((Long) q.getSingleResult()).intValue();
    }
}
