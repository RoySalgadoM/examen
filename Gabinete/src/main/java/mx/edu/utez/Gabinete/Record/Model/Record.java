package mx.edu.utez.Gabinete.Record.Model;

import mx.edu.utez.Gabinete.Address.Model.Address;
import mx.edu.utez.Gabinete.Customer.Model.Customer;
import mx.edu.utez.Gabinete.Subject.Model.Subject;

import javax.persistence.*;

@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @Column(columnDefinition = "text", name = "record_key")
    private String recordKey;

    @OneToOne
    @JoinColumn(name = "customer_id", unique = true)
    private Customer customer;
}
