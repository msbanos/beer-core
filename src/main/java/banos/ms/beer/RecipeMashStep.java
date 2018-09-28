package banos.ms.beer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import banos.ms.beer.Recipe;

/**
 * [Author]			Mike Banos
 * [Date]			12/14/2017
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		Mash information specific to a recipe.
 */
@Entity
@Table(name="recipe_mash")
public class RecipeMashStep {
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
	
	/**
	 * Get the temperature.
	 * @return The temperature.
	 */
	@Column(name="temp")
	public float getTemperature() {
		return temp;
	}

	/**
	 * Set the temperature.
	 * @param temp The temperature.
	 */
	public void setTemperature(float temp) {
		this.temp = temp;
	}

	/**
	 * Get the temperature duration.
	 * @return The duration.
	 */
	@Column(name="time")
	public float getDuration() {
		return duration;
	}

	/**
	 * Set the temperature duration.
	 * @param duration The duration.
	 */
	public void setDuration(float duration) {
		this.duration = duration;
	}
	
	private int id;
	private float temp, duration;
	private Recipe recipe;
}
