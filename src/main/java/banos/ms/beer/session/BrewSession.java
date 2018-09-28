package banos.ms.beer.session;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import banos.ms.beer.Recipe;

/**
 * [Author]			Mike Banos
 * [Date]			12/14/2017
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		A brewing session.
 */
@Entity
@Table(name="brew_session")
public class BrewSession {
	/**
	 * Default ctor.
	 */
	public BrewSession() { }
	
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
	public void setId(final int id) {
		this.id = id;
	}
	
	/**
	 * Get the recipe.
	 * @return The recipe.
	 */
	@OneToOne
	@JoinColumn(name="recipe_id")
	public Recipe getRecipe() {
		return recipe;
	}

	/**
	 * Set the recipe.
	 * @param recipe The recipe.
	 */
	public void setRecipe(final Recipe recipe) {
		this.recipe = recipe;
	}

	/**
	 * Get the brew date.
	 * @return The brew date.
	 */
	@Column(name="brew_date")
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Set the brew date.
	 * @param date The brew date.
	 */
	public void setDate(final LocalDate date) {
		this.date = date;
	}

	/**
	 * Get the strike water volume.
	 * @return The strike water volume.
	 */
	@Column(name="strike_volume")
	public float getStrikeVol() {
		return strikeVol;
	}

	/**
	 * Set the strike water volume.
	 * @param strikeVol The strike water volume.
	 */
	public void setStrikeVol(final float strikeVol) {
		this.strikeVol = strikeVol;
	}

	/**
	 * Get the strike water temperature.
	 * @return The strike water temperature.
	 */
	@Column(name="strike_temp")
	public float getStrikeTemp() {
		return strikeTemp;
	}

	/**
	 * Set the strike water temperature.
	 * @param strikeTemp The strike water temperature.
	 */
	public void setStrikeTemp(final float strikeTemp) {
		this.strikeTemp = strikeTemp;
	}

	/**
	 * Get the mash starting temperature.
	 * @return The mash starting temperature.
	 */
	@Column(name="mash_temp")
	public float getMashTemp() {
		return mashTemp;
	}

	/**
	 * Set the mash starting temperature.
	 * @param mashTemp The mash starting temperature.
	 */
	public void setMashTemp(final float mashTemp) {
		this.mashTemp = mashTemp;
	}

	/**
	 * Get the sparge water volume.
	 * @return The sparge water volume.
	 */
	@Column(name="sparge_volume")
	public float getSpargeVol() {
		return spargeVol;
	}

	/**
	 * Set the sparge water volume.
	 * @param spargeVol The sparge water volume.
	 */
	public void setSpargeVol(final float spargeVol) {
		this.spargeVol = spargeVol;
	}

	/**
	 * Get the original gravity.
	 * @return The original gravity.
	 */
	@Column(name="orig_gravity")
	public float getOrigGravity() {
		return origGravity;
	}

	/**
	 * Set the original gravity.
	 * @param origGravity The original gravity.
	 */
	public void setOrigGravity(final float origGravity) {
		this.origGravity = origGravity;
	}
	
	/**
	 * Get the final gravity.
	 * @return The final gravity.
	 */
	@Column(name="final_gravity")
	public Float getFinalGravity() {
		return finalGravity;
	}

	/**
	 * Set the final gravity.
	 * @param finalGravity The final gravity.
	 */
	public void setFinalGravity(final Float finalGravity) {
		this.finalGravity = finalGravity;
	}

	/**
	 * Get the brew session notes.
	 * @return The notes.
	 */
	@Column(name="notes")
	public String getNotes() {
		return notes;
	}

	/**
	 * Set the brew session notes.
	 * @param notes The notes.
	 */
	public void setNotes(final String notes) {
		this.notes = notes;
	}
	
	/**
	 * Get the yeast pitch temperature.
	 * @return The pitch temp.
	 */
	@Column(name="pitch_temp")
	public float getPitchTemp() {
		return pitchTemp;
	}
	
	/**
	 * Set the yeast pitch temperature.
	 * @param temp The pitch temp.
	 */
	public void setPitchTemp(final float temp) {
		pitchTemp = temp;
	}
	
	/**
	 * Get the date the batch was transferred to secondary.
	 * @return The transfer date.
	 */
	@Column(name="transfer_date")
	public LocalDate getSecondaryTransferDate() {
		return transferDate;
	}
	
	/**
	 * Get the date the batch was transferred to secondary.
	 * @param date The transfer date.
	 */
	public void setSecondaryTransferDate(final LocalDate date) {
		transferDate = date;
	}
	
	/**
	 * Get the batch package date.
	 * @return The package date.
	 */
	@Column(name="package_date")
	public LocalDate getPackageDate() {
		return packageDate;
	}
	
	/**
	 * Set the batch package date.
	 * @param date The package date.
	 */
	public void setPackageDate(final LocalDate date) {
		packageDate = date;
	}

	private int id;
	private Recipe recipe;
	private LocalDate date, transferDate, packageDate;
	private float strikeVol, strikeTemp, mashTemp, spargeVol, origGravity, pitchTemp;
	private Float finalGravity;
	private String notes;
}
