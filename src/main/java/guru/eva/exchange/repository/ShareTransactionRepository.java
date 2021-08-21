package guru.eva.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.eva.exchange.entity.ShareTransaction;

public interface ShareTransactionRepository extends JpaRepository<ShareTransaction, Integer> {

}
