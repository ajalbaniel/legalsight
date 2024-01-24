package com.legalsight.web.exception;

import lombok.Getter;

import java.util.UUID;

public class LegalSightException extends RuntimeException {

    @Getter
    private final String uuid;

    public LegalSightException(String message) {
        super(message);
        this.uuid = UUID.randomUUID().toString();
    }

    public LegalSightException(String message, Throwable cause) {
        super(message, cause);
        this.uuid = UUID.randomUUID().toString();
    }
}
