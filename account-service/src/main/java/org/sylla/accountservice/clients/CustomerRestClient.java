package org.sylla.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.sylla.accountservice.model.Customer;

import java.util.List;
@FeignClient(name = "CUSTUMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "custumerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable  Long id);
    @CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomers")
    @GetMapping("/customers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("NOT VAILABLE");
        customer.setLastName("NOT VAILABLE");
        customer.setEmail("Not Vailable");
        return customer;
    }

    default List<Customer> getAllCustomers(Exception exception){
        return List.of();
    }
}
