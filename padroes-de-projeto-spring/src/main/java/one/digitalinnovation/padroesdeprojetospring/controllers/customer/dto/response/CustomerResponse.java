package one.digitalinnovation.padroesdeprojetospring.controllers.customer.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import one.digitalinnovation.padroesdeprojetospring.models.Customer;

@Data
public class CustomerResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private AddressResponse address;

    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.address = new AddressResponse(customer.getAddress());
    }
}
