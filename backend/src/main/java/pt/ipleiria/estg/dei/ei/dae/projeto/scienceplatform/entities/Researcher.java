package pt.ipleiria.estg.dei.ei.dae.scienceplatform.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "getAllResearchers",
                query = "SELECT r FROM Researcher r ORDER BY r.name"
        )
})
public class Researcher extends User implements Serializable {

    private String office;


    public Researcher() {
    }

    public Researcher(String username, String password, String name, String email, String office) {
        super(username, password, name, email);
        this.office = office;
    }

    public String getOffice() { return office; }
    public void setOffice(String office) { this.office = office; }
}