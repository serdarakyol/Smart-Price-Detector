package com.qindel.test.response;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ResponseEnum {

    SUCCESS(200, "Success", HttpStatus.OK),
    NOT_FOUND(404, "Not found", HttpStatus.NOT_FOUND),
    SERVER_ERROR(500, "Server Error", HttpStatus.METHOD_NOT_ALLOWED);

    private final Integer statusCode;
    private final String statusMessage;
    private final HttpStatus status;

    ResponseEnum(Integer statusCode, String statusMessage, HttpStatus status) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.status = status;
    }

}
