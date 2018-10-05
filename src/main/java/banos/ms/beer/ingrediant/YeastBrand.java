package banos.ms.beer.ingrediant;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * [Author]			Mike Banos
 * [Date]			12/14/2017
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		A yeast manufacturer.
 */
@Entity
@Table(name="yeast_brand")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@yeastbrandid")
public class YeastBrand {
	/**
	 * Default ctor.
	 */
	public YeastBrand() { }
	
	/**
	 * Get the brand name.
	 * @return The name.
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}

	/**
	 * Set the brand name.
	 * @param name The name.
	 */
	public void setName(final String name) {
		this.name = name;
	}

	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	public int getId() {
	    return id;
	}
	
	/**
	 * Set the instance id.
	 * @param id The id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Get the strains for the brand.
	 * @return The list of strains
	 */
	@OneToMany(mappedBy="brand", cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Yeast> getStrains() {
		return strains;
	}
	
	/**
	 * Set the list of brand strains.
	 * @param strains The strains for the brand.
	 */
	public void setStrains(List<Yeast> strains) {
		this.strains = strains;
	}
	
	private String name;
	private int id;
	private List<Yeast> strains;
}
