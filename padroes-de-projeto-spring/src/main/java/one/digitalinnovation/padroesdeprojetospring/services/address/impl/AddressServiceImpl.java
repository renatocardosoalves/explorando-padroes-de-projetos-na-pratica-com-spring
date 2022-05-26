package one.digitalinnovation.padroesdeprojetospring.services.address.impl;

import lombok.RequiredArgsConstructor;
import one.digitalinnovation.padroesdeprojetospring.services.viacep.exceptions.ZipCodeNotFoundException;
import one.digitalinnovation.padroesdeprojetospring.models.Address;
import one.digitalinnovation.padroesdeprojetospring.repositories.address.AddressRepository;
import one.digitalinnovation.padroesdeprojetospring.services.address.AddressService;
import one.digitalinnovation.padroesdeprojetospring.services.viacep.ViaCepService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final ViaCepService viacep;

    @Override
    public Address findByZipCode(String zipCode) throws ZipCodeNotFoundException {
        return repository.findById(zipCode)
                .orElseGet(() -> {
                    try {
                        return viacep.findByZipCode(zipCode)
                                .toAddress();
                    } catch (ConstraintViolationException ex) {
                        throw new ZipCodeNotFoundException(String.format("ZipCode %s is invalid", zipCode));
                    }
                });
    }
}
