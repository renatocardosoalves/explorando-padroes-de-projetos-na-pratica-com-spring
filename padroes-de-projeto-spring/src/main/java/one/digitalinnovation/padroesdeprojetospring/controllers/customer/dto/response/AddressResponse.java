package one.digitalinnovation.padroesdeprojetospring.controllers.customer.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import one.digitalinnovation.padroesdeprojetospring.models.Address;

@Data
public class AddressResponse {

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

    public AddressResponse(Address address) {
        this.zipCode = address.getZipCode();
        this.publicArea = address.getPublicArea();
        this.complement = address.getComplement();
        this.district = address.getDistrict();
        this.locality = address.getLocality();
        this.state = address.getState();
    }
}
