package com.cg.exceptions;

public class DetailsNotFoundException extends RuntimeException {
    /**
    *
    */
    public static final long serialVersionUID = 1L;
 
    public static String message = "Id not found ";
 
    public DetailsNotFoundException() {
        super(message);
 
    }
 
    public String getMessage() {
 
        return message;
    }
 
    public DetailsNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub {
 
	
	}
 
}
