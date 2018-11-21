package com.fabienml.accountservice.accountManagement.controller;

import com.fabienml.accountservice.accountManagement.dto.AccountDto;
import com.fabienml.accountservice.accountManagement.dto.CreateAccountFormDto;
import com.fabienml.accountservice.accountManagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/accounts")
public class AccountRestController {

    private final AccountService accountService;

    // Always @Autowired by constructor
    @Autowired
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDto createAccount(@RequestBody @Valid CreateAccountFormDto form) {
        return accountService.createAccount(form);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<AccountDto> getAll(Pageable pageable) {
        return accountService.findAll(pageable);
    }

    @GetMapping("/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDto getById(@PathVariable("accountId") Long accountId) {
        return accountService.findById(accountId);
    }
}
