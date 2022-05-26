package one.digitalinnovation.padroesdeprojetospring.controllers.customer.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import one.digitalinnovation.padroesdeprojetospring.models.Customer;

@Data
public class CustomerPutRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private AddressPutRequest address;

    public Customer toModel() {
        var address = this.address.toModel();
        var customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        return customer;
    }
}
