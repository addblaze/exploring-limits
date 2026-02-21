package io.blaze.h2jpa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.blaze.h2jpa.exceptions.EntityNotFound;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(exception = EntityNotFound.class)
	public ResponseEntity<EntityNotFound> entityNotFound(EntityNotFound ex,
            HttpServletRequest request) {
		StackTraceElement[] ste = new StackTraceElement[3];
		for(int i = 0; i < 3 && i < ex.getStackTrace().length - 1; i++) {
			ste[i] = ex.getStackTrace()[i];
		}
		ex.setStackTrace(ste);
		return ResponseEntity.badRequest().body(ex);
	}

}
