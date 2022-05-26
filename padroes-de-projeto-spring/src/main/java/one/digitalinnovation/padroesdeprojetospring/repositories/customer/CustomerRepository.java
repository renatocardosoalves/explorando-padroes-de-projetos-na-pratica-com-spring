package one.digitalinnovation.padroesdeprojetospring.repositories.customer;

import one.digitalinnovation.padroesdeprojetospring.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
