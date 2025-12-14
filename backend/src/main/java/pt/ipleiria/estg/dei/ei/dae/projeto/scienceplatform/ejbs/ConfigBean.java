package pt.ipleiria.estg.dei.ei.dae.scienceplatform.ejbs;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

import java.util.logging.Logger;

@Startup
@Singleton
public class ConfigBean {

    private static final Logger logger = Logger.getLogger("ejbs.ConfigBean");

    @EJB
    private ResearcherBean researcherBean;

    @EJB
    private AdministratorBean administratorBean;

    @EJB
    private PublicationBean publicationBean;

    @PostConstruct
    public void populateDB() {
        logger.info("Inicio do povoamento da BD..."); // Log para vermos no 'make logs'

        try {
            // Criar um Investigador (Colaborador)
            researcherBean.create("r1", "pass123", "João Investigador", "joao@my-science.pt", "Gabinete C1");

            // Criar um Administrador
            administratorBean.create("admin1", "adminpass", "Super Admin", "admin@my-science.pt");

            publicationBean.create(
                    "Introduction to Data Science",
                    "A comprehensive guide about data science...",
                    pt.ipleiria.estg.dei.ei.dae.scienceplatform.enums.PublicationType.ARTICLE,
                    "/path/to/file.pdf",
                    java.time.LocalDate.now(),
                    "r1"
            );

            logger.info("BD povoada com sucesso!");
        } catch (Exception e) {
            logger.severe("Erro no povoamento da BD: " + e.getMessage());
        }
    }
}