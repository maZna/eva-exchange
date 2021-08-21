package guru.eva.exchange.exception.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -6230516465350575661L;

	public BadRequestException(String message) {
		super(message);
	}
	
}
