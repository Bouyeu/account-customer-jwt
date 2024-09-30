package org.sylla.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sylla.accountservice.enums.AccountType;
import org.sylla.accountservice.model.Customer;

import java.time.LocalDate;
@Entity
@Getter
@Setter    @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private  String accountId;
    private double balance;
    private LocalDate createAt;
    private String devise;
    @Enumerated(EnumType.STRING )
    private AccountType type;
    private Long customerId;
    @Transient //pour ignorer cette attribut
    private Customer custumer;

}
