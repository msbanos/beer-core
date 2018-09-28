package banos.ms.beer.ingrediant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * [Author]			Mike Banos
 * [Date]			12/14/2017
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		The magic makers.
 */
@Entity
@Table(name="yeast_strain")
public class Yeast {
	/**
	 * Default ctor.
	 */
	public Yeast() { }
	
	/**
	 * Get the strain name.
	 * @return The name.
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}

	/**
	 * Set the strain name.
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
	 * Get the brand id.
	 * @return The brand id.
	 */
	@Column(name="yeast_brand_id")
	public int getBrandId() {
		return brandId;
	}

	/**
	 * Set the brand id.
	 * @param name The brand id.
	 */
	public void setBrandId(final int brandId) {
		this.brandId = brandId;
	}
	
	/**
	 * Get the strain id.
	 * @return The strain id.
	 */
	@Column(name="strain_id")
	public String getStrainId() {
		return strainId;
	}

	/**
	 * Set the strain id.
	 * @param name The strain id.
	 */
	public void setStrainId(final String strainId) {
		this.strainId = strainId;
	}
	
	private String name, strainId;
	private int id, brandId;
}
