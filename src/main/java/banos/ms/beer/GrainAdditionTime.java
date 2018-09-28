package banos.ms.beer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The time at which grain is added to the mash.
 * @author mike
 *
 */
@Entity
@Table(name="grain_add_time")
public class GrainAdditionTime {
	/**
	 * Get the instance id.
	 * @return The id.
	 */
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
	 * Get the addition time name.
	 * @return The name.
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}

	/**
	 * Set the addition time name.
	 * @param name The name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	private int id;
	private String name;
}
