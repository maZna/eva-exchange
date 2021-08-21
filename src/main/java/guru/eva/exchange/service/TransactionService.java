package guru.eva.exchange.service;

import guru.eva.exchange.model.TradeRequest;
import guru.eva.exchange.model.TradeResponse;

public interface TransactionService {

	public TradeResponse handleBuyTransaction(TradeRequest request);

	public TradeResponse handleSellTransaction(TradeRequest request);

}
