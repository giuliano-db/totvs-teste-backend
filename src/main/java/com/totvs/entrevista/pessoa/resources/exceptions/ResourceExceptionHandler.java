package com.totvs.entrevista.pessoa.resources.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.totvs.entrevista.pessoa.service.exceptions.TelefoneUnicoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(TelefoneUnicoException.class)
	public ResponseEntity<StandardError> telefonicoUnico(TelefoneUnicoException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(System.currentTimeMillis(),  HttpStatus.BAD_REQUEST.value(), "Erro de validação.", e.getMessage(), request.getRequestURI()); 
				
		return ResponseEntity.status( HttpStatus.BAD_REQUEST.value()).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", "Campos inválidos.", request.getRequestURI()); 
		
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	} 
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandardError> telefonicoUnico(ConstraintViolationException e, HttpServletRequest request) {
		
		ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", "Campos inválidos.", request.getRequestURI()); 
		for (ConstraintViolation<?> x : e.getConstraintViolations()) {
			err.addError(x.getRootBeanClass().getSimpleName(), x.getMessage());
		}
		return ResponseEntity.status( HttpStatus.BAD_REQUEST.value()).body(err);
	}	
	
}