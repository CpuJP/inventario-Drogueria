package com.inventario.inventariomicroservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MessageBadRequestException extends ResponseStatusException {
    public MessageBadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
