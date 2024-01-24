package com.legalsight.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class LegalSightExceptionHandler {

    @ExceptionHandler(SpeechNotFoundException.class)
    public ResponseEntity<LegalSightError> handleSpeechNotFoundException(SpeechNotFoundException e) {
        LegalSightError response = new LegalSightError()
                .message(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<LegalSightError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<LegalSightFieldError> fieldErrors = new ArrayList<>();
        e.getBindingResult().getFieldErrors()
                .forEach(error -> fieldErrors.add(
                        new LegalSightFieldError(
                                error.getField(),
                                error.getDefaultMessage(),
                                error.getCode(),
                                error.getRejectedValue()
                        )
                ));

        return new ResponseEntity<>(
                new LegalSightError()
                        .message("Invalid request")
                        .fieldErrors(fieldErrors),
                HttpStatus.BAD_REQUEST
        );
    }

}
