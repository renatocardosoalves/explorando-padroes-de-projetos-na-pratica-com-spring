package one.digitalinnovation.padroesdeprojetospring.services.address;

import one.digitalinnovation.padroesdeprojetospring.models.Address;

public interface AddressService {

    Address findByZipCode(String zipCode);
}
