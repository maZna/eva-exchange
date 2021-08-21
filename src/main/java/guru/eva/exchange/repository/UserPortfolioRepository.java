package guru.eva.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.eva.exchange.entity.UserPortfolio;

public interface UserPortfolioRepository extends JpaRepository<UserPortfolio, Integer> {

}
