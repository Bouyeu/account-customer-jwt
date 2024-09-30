package org.sylla.accountservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.sylla.accountservice.model.Customer;

import java.util.List;
@FeignClient(name = "CUSTUMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable  Long id);
    @GetMapping("/customers")
    List<Customer> allCustomers();
}
