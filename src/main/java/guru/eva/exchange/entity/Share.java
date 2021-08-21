package guru.eva.exchange.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "share")
public class Share implements Serializable {

	private static final long serialVersionUID = 4596505853975463384L;

	@Id
	@Column(name = "share_id")
	private Integer shareId;

	@Column(name = "share_code", length = 3, nullable = false, unique = true, updatable = false)
	private String shareCode;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "share")
	private List<SharePrice> priceList;

	@ManyToMany(mappedBy = "userShares", fetch = FetchType.LAZY)
	private Set<UserPortfolio> sharePortFolios = new HashSet<>();
	
	@Override
	public int hashCode() {
		return shareId;
	}
}
