package com.fabienml.accountservice.accountManagement.repository;

import com.fabienml.accountservice.accountManagement.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public AccountRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Account> findByLastName(String lastName) {

        // You can do thing more complex here

        // Warning : with this method query syntax are not checked at startup here
        Query query = entityManager.createQuery("SELECT a FROM Account a WHERE a.lastName = :lastName");

        query.setParameter("lastName", lastName);

        return (List<Account>) query.getResultList();
    }
}
