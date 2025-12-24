package com.vn32.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name="customer")//optional if class name matching with db name
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Accounts extends BaseEntity{

    @Id //developer will create the unique account number each times
    private String accountNumber;
    private Long customerId;
    private String accountType;
    private String branchAddress;
}
