package com.inventario.inventariomicroservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MessageConflictException extends ResponseStatusException {
    public MessageConflictException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
