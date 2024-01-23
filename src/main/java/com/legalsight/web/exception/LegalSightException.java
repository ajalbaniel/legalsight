package com.legalsight.web.exception;

import lombok.Getter;

import java.util.UUID;

public class LegalSightException extends RuntimeException {

    @Getter
    private final String uuid;
    @Getter
    private final transient Object object;

    public LegalSightException(String message) {
        super(message);
        this.uuid = UUID.randomUUID().toString();
        this.object = null;
    }
}
