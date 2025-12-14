package pt.ipleiria.estg.dei.ei.dae.scienceplatform.ejbs;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pt.ipleiria.estg.dei.ei.dae.scienceplatform.entities.Researcher;
import java.util.List;

@Stateless
public class ResearcherBean {

    @PersistenceContext
    private EntityManager em;

    public void create(String username, String password, String name, String email, String office) {
        Researcher researcher = em.find(Researcher.class, username);
        if (researcher != null) {
            return; // Já existe, não faz nada (mais tarde lançaremos Exceção aqui)
        }
        researcher = new Researcher(username, password, name, email, office);
        em.persist(researcher);
    }

    public Researcher find(String username) {
        return em.find(Researcher.class, username);
    }

    // Vamos precisar disto para a API mais tarde
    public List<Researcher> findAll() {
        return em.createNamedQuery("getAllResearchers", Researcher.class).getResultList();
    }
}