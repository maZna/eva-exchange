package guru.eva.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.eva.exchange.entity.SharePrice;

public interface SharePriceRepository extends JpaRepository<SharePrice, Integer> {

}
