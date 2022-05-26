package one.digitalinnovation.padroesdeprojetospring.services.customer.impl;

import lombok.RequiredArgsConstructor;
import one.digitalinnovation.padroesdeprojetospring.models.Customer;
import one.digitalinnovation.padroesdeprojetospring.repositories.customer.CustomerRepository;
import one.digitalinnovation.padroesdeprojetospring.services.address.AddressService;
import one.digitalinnovation.padroesdeprojetospring.services.customer.CustomerService;
import one.digitalinnovation.padroesdeprojetospring.services.customer.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final AddressService addressService;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer with id %d not found", id)));
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        var addressFound = addressService.findByZipCode(customer.zipCode());
        customer.setAddress(addressFound);
        return repository.save(customer);
    }

    @Transactional
    @Override
    public Customer update(Long id, Customer customer) throws CustomerNotFoundException {
        var customerRecord = findById(id);
        customerRecord.setName(customer.getName());
        customerRecord.setAddress(customer.getAddress());
        return customerRecord;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (IllegalArgumentException ex) {
            throw new CustomerNotFoundException(String.format("Customer with id %d not found", id));
        }
    }
}
