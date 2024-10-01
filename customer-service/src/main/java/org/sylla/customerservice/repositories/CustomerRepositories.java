package org.sylla.customerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.sylla.customerservice.entities.Customer;


public interface CustomerRepositories extends JpaRepository<Customer,Long> {
}
