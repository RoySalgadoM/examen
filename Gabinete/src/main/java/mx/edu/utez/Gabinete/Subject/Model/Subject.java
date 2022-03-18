package mx.edu.utez.Gabinete.Subject.Model;

import mx.edu.utez.Gabinete.Lawyer.Model.Lawyer;
import mx.edu.utez.Gabinete.Person.Model.Person;
import mx.edu.utez.Gabinete.Record.Model.Record;
import mx.edu.utez.Gabinete.Status.Model.Status;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "date", name = "start_date")
    private String startDate;
    @Column(columnDefinition = "date", name = "end_date")
    private String endDate;
    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id", unique = true)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "record_id", unique = true)
    private Record record;

    @ManyToMany
    @JoinTable(
            name = "subject_lawyer",
            joinColumns = @JoinColumn(name="lawyer_id"),
            inverseJoinColumns = @JoinColumn(name="subject_id")
    )
    private List<Lawyer> lawyers;
}
