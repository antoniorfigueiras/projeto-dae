package pt.ipleiria.estg.dei.ei.dae.scienceplatform.ws;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pt.ipleiria.estg.dei.ei.dae.scienceplatform.dtos.PublicationDTO;
import pt.ipleiria.estg.dei.ei.dae.scienceplatform.ejbs.PublicationBean;
import pt.ipleiria.estg.dei.ei.dae.scienceplatform.entities.Publication;

import java.util.List;

@Path("publications") // URL: /api/publications
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class PublicationService {

    @EJB
    private PublicationBean publicationBean;

    @GET
    @Path("/")
    //
    public List<PublicationDTO> getAllPublications() {
        // Vai buscar as entidades ao Bean e converte para DTOs
        return PublicationDTO.from(publicationBean.findAll());

    }
}