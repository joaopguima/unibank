package com.example.unibank.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id) {
        super("ID solicitado não localizado.");
    }
}
