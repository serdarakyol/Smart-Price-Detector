package com.qindel.test.exception;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qindel.test.response.ResponsePrice;

@ControllerAdvice
public class PriceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { PriceException.class })
    public ResponseEntity<ResponsePrice<Void>> handleCustomException(PriceException pe) {
        ResponsePrice<Void> response = ResponsePrice.<Void>builder()
                .statusCode(pe.getException().getStatusCode())
                .statusMessage(pe.getException().getStatusMessage())
                .timestamp(Instant.now().toString()).build();

        return new ResponseEntity<>(response, pe.getException().getStatus());
    }

}
