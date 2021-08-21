package guru.eva.exchange.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import guru.eva.exchange.enums.ShareCurrency;
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
	@GeneratedValue(generator = "share_seq")
	@SequenceGenerator(name = "share_seq", initialValue = 33418, allocationSize = 14053)
	private Integer updateId;

	@Column(name = "update_date")
	private Date updateDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "share_code", referencedColumnName = "share_code", nullable = false)
	private Share share;
	
	@Column(name = "share_currency")
	@Enumerated(EnumType.STRING)
	private ShareCurrency shareCurrency;

	@Column(name = "share_price", precision = 10, scale = 2)
	private BigDecimal sharePrice;

}
