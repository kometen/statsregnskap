package no.difi.statsregnskap;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @Column(name = "firstname", unique = false)

    private String firstname;
    private String lastname;
    private Integer born;

    public Team() {
        this.firstname = "fname in initializer";
        this.lastname = "lname in initializer";
        this.born = -1;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getBorn() {
        return born;
    }
}
