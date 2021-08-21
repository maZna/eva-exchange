package guru.eva.exchange.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import guru.eva.exchange.rest.model.Header;
import guru.eva.exchange.rest.model.ServiceResponse;

public class ResponseBuilder {
	
	public static <T> ResponseEntity<ServiceResponse<T>> success(T data, String message) {
		Header header = new Header();
		header.setResultCode(HttpStatus.OK.value());
		header.setResultMessage(message);
		
		ServiceResponse<T> response = new ServiceResponse<>();
		response.setData(data);
		response.setHeader(header);
		
		return ResponseEntity.ok(response);
	}

	public static <T> ResponseEntity<ServiceResponse<T>> failure(T data, String message, HttpStatus status) {
		Header header = new Header();
		header.setResultCode(status.value());
		header.setResultMessage(message);
		
		ServiceResponse<T> response = new ServiceResponse<>();
		response.setData(data);
		response.setHeader(header);
		
		return new ResponseEntity<>(response, status);
	}
	
}
