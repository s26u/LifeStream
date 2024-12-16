/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import jakarta.ejb.Stateless;
import entity.Bloodstock;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BloodStockSessionBean implements BloodStockSessionLocal {

    @PersistenceContext(unitName = "ls_unit")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(Bloodstock bloodStock) {
        em.persist(bloodStock);
    }

    @Override
    public void edit(Bloodstock bloodStock) {
        em.merge(bloodStock);
    }

    @Override
    public void remove(Bloodstock bloodStock) {
        em.remove(em.merge(bloodStock));
    }

    @Override
    public Bloodstock find(Object id) {
        return em.find(Bloodstock.class, id);
    }

    @Override
    public List<Bloodstock> findAll() {
        return em.createQuery("SELECT b FROM BloodStock b", Bloodstock.class).getResultList();
    }

    @Override
    public List<Bloodstock> findRange(int[] range) {
        javax.persistence.Query q = em.createQuery("SELECT b FROM BloodStock b", Bloodstock.class);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    @Override
    public int count() {
        javax.persistence.Query q = em.createQuery("SELECT COUNT(b) FROM BloodStock b");
        return ((Long) q.getSingleResult()).intValue();
    }
}
