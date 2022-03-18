package mx.edu.utez.Gabinete.Customer.Model;

import mx.edu.utez.Gabinete.Address.Model.Address;
import mx.edu.utez.Gabinete.Person.Model.Person;
import mx.edu.utez.Gabinete.Record.Model.Record;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "customer")
    private Record record;

    @Column(columnDefinition = "text")
    private String email;
    @Column(columnDefinition = "text")
    private String phone;

    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;
}
