package com.legalsight.web.exception;

import lombok.Getter;

@Getter
public class LegalSightFieldError {
    private final String field;
    private final String message;
    private final String code;
    private String rejectedValue;

    public LegalSightFieldError(String field, String message, String code, Object rejectedValue) {
        this.field = field;
        this.message = message;
        this.code = code;
        if (rejectedValue != null) {
            this.rejectedValue = rejectedValue.toString();
        }
    }

    public LegalSightFieldError(String field, String message, String code) {
        this.field = field;
        this.message = message;
        this.code = code;
    }
}
