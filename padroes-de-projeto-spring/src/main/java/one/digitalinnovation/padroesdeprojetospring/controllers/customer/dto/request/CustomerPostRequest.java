package one.digitalinnovation.padroesdeprojetospring.controllers.customer.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import one.digitalinnovation.padroesdeprojetospring.models.Address;
import one.digitalinnovation.padroesdeprojetospring.models.Customer;

@Data
public class CustomerPostRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("zipCode")
    private String zipCode;

    public Customer toModel() {
        var address = new Address();
        address.setZipCode(zipCode);
        var customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        return customer;
    }
}
