package mx.edu.utez.Gabinete.Lawyer.Model;

import mx.edu.utez.Gabinete.Person.Model.Person;
import mx.edu.utez.Gabinete.Subject.Model.Subject;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lawyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "text")
    private String rfc;
    @Column(columnDefinition = "text")
    private String email;

    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;

    @ManyToMany(mappedBy = "lawyers")
    private List<Subject> subjects;
}
