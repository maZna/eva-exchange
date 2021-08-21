package guru.eva.exchange.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import guru.eva.exchange.entity.Share;
import guru.eva.exchange.entity.SharePrice;
import guru.eva.exchange.entity.ShareTransaction;
import guru.eva.exchange.entity.UserPortfolio;
import guru.eva.exchange.enums.TransactionType;
import guru.eva.exchange.exception.model.BadRequestException;
import guru.eva.exchange.model.TradeRequest;
import guru.eva.exchange.model.TradeResponse;
import guru.eva.exchange.repository.SharePriceRepository;
import guru.eva.exchange.repository.ShareRepository;
import guru.eva.exchange.repository.ShareTransactionRepository;
import guru.eva.exchange.repository.UserPortfolioRepository;
import guru.eva.exchange.service.TransactionService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionServiceImpl implements TransactionService {

	private static final String TRANSACTION_SUCCESS = "Transaction completed successfully!";
	private static final String INSUFFICIENT_SHARE_BALANCE = "The number of shares to be sold are insufficient!";
	private static final String SHARE_NOT_FOUND_IN_PORTFOLIO = "The specified share is not present in the portfolio of the user!";
	private static final String PORTFOLIO_NOT_FOUND = "The specified portfolio has not been registered in the system!";
	private static final String SHARE_NOT_FOUND = "The specified share has not been registered in the system!";
	
	private final ShareRepository shareRepository;
	private final UserPortfolioRepository portfolioRepository;
	private final SharePriceRepository priceRepository;
	private final ShareTransactionRepository transactionRepository;

	@Override
	public TradeResponse handleBuyTransaction(TradeRequest request) {
		Optional<Share> foundShareOpt = shareRepository.findByShareCode(request.getShareCode());
		if (!foundShareOpt.isPresent())
			throw new BadRequestException(SHARE_NOT_FOUND);
		Optional<UserPortfolio> foundPortfolioOpt = portfolioRepository.findById(request.getPortfolioId());
		if (!foundPortfolioOpt.isPresent())
			throw new BadRequestException(PORTFOLIO_NOT_FOUND);

		Share foundShare = foundShareOpt.get();
		UserPortfolio foundPortfolio = foundPortfolioOpt.get();
		SharePrice latestPrice = priceRepository.getLatestPriceForShare(request.getShareCode());

		ShareTransaction newTransaction = new ShareTransaction();
		newTransaction.setNumberOfShares(request.getQuantity());
		newTransaction.setTransactionShare(foundShare);
		newTransaction.setTransactionUser(foundPortfolio);
		newTransaction.setTransactionSharePrice(latestPrice);
		newTransaction.setTransactionType(TransactionType.BUY);
		transactionRepository.save(newTransaction);

		Set<Share> currentUserShares = foundPortfolio.getUserShares();
		if (currentUserShares.stream().filter(e -> e.getShareCode().equals(request.getShareCode())).count() == 0) {
			currentUserShares.add(foundShare);
			foundPortfolio.setUserShares(currentUserShares);
			portfolioRepository.save(foundPortfolio);
		}
		return new TradeResponse(TRANSACTION_SUCCESS);
	}

	@Override
	public TradeResponse handleSellTransaction(TradeRequest request) {
		Optional<Share> foundShareOpt = shareRepository.findByShareCode(request.getShareCode());
		if (!foundShareOpt.isPresent())
			throw new BadRequestException(SHARE_NOT_FOUND);
		Optional<UserPortfolio> foundPortfolioOpt = portfolioRepository.findById(request.getPortfolioId());
		if (!foundPortfolioOpt.isPresent())
			throw new BadRequestException(PORTFOLIO_NOT_FOUND);

		Share foundShare = foundShareOpt.get();
		UserPortfolio foundPortfolio = foundPortfolioOpt.get();
		Set<Share> currentUserShares = foundPortfolio.getUserShares();
		if (!currentUserShares.stream().filter(e -> e.getShareCode().equals(request.getShareCode())).findAny()
				.isPresent()) {
			throw new BadRequestException(SHARE_NOT_FOUND_IN_PORTFOLIO);
		}
		List<Object[]> pastTransactions = transactionRepository.findPastQueries(request.getPortfolioId(),
				request.getShareCode());
		int shareBalance = pastTransactions.stream().mapToInt(
				e -> ((String) e[1]).equals(TransactionType.BUY.toString()) ? ((Integer) e[0]) : -1 * ((Integer) e[0]))
				.sum();
		if (shareBalance >= request.getQuantity()) {
			SharePrice latestPrice = priceRepository.getLatestPriceForShare(request.getShareCode());
			ShareTransaction newTransaction = new ShareTransaction();
			newTransaction.setNumberOfShares(request.getQuantity());
			newTransaction.setTransactionShare(foundShare);
			newTransaction.setTransactionUser(foundPortfolio);
			newTransaction.setTransactionSharePrice(latestPrice);
			newTransaction.setTransactionType(TransactionType.SELL);
			transactionRepository.save(newTransaction);
			if (shareBalance == request.getQuantity()) {
				currentUserShares.removeIf(e -> e.getShareCode().equals(request.getShareCode()));
				foundPortfolio.setUserShares(currentUserShares);
				portfolioRepository.save(foundPortfolio);
			}
		} else {
			throw new BadRequestException(INSUFFICIENT_SHARE_BALANCE);
		}
		return new TradeResponse(TRANSACTION_SUCCESS);
	}

}
