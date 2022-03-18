package mx.edu.utez.Gabinete.Address.Model;

import mx.edu.utez.Gabinete.Person.Model.Person;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "text")
    private String street;
    @Column(columnDefinition = "text")
    private String colony;
    @Column(columnDefinition = "text", name = "postal_code")
    private String postalCode;
    @Column(columnDefinition = "text")
    private String city;
    @Column(columnDefinition = "text")
    private String state;

    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;
}
