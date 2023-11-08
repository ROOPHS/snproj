package com.cg.exceptions;

public class DetailsAlreadyFoundException extends RuntimeException {
	/**
	 *
	 */
 
   public static final long serialVersionUID = 1L;
 
   public static String message = "Id Already found";
 
   public DetailsAlreadyFoundException() {
       super(message);
 
   }
 
   public String getMessage() {
 
       return message;
   }
}