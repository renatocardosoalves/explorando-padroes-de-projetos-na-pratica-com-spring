package one.digitalinnovation.padroesdeprojetospring.services.viacep;

import one.digitalinnovation.padroesdeprojetospring.services.viacep.dto.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

@Validated
@FeignClient(name = "viaCep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @Valid
    @GetMapping("/{zipCode}/json/")
    ViaCepResponse findByZipCode(@PathVariable String zipCode);
}
