package guru.eva.exchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import guru.eva.exchange.exception.model.BadRequestException;
import guru.eva.exchange.rest.ResponseBuilder;
import guru.eva.exchange.rest.model.ServiceResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ServiceResponse<Object>> handleBadRequestException(Exception ex, WebRequest request) {
		return ResponseBuilder.failure(null, ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ServiceResponse<Object>> handleGenericException(Exception ex, WebRequest request) {
		return ResponseBuilder.failure(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
