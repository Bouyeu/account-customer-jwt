package org.sylla.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.sylla.customerservice.config.GlobalConfig;
import org.sylla.customerservice.entities.Customer;
import org.sylla.customerservice.repositories.CustomerRepositories;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
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
