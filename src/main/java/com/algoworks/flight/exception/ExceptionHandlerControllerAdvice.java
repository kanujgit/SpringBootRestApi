package com.algoworks.flight.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algoworks.flight.api.reponse.Response;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {
		Response<Object> response = new Response<>(exception.getMessage(), HttpStatus.OK.value());
		return new ResponseEntity<Object>(response, HttpStatus.OK);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Response<Object> response = new Response<>(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
				HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ResponseEntity<Object> handleException(final Exception exception,
			final HttpServletRequest request) {
		Response<Object> response = new Response<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = NumberFormatException.class)
	public ResponseEntity<Object> handleNumberFormatExceptionEntity(NumberFormatException ex) {
		Response<Object> response = new Response<>(ex.getMessage(),
				HttpStatus.UNPROCESSABLE_ENTITY.value());
		return new ResponseEntity<Object>(response, HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
