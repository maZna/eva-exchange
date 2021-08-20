package guru.eva.exchange.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_portfolio")
public class UserPortfolio {

	@Id
	@Column(name = "portfolio_id")
	private Integer portfolioId;

	@Column(name = "portfolio_user_occupation", length = 500)
	private String userOcupation;

	@Column(name = "portfolio_user_name", length = 500)
	private String userName;

	@Column(name = "portfolio_user_address", length = 2000)
	private String userAddress;

	@Column(name = "portfolio_user_dob")
	private Date userDateOfBirth;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_shares", 
				joinColumns = @JoinColumn(name = "portfolio_id", referencedColumnName = "portfolio_id"), 
				inverseJoinColumns = @JoinColumn(name = "share_id", referencedColumnName = "share_id"))
	private Set<Share> userShares = new HashSet<>();

}
