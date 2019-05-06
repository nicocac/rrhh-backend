package com.trimix.rrhh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonaNotFoundException extends RuntimeException {

    public PersonaNotFoundException(String message) {
        super(message);
    }
}
