package com.db.batchScheduler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleIncomingRequestExceptions(ApiRequestException e){

        HttpStatus errorRequest = HttpStatus.BAD_REQUEST;

        RequestException requestException = new RequestException(e.getMessage(), e.getCause(), errorRequest);
        return new ResponseEntity<>(requestException, errorRequest);
    }
}
