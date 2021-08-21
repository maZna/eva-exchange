package guru.eva.exchange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import guru.eva.exchange.entity.ShareTransaction;

@Repository
public interface ShareTransactionRepository extends JpaRepository<ShareTransaction, Integer> {

	@Query(nativeQuery = true, value = "SELECT number_of_shares, transaction_type FROM share_transaction WHERE transaction_user = :portfolioId AND transaction_share = :shareCode")
	public List<Object[]> findPastQueries(@Param("portfolioId") Integer portfolioId,
			@Param("shareCode") String shareCode);

}
