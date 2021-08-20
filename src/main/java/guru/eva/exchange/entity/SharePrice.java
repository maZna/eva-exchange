package guru.eva.exchange.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "share_price")
public class SharePrice {

	@Id
	@Column(name = "update_id")
	@GeneratedValue(generator = "share_price_id_seq")
	@SequenceGenerator(name = "portfolio_id_seq", initialValue = 123822, allocationSize = 153204)
	private Integer updateId;

	private Date updateDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "share_id", referencedColumnName = "share_id", nullable = false)
	private Share share;

	@Column(name = "share_price", precision = 10, scale = 2)
	private BigDecimal sharePrice;

}