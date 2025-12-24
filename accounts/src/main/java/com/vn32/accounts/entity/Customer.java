package com.vn32.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name="customer")//optional if class name matching with db name
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Customer extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // means give responsiility to spring boot to generte the id uniquly
    private Long customerId;
    @Column(name="name")//optional if name matching with db column
    private String name;
    private String email;
    private String mobileNumber;
}
