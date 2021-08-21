package guru.eva.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import guru.eva.exchange.entity.SharePrice;

@Repository
public interface SharePriceRepository extends JpaRepository<SharePrice, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM eva.share_price WHERE share_code = :shareCode ORDER BY update_date DESC Limit 1")
	public SharePrice getLatestPriceForShare(@Param(value = "shareCode") String shareCode);

}
