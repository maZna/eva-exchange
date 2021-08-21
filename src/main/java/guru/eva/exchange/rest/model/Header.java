package guru.eva.exchange.rest.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Header implements Serializable {

	private static final long serialVersionUID = 5896830677492512071L;
	private Integer resultCode;
	private String resultMessage;

}
