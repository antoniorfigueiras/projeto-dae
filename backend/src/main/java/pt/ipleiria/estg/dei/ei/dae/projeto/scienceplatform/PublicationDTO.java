package pt.ipleiria.estg.dei.ei.dae.scienceplatform.dtos;

import pt.ipleiria.estg.dei.ei.dae.scienceplatform.entities.Publication;
import pt.ipleiria.estg.dei.ei.dae.scienceplatform.enums.PublicationType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PublicationDTO implements Serializable {
    private Long id;
    private String title;
    private String description;
    private PublicationType type;
    private LocalDate publicationDate;
    private String researcherName; // Em vez do objeto Researcher inteiro, mandamos só o nome

    public PublicationDTO() {
    }

    public PublicationDTO(Long id, String title, String description, PublicationType type, LocalDate publicationDate, String researcherName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.publicationDate = publicationDate;
        this.researcherName = researcherName;
    }

    // Método para converter de Entidade -> DTO
    public static PublicationDTO from(Publication publication) {
        return new PublicationDTO(
                publication.getId(),
                publication.getTitle(),
                publication.getDescription(),
                publication.getType(),
                publication.getPublicationDate(),
                publication.getResearcher().getName()
        );
    }

    // Método para converter uma Lista de Entidades -> Lista de DTOs
    public static List<PublicationDTO> from(List<Publication> publications) {
        return publications.stream().map(PublicationDTO::from).collect(Collectors.toList());
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public PublicationType getType() { return type; }
    public void setType(PublicationType type) { this.type = type; }
    public LocalDate getPublicationDate() { return publicationDate; }
    public void setPublicationDate(LocalDate publicationDate) { this.publicationDate = publicationDate; }
    public String getResearcherName() { return researcherName; }
    public void setResearcherName(String researcherName) { this.researcherName = researcherName; }
}