package tn.esprit.rh.achat.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SecteurActivite implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSecteurActivite;
	private String codeSecteurActivite;
	private String libelleSecteurActivite;
	@ManyToMany(mappedBy="secteurActivites")
	@JsonIgnore
	private Set<Fournisseur> fournisseurs;
	public SecteurActivite(Long idSecteurActivite, String codeSecteurActivite, String libelleSecteurActivite) {
		super();
		this.idSecteurActivite = idSecteurActivite;
		this.codeSecteurActivite = codeSecteurActivite;
		this.libelleSecteurActivite = libelleSecteurActivite;
	}
	@Override
	public String toString() {
		return "SecteurActivite [idSecteurActivite=" + idSecteurActivite + ", codeSecteurActivite="
				+ codeSecteurActivite + ", libelleSecteurActivite=" + libelleSecteurActivite + "]";
	}
	
}