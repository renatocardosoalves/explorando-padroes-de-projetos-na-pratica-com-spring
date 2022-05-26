package one.digitalinnovation.padroesdeprojetospring.controllers.customer;

import lombok.RequiredArgsConstructor;
import one.digitalinnovation.padroesdeprojetospring.controllers.customer.dto.request.CustomerPostRequest;
import one.digitalinnovation.padroesdeprojetospring.controllers.customer.dto.request.CustomerPutRequest;
import one.digitalinnovation.padroesdeprojetospring.controllers.customer.dto.response.CustomerResponse;
import one.digitalinnovation.padroesdeprojetospring.services.customer.CustomerService;
import one.digitalinnovation.padroesdeprojetospring.services.customer.exceptions.CustomerNotFoundException;
import one.digitalinnovation.padroesdeprojetospring.services.viacep.exceptions.ZipCodeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    private final CustomerService service;

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        var response = service.findAll()
                .stream()
                .map(CustomerResponse::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable Long id) {
        try {
            var response = new CustomerResponse(service.findById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomerNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> save(@RequestBody CustomerPostRequest request) {
        try {
            var response = new CustomerResponse(service.save(request.toModel()));
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (ZipCodeNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable Long id, @RequestBody CustomerPutRequest request) {
        try {
            var response = new CustomerResponse(service.update(id, request.toModel()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomerNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CustomerNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
