package guru.eva.exchange.rest.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse<T> implements Serializable {

	private static final long serialVersionUID = -8500123440060971329L;
	private T data;
	private Header header;

}
