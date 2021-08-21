package guru.eva.exchange.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeRequest implements Serializable {

	private static final long serialVersionUID = -3730331848891509679L;
	private Integer portfolioId;
	private Integer shareId;
	private Integer quantity;

}
