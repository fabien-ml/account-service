package com.fabienml.accountservice.accountManagement.repository;

import com.fabienml.accountservice.accountManagement.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Repository for the Account entity
 *
 * PagingAndSortingRepository : expose basics CRUD methods + Pagination and Sorting
 * AccountRepositoryCustom : Your custom interface used to create custom complex query from scratch : See AccountRepositoryCustomImpl
 */
@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long>, AccountRepositoryCustom {

    // Spring Data Jpa convert this method to an SQL Query
    Account findByUsername(String username);

    /*
      * If your query is too long or complex you can use @Query with JPQL
      * You can use the method name you want
      * With this method query syntax are checked at startup to ensure validity
      */
    @Query("SELECT a FROM Account a WHERE a.firstName = :firstName")
    List<Account> findByFirstName(@Param("firstName") String firstName);
}
