/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Donors;
import jakarta.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DonorsSessionBean implements DonorsSessionLocal {

    @PersistenceContext(unitName = "ls_unit")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(Donors donor) {
        em.persist(donor);
    }

    @Override
    public void edit(Donors donor) {
        em.merge(donor);
    }

    @Override
    public void remove(Donors donor) {
        em.remove(em.merge(donor));
    }

    @Override
    public Donors find(Object id) {
        return em.find(Donors.class, id);
    }

    @Override
    public List<Donors> findAll() {
        return em.createQuery("SELECT d FROM Donors d", Donors.class).getResultList();
    }

    @Override
    public List<Donors> findRange(int[] range) {
        javax.persistence.Query q = em.createQuery("SELECT d FROM Donors d", Donors.class);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    @Override
    public int count() {
        javax.persistence.Query q = em.createQuery("SELECT COUNT(d) FROM Donors d");
        return ((Long) q.getSingleResult()).intValue();
    }
}