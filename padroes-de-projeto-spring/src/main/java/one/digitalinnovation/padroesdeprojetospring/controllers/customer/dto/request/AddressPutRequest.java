package one.digitalinnovation.padroesdeprojetospring.controllers.customer.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import one.digitalinnovation.padroesdeprojetospring.models.Address;

@Data
public class AddressPutRequest {

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("publicArea")
    private String publicArea;

    @JsonProperty("complement")
    private String complement;

    @JsonProperty("district")
    private String district;

    @JsonProperty("locality")
    private String locality;

    @JsonProperty("state")
    private String state;

    public Address toModel() {
        var address = new Address();
        address.setZipCode(zipCode);
        address.setPublicArea(publicArea);
        address.setComplement(complement);
        address.setDistrict(district);
        address.setLocality(locality);
        address.setState(state);
        return address;
    }
}
