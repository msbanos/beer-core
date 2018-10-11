package banos.ms.beer.ingrediant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * [Author]			Mike Banos
 * [Date]			12/14/2017
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		The magic makers.
 */
@Entity
@Table(name="yeast_strain")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@yeastid")
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
	 * Get the brand.
	 * @return The brand.
	 */
	@ManyToOne
	@JoinColumn(name="yeast_brand_id")
	public YeastBrand getBrand() {
		return brand;
	}

	/**
	 * Set the brand.
	 * @param name The brand.
	 */
	public void setBrand(final YeastBrand brand) {
		this.brand = brand;
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
	
	/**
	 * Check if a blowoff tube should be used with this strain.
	 * @return True if a blowoff tube should be used; otherwise false.
	 */
	@Column(name="blowoff")
	public boolean getUseBlowoff() {
		return blowoff;
	}
	
	/**
	 * Set whether or not a blowoff tube should be used with this strain.
	 * @param blowoff True if a blowoff tube should be used; otherwise false.
	 */
	public void setUseBlowoff(final boolean blowoff) {
		this.blowoff = blowoff;
	}
	
	private String name, strainId;
	private int id;
	private YeastBrand brand;
	private boolean blowoff;
}
