package one.digitalinnovation.padroesdeprojetospring.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address = new Address();

    public String zipCode() {
        return this.address.getZipCode();
    }
}
