package org.sylla.accountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.sylla.accountservice.entities.BankAccount;
import org.sylla.accountservice.enums.AccountType;
import org.sylla.accountservice.repository.BankAccountRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
		return args -> {

			BankAccount bankAccount1 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.devise("CFA")
					.balance(1000000)
					.createAt(LocalDate.now())
					.type(AccountType.CURRENT_ACCOUNT)
					.customerId(Long.valueOf(1))
					.build();
			BankAccount bankAccount2= BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.devise("CFA")
					.balance(9000000)
					.createAt(LocalDate.now())
					.type(AccountType.CURRENT_ACCOUNT)
					.customerId(Long.valueOf(2))
					.build();
			bankAccountRepository.save(bankAccount1);
			bankAccountRepository.save(bankAccount2);
		};
	}
}
