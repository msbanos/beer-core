package banos.ms.beer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import banos.ms.beer.ingrediant.Grain;

/**
 * [Author]			Mike Banos
 * [Date]			12/14/2017
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		Grain information specific to a recipe.
 */
@Entity
@Table(name="recipe_grain")
public class RecipeGrain {
	/**
	 * Default ctor.
	 */
	public RecipeGrain() { }
	
	/**
	 * Get the unit for the amount.
	 * @return The unit.
	 */
	@Column(name="amount_unit")
	public String getAmountUnit() {
		return amountUnit;
	}
	
	/**
	 * Set the unit for the amount.
	 * @param unit The unit.
	 */
	public void setAmountUnit(final String unit) {
		this.amountUnit = unit;
	}
	
	/**
	 * The the grain amount.
	 * @return The amount.
	 */
	@Column(name="amount")
	public float getAmount() {
		return amount;
	}
	
	public void setAmount(final float amount) {
		this.amount = amount;
	}
	
	/**
	 * Get the grain.
	 * @return The grain.
	 */
	@OneToOne
	@JoinColumn(name="grain_id")
	public Grain getGrain() {
		return grain;
	}
	
	/**
	 * Set the grain.
	 * @param grain The grain.
	 */
	public void setGrain(final Grain grain) {
		this.grain = grain;
	}
	
	/**
	 * Get the associated recipe.
	 * @return The recipe.
	 */
	@ManyToOne
	@JoinColumn(name="recipe_id")
	@JsonIgnore
	public Recipe getRecipe() {
		return recipe;
	}
	
	/**
	 * Set the associated recipe.
	 * @param recipe The recipe.
	 */
	public void setRecipe(final Recipe recipe) {
		this.recipe = recipe;
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
	private float amount;
	private String amountUnit;
	private Recipe recipe;
	private Grain grain;
}
