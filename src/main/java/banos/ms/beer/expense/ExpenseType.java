package banos.ms.beer.expense;

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
 * [Summary]		A brewing expense type.
 */
@Entity
@Table(name="expense_type")
public class ExpenseType {
	/**
	 * Default ctor.
	 */
	public ExpenseType() { }
	
	/**
	 * Get the expense description.
	 * @return The description.
	 */
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	
	/**
	 * Set the recipe name.
	 * @param desc The name.
	 */
	public void setDescription(final String desc) {
		this.description = desc;
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
	
	private String description;
	private int id;
}
