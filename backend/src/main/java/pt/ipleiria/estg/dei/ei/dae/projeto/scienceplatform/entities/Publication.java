package pt.ipleiria.estg.dei.ei.dae.scienceplatform.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import pt.ipleiria.estg.dei.ei.dae.scienceplatform.enums.PublicationType;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "publications")
@NamedQueries({
        @NamedQuery(
                name = "getAllPublications",
                query = "SELECT p FROM Publication p ORDER BY p.publicationDate DESC"
        )
})
public class Publication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull
    private PublicationType type;

    private String filepath;

    @Temporal(TemporalType.DATE)
    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(name = "researcher_username")
    @NotNull
    private Researcher researcher;

    @Version
    private int version;

    public Publication() {
    }

    public Publication(String title, String description, PublicationType type, String filepath, LocalDate publicationDate, Researcher researcher) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.filepath = filepath;
        this.publicationDate = publicationDate;
        this.researcher = researcher;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PublicationType getType() {
        return type;
    }

    public void setType(PublicationType type) {
        this.type = type;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Researcher getResearcher() {
        return researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }
}