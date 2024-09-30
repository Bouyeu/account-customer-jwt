package org.sylla.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sylla.accountservice.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
