package one.digitalinnovation.padroesdeprojetospring.services.customer;

import one.digitalinnovation.padroesdeprojetospring.models.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    Customer save(Customer customer);

    Customer update(Long id, Customer customer);

    void deleteById(Long id);
}
