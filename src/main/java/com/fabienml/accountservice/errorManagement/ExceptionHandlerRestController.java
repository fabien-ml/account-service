package com.fabienml.accountservice.errorManagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

/*
 * Managing all exception in the application
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandlerRestController {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrorDto> handleResponseStatusException(ResponseStatusException ex) {
        return new ResponseEntity<>(new ApiErrorDto(ex.getStatus().name(), ex.getReason()), ex.getStatus());
    }

    // javax.validation API handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorDto handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String errorDescription = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return new ApiErrorDto(HttpStatus.BAD_REQUEST.name(), errorDescription);
    }

    // Default exception handler
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorDto return500(Exception ex) {
        log.error(ex.getLocalizedMessage(), ex);
        return new ApiErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.name(), "Sorry, something went wrong !");
    }

}
