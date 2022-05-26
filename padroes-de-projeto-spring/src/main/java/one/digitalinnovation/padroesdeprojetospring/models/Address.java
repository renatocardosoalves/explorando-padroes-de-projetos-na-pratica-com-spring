package one.digitalinnovation.padroesdeprojetospring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    private String zipCode;
    private String publicArea;
    private String complement;
    private String district;
    private String locality;
    private String state;
}
