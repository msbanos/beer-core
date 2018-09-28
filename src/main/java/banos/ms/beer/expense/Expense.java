package banos.ms.beer.expense;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * [Author]			Mike Banos
 * [Date]			12/14/2017
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		A brewing expense.
 */
@Entity
@Table(name="expense")
public class Expense {
	/**
	 * Default ctor.
	 */
	public Expense() { }
	
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
	 * Get the corresponding expense type.
	 * @return The expense type.
	 */
	@OneToOne
	@JoinColumn(name="expense_type_id")
	public ExpenseType getExpenseType() {
	    return expenseType;
	}
	
	/**
	 * Set the expense type.
	 * @param type The expense type.
	 */
	public void setExpenseType(ExpenseType type) {
		this.expenseType = type;
	}
	
	/**
	 * Get the expense amount.
	 * @return The expense amount.
	 */
	@Column(name="amount")
	public float getAmount() {
	    return amount;
	}
	
	/**
	 * Set the expense amount.
	 * @param amount The expense amount.
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	/**
	 * Get the expense date.
	 * @return The expense date.
	 */
	@Column(name="date")
	public LocalDate getDate() {
	    return date;
	}
	
	/**
	 * Set the expense date.
	 * @param date The expense date.
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	private float amount;
	private int id;
	private ExpenseType expenseType;
	private LocalDate date;
}
