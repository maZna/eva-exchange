package guru.eva.exchange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import guru.eva.exchange.entity.Share;

@Repository
public interface ShareRepository extends JpaRepository<Share, Integer> {

	public Optional<Share> findByShareCode(String shareCode);
	
}
