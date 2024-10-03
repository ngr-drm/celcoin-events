package com.api.celcoinevents.domain.rest.pix.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EnterpriseException extends ResponseStatusException {
    public EnterpriseException(HttpStatus status){
        super(status);
    }

    public EnterpriseException(HttpStatus status, String cause){
        super(status, cause);
    }
}