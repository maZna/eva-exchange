package guru.eva.exchange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import guru.eva.exchange.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "share_transaction")
public class ShareTransaction {
	
	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(generator = "transaction_seq")
	@SequenceGenerator(name = "transaction_seq", initialValue = 23490, allocationSize = 46043)
	private Integer transactionId;

	@Column(name = "transaction_type")
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_user", referencedColumnName = "portfolio_id")
	private UserPortfolio transactionUser;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_share", referencedColumnName = "share_code")
	private Share transactionShare;
	
	@Column(name = "number_of_shares")
	private Integer numberOfShares;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_share_price", referencedColumnName = "update_id")
	private SharePrice transactionSharePrice;
}
