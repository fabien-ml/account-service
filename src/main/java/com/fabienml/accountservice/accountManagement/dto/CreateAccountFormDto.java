package com.fabienml.accountservice.accountManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAccountFormDto implements Serializable {

    /*
     * @Annotations are used to handle form validation
     * message property can be i18n
     */

    @NotNull
    @Size(min = 3, max = 15, message = "Username should be between 3 and 15 characters")
    private String username;

    @NotNull
    @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;

    @NotNull(message = "First name should not be null")
    private String firstName;

    @NotNull(message = "Last name should not be null")
    private String lastName;

    @NotNull(message = "Birth date should not be null")
    private LocalDate birthDate;

}
