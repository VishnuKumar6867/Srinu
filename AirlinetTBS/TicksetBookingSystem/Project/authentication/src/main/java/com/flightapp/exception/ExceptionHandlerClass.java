package com.flightapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
@ResponseBody
public class ExceptionHandlerClass {
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleException(AuthenticationException exception, WebRequest req){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<String> handleException(HttpStatusCodeException exception, WebRequest req){
        return new ResponseEntity<>(exception.getResponseBodyAsString(), HttpStatus.NOT_FOUND);
    }
}
