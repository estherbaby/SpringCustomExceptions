package com.developertest.app.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.developertest.app.ui.response.model.ErrorMessage;

@ControllerAdvice
public class ApplicationException {
	
	/**
	 * General exception handling
	 * 
	 * @param exception
	 * @param webRequest
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleException(Exception exception, WebRequest webRequest){
		
		String errorDetail = exception.getLocalizedMessage();
		if(errorDetail==null) errorDetail = exception.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDetail);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * General null pointer exception handling
	 * 
	 * @param nullPointerException
	 * @param webRequest
	 * @return
	 */
	@ExceptionHandler(value=NullPointerException.class)
	public ResponseEntity<Object> handleNullPointerException(NullPointerException nullPointerException, WebRequest webRequest){
		
		String errorDetail = nullPointerException.getLocalizedMessage();
		if(errorDetail ==  null) errorDetail = nullPointerException.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDetail);
		return new ResponseEntity(errorMessage, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	/**
	 * Null Map exception handling
	 * 
	 * @param nullMapException
	 * @param webRequest
	 * @return
	 */
	public ResponseEntity<Object> handleNullMapException(NullMapException nullMapException, WebRequest webRequest){
		String errorDetail = nullMapException.getMessage();
		System.out.println("***** nullMapException.getMessage() : "+nullMapException.getMessage());
		System.out.println("***** nullMapException.getLocalizedMessage() : "+nullMapException.getLocalizedMessage());
		if(errorDetail == null) errorDetail = "Empty map found";
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDetail);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	

}
