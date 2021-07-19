package com.fa.dogapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * If an id is requested that doesn’t exist, appropriately handle the error
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dog not found")
public class DogNotFoundException extends RuntimeException{

    public DogNotFoundException() {
    }

    public DogNotFoundException(String message) {
        super(message);
    }
}
