package com.inmar.skudatamanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MetaDataGlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity handleDataNotFoundException(DataNotFoundException exception) {
        return ResponseEntity.badRequest()
                .body(ErrorResponse.builder().statusCode(HttpStatus.NOT_FOUND.toString())
                .message(exception.getMessage())
                .build());

    }
}
