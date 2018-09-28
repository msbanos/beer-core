package banos.ms.beer.ingrediant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import banos.ms.beer.GrainAdditionTime;

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
	 * Get the grain addition time.
	 * @return The addition time.
	 */
	@OneToOne
	@JoinColumn(name="grain_add_time_id")
	public GrainAdditionTime getAdditionTime() {
		return addTime;
	}

	/**
	 * Set the grain addition time.
	 * @param addTime The addition time.
	 */
	public void setAdditionTime(GrainAdditionTime addTime) {
		this.addTime = addTime;
	}

	private String name;
	private int id;
	private GrainAdditionTime addTime;
}
