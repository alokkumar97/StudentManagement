package com.imaginnovate.sm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionController {
	
	@ExceptionHandler(value=StudentNotFoundException.class)
	public ResponseEntity<Object> exception(StudentNotFoundException snfe){
		return new ResponseEntity<>("Student Not Found ", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= StudentAlreadyExistsException.class)
	public ResponseEntity<Object> exception2(StudentAlreadyExistsException saee){
		return new ResponseEntity<>("Student Already Exists ", HttpStatus.BAD_REQUEST);
	}

}
