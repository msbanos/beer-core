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
 * [Summary]		A wort clarifying agent.
 */
@Entity
@Table(name="clar_agent")
public class ClarifyingAgent {
	/**
	 * Default ctor.
	 */
	public ClarifyingAgent() { }
	
	/**
	 * Get the agent name.
	 * @return The name.
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}

	/**
	 * Set the agent name.
	 * @param name The name.
	 */
	public void setName(final String name) {
		this.name = name;
	}
	
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
	
	private int id;
	private String name;
}
