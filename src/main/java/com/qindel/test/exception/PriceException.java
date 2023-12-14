package com.qindel.test.exception;

import com.qindel.test.response.ResponseEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PriceException extends RuntimeException {

    private static final long serialVersionUID = -1497806503985978270L;

    private final ResponseEnum exception;

}
