package com.example.unibank.controller.exception;

import com.example.unibank.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> notFound(ResourceNotFoundException exception, HttpServletRequest requestError){
        String message = "ID solicitado não localizado.";
        HttpStatus statusError = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), statusError.value(), message, exception.getMessage(), requestError.getRequestURI());
        return ResponseEntity.status(statusError).body(standardError);
    }

}
