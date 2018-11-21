package com.fabienml.accountservice.accountManagement.service;

import com.fabienml.accountservice.accountManagement.dto.AccountDto;
import com.fabienml.accountservice.accountManagement.dto.CreateAccountFormDto;
import com.fabienml.accountservice.accountManagement.entity.Account;
import com.fabienml.accountservice.accountManagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Page<AccountDto> findAll(Pageable pageable) {
        Page<Account> page = accountRepository.findAll(pageable);
        List<AccountDto> dtos = page.getContent().stream().map(AccountDto::toDto).collect(Collectors.toList());
        return new PageImpl(dtos, pageable, page.getTotalElements());
    }

    @Override
    public AccountDto findById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No Account found for id %d", id)));
        return AccountDto.toDto(account);
    }

    @Override
    public AccountDto createAccount(CreateAccountFormDto form) {
        Account account = Account.builder()
                .username(form.getUsername())
                .password(form.getPassword())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .birthDate(form.getBirthDate())
                .build();
                
        account = accountRepository.save(account);
        return AccountDto.toDto(account);
    }
}
