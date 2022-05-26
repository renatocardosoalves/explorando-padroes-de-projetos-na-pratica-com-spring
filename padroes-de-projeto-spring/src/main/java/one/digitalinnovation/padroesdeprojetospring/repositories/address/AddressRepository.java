package one.digitalinnovation.padroesdeprojetospring.repositories.address;

import one.digitalinnovation.padroesdeprojetospring.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
