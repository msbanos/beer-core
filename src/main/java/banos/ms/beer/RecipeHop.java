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

import banos.ms.beer.Recipe;
import banos.ms.beer.ingrediant.Hop;

/**
 * [Author]			Mike Banos
 * [Date]			12/14/2017
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		Hop information specific to a recipe.
 */
@Entity
@Table(name="recipe_hop")
public class RecipeHop {
	static public enum HopType { PELLET, WHOLE }
	
	/**
	 * Default ctor.
	 */
	public RecipeHop() { }
	
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
	 * The the grain amount.
	 * @return The amount.
	 */
	@Column(name="amount")
	public float getAmount() {
		return amount;
	}
	
	/**
	 * Set the hop amount.
	 * @param amount The amount.
	 */
	public void setAmount(final float amount) {
		this.amount = amount;
	}
	
	/**
	 * Get the hop.
	 * @return The hop.
	 */
	@OneToOne
	@JoinColumn(name="hop_id")
	public Hop getHop() {
		return hop;
	}
	
	/**
	 * Set the hop.
	 * @param hop The hop.
	 */
	public void setHop(final Hop hop) {
		this.hop = hop;
	}
	
	/**
	 * The the addition time.
	 * @return The addition time.
	 */
	@Column(name="addition_time")
	public String getAdditionTime() {
		return time;
	}
	
	/**
	 * Set the addition time.
	 * @param time The addition time.
	 */
	public void setAdditionTime(final String time) {
		this.time = time;
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
	 * Get the hop type used.
	 * @return The hop type.
	 */
	@Column(name="type")
	public HopType getHopType() {
		return type;
	}
	
	/**
	 * Set the hop type used.
	 * @param type The hop type.
	 */
	public void setHopType(HopType type) {
		this.type = type;
	}
	
	private int id;
	private float amount;
	private String time;
	private HopType type;
	private Recipe recipe;
	private Hop hop;
}
