package com.fabienml.accountservice.accountManagement.repository;

import com.fabienml.accountservice.accountManagement.entity.Account;

import java.util.List;

/*
 * Custom interface for Account repository
 *
 * Used to create your own implementation of complex queries
 * Don't forget to extends your AccountRepository interface with this interface
 */
public interface AccountRepositoryCustom {

    List<Account> findByLastName(String lastName);
}
