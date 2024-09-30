package org.sylla.custumerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.sylla.custumerservice.entities.Customer;


public interface CustomerRepositories extends JpaRepository<Customer,Long> {
}
