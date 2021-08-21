package guru.eva.exchange.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeResponse implements Serializable {

	private static final long serialVersionUID = 4178994607777276992L;
	private String result;
	
}
