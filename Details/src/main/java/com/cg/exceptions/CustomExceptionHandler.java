package com.cg.exceptions;

import java.sql.Date;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class CustomExceptionHandler {
 
    @ExceptionHandler(DetailsAlreadyFoundException.class)
    public ResponseEntity<Object> handleIdAlreadyFound(DetailsAlreadyFoundException exception ,WebRequest request){
        CustomException customException = new CustomException(
                HttpStatus.SC_ALREADY_REPORTED.value(),exception.getMessage(),new Date()
                );
        return new ResponseEntity<>(customException,HttpStatus.SC_ALREADY_REPORTED);
 
    }
 
    @ExceptionHandler(DetailsNotFoundException.class)
    public ResponseEntity<Object> handleIdAlnotFound(DetailsNotFoundException exception ,WebRequest request){
        CustomException customException = new CustomException(
                HttpStatus.SC_ALREADY_REPORTED.value(),exception.getMessage(),new Date()
                );
        return new ResponseEntity<>(customException,HttpStatus.SC_ALREADY_REPORTED);
 
    }
 
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleParentException(Exception exception ,WebRequest request){
        CustomException customException = new CustomException(
                HttpStatus.SC_ALREADY_REPORTED.value(),exception.getMessage(),new Date()
                );
        return new ResponseEntity<>(customException,HttpStatus.SC_ALREADY_REPORTED);
 
    }
 
 
}
