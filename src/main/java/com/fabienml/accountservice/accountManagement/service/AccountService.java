package com.fabienml.accountservice.accountManagement.service;

import com.fabienml.accountservice.accountManagement.dto.AccountDto;
import com.fabienml.accountservice.accountManagement.dto.CreateAccountFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {

    Page<AccountDto> findAll(Pageable pageable);

    AccountDto findById(Long id);

    AccountDto createAccount(CreateAccountFormDto form);
}
