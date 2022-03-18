package mx.edu.utez.Gabinete.Status.Model;

import mx.edu.utez.Gabinete.Subject.Model.Subject;

import javax.persistence.*;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "text")
    private String description;
}
