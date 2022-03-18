package mx.edu.utez.Gabinete.Person.Model;

import mx.edu.utez.Gabinete.Address.Model.Address;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "person")
    private Address address;

    @Column(columnDefinition = "text")
    private String name;
    @Column(columnDefinition = "text")
    private String surname;
    @Column(columnDefinition = "text")
    private String lastname;
    @Column(columnDefinition = "text")
    private String curp;
}
