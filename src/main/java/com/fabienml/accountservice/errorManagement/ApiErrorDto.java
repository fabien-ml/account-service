package com.fabienml.accountservice.errorManagement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.io.Serializable;

/*
 * DTO of an API error
 */
@Data
@AllArgsConstructor
public class ApiErrorDto implements Serializable {

    private String error;

    @JsonProperty("error_description")
    private String errorDescription;
}
