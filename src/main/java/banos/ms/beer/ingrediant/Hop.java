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
 * [Summary]		The sweetness.
 */
@Entity
@Table(name="hop")
public class Hop {
	/**
	 * Default ctor.
	 */
	public Hop() { }
	
	/**
	 * Get the hop name.
	 * @return The name.
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}

	/**
	 * Set the hop name.
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
	public void setId(final int id) {
		this.id = id;
	}
	
	/**
	 * Get the hop expected alpha acid content.
	 * @return The alpha acid content.
	 */
	@Column(name="alpha_content")
	public float getAlphaAcidContent() {
		return alpha;
	}
	
	/**
	 * Get the hop expected alpha acid content.
	 * @param aa The alpha acid content.
	 */
	public void setAlphaAcidContent(final float aa) {
		alpha = aa;
	}
	
	private String name;
	private int id;
	private float alpha;
}
