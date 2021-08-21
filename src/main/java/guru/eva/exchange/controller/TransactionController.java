package guru.eva.exchange.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.eva.exchange.model.TradeRequest;
import guru.eva.exchange.model.TradeResponse;
import guru.eva.exchange.rest.ResponseBuilder;
import guru.eva.exchange.rest.model.ServiceResponse;
import guru.eva.exchange.service.TransactionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/trade")
@RequiredArgsConstructor
public class TransactionController {

	private final TransactionService transactionService;
	
	@PostMapping(value = "/buy")
	public ResponseEntity<ServiceResponse<TradeResponse>> performBuyTransaction(@RequestBody TradeRequest request) {
		return ResponseBuilder.success(transactionService.handleBuyTransaction(request), "SUCCESS");
	}

	@PostMapping(value = "/sell")
	public ResponseEntity<ServiceResponse<TradeResponse>> performSellTransaction(@RequestBody TradeRequest request) {
		return ResponseBuilder.success(transactionService.handleSellTransaction(request), "SUCCESS");
	}
}
