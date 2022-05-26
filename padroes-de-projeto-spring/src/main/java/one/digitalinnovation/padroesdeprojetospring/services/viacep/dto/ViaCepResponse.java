package one.digitalinnovation.padroesdeprojetospring.services.viacep.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import one.digitalinnovation.padroesdeprojetospring.models.Address;

import javax.validation.constraints.NotBlank;

@Data
public class ViaCepResponse {

    @NotBlank
    @JsonProperty("cep")
    private String zipCode;
    @NotBlank
    @JsonProperty("logradouro")
    private String publicArea;
    @NotBlank
    @JsonProperty("complemento")
    private String complement;
    @NotBlank
    @JsonProperty("bairro")
    private String district;
    @NotBlank
    @JsonProperty("localidade")
    private String locality;
    @NotBlank
    @JsonProperty("uf")
    private String state;

    public Address toAddress() {
        return new Address(zipCode, publicArea, complement, district, locality, state);
    }
}
