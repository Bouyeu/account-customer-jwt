package org.sylla.custumerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.sylla.custumerservice.entities.Customer;
import org.sylla.custumerservice.repositories.CustomerRepositories;

import java.util.List;

@SpringBootApplication
public class CustumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustumerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepositories customerRepositories){
        return args -> {
            Customer customer1 = Customer.builder()
                    .firstName("Bouyeu")
                    .lastName("sylla")
                    .email("sylla@gmail.com")
                    .build();
            customerRepositories.save(customer1);
            Customer customer2 = Customer.builder()
                    .firstName("Mouhamed")
                    .lastName("sylla")
                    .email("Mouha@gmail.com")
                    .build();
            customerRepositories.save(customer2);

//            List<Customer> customerList = List.of(
//                    Customer.builder()
//                            .firstName("Bouyeu")
//                            .lastName("sylla")
//                            .email("sylla@gmail.com")
//                            .build(),
//                    Customer customer2 = Customer.builder()
//                            .firstName("Mouhamed")
//                            .lastName("sylla")
//                            .email("Mouha@gmail.com")
//                            .build()
//            );
//            customerRepositories.saveAll(customerList);
        };
    }

}
