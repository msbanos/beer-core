package banos.ms.beer.ingrediant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import banos.ms.beer.IngrediantAdditionStep;

/**
 * [Author]			Mike Banos
 * [Date]			12/14/2017
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		The grain.
 */
@Entity
@Table(name="grain")
public class Grain {
	/**
	 * Default ctor.
	 */
	public Grain() { }
	
	/**
	 * Get the recipe name.
	 * @return The name.
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}

	/**
	 * Set the recipe name.
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
	 * Get the color in Lovibond.
	 * @return The color in Lovibond.
	 */
	@Column(name="lovi")
	public float getLovibond() {
		return lovi;
	}

	/**
	 * Set the color in Lovibond.
	 * @param lovi The color in Lovibond.
	 */
	public void setLovibond(final float lovi) {
		this.lovi = lovi;
	}
	
	/**
	 * Get the addition step.
	 * @return The addition step.
	 */
	@Column(name="add_step")
	public IngrediantAdditionStep getAdditionStep() {
		return addStep;
	}

	/**
	 * Set the addition step.
	 * @param step The addition step.
	 */
	public void setAdditionStep(IngrediantAdditionStep step) {
		this.addStep = step;
	}

	private String name;
	private int id;
	private float lovi;
	private IngrediantAdditionStep addStep;
}
