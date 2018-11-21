package com.fabienml.accountservice.accountManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

// lombok
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

// JPA / Hibernate
@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // with IDENTITY the rdbms handle id creation
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;
}
