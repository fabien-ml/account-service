package com.fabienml.accountservice.accountManagement.dto;

import com.fabienml.accountservice.accountManagement.entity.Account;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
public class AccountDto implements Serializable {

    private long id;

    private String username;

    private String firstName;

    private String lastName;

    // Uncomment to use a custom JSON Format for java.time API, default is ISO 8601
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    public static AccountDto toDto(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .username(account.getUsername())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .birthDate(account.getBirthDate())
                .build();
    }

}
