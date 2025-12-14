package pt.ipleiria.estg.dei.ei.dae.scienceplatform.ejbs;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pt.ipleiria.estg.dei.ei.dae.scienceplatform.entities.Administrator;

@Stateless
public class AdministratorBean {

    @PersistenceContext
    private EntityManager em;

    public void create(String username, String password, String name, String email) {
        Administrator admin = em.find(Administrator.class, username);
        if (admin != null) {
            return;
        }
        admin = new Administrator(username, password, name, email);
        em.persist(admin);
    }

    public Administrator find(String username) {
        return em.find(Administrator.class, username);
    }
}