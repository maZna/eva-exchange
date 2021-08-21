package guru.eva.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import guru.eva.exchange.entity.UserPortfolio;

@Repository
public interface UserPortfolioRepository extends JpaRepository<UserPortfolio, Integer> {

}
