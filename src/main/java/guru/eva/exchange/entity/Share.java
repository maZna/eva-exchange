package guru.eva.exchange.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "share")
public class Share {

	@Id
	@Column(name = "share_id")
	@GeneratedValue(generator = "share_id_seq")
	@SequenceGenerator(name = "share_id_seq", initialValue = 324452, allocationSize = 373103)
	private Integer shareId;

	@Column(length = 3, nullable = false, unique = true, updatable = false)
	private String shareCode;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "share")
	private List<SharePrice> priceList;

	@ManyToMany(mappedBy = "userShares", fetch = FetchType.LAZY)
	private Set<UserPortfolio> sharePortFolios = new HashSet<>();
}
