package pt.ipleiria.estg.dei.ei.dae.scienceplatform.ejbs;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pt.ipleiria.estg.dei.ei.dae.scienceplatform.entities.Publication;
import pt.ipleiria.estg.dei.ei.dae.scienceplatform.entities.Researcher;
import pt.ipleiria.estg.dei.ei.dae.scienceplatform.enums.PublicationType;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class PublicationBean {

    @PersistenceContext
    private EntityManager em;

    @EJB
    private ResearcherBean researcherBean;

    public void create(String title, String description, PublicationType type, String filepath, LocalDate publicationDate, String researcherUsername) {
        // Buscar o investigador pelo username
        Researcher researcher = researcherBean.find(researcherUsername);

        if (researcher != null) {
            Publication publication = new Publication(title, description, type, filepath, publicationDate, researcher);
            em.persist(publication);
        }
    }

    public List<Publication> findAll() {
        return em.createNamedQuery("getAllPublications", Publication.class).getResultList();
    }
}