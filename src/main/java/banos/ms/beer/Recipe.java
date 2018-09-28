package banos.ms.beer;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import banos.ms.beer.ingrediant.ClarifyingAgent;
import banos.ms.beer.ingrediant.Yeast;
import banos.ms.beer.RecipeGrain;
import banos.ms.beer.RecipeHop;
import banos.ms.beer.RecipeMashStep;

/**
 * [Author]			Mike Banos
 * [Date]			12/14/2017
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		A recipe.
 */
@Entity
@Table(name="recipe")
public class Recipe {
	/**
	 * Default ctor.
	 */
	public Recipe() { }
	
	/**
	 * Ctor.
	 * @param name The recipe name.
	 */
	public Recipe(final String name) {
		this();
		setName(name);
	}
	
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
	
	/**
	 * Get the BJCP sub-style.
	 * @return The sub-style.
	 */
	@OneToOne
	@JoinColumn(name="bjcp_substyle_id")
	public BJCPSubStyle getBJCPSubstyle() {
		return substyle;
	}
	
	/**
	 * Set the BJCP sub-style.
	 * @param substyle The sub-style.
	 */
	public void setBJCPSubstyle(final BJCPSubStyle substyle) {
		this.substyle = substyle;
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
	 * Get the batch size.
	 * @return The size.
	 */
	@Column(name="batch_size")
	public int getBatchSize() {
		return batchSize;
	}
	
	/**
	 * Set the batch size.
	 * @param batchSize The size.
	 */
	public void setBatchSize(final int batchSize) {
		this.batchSize = batchSize;
	}
	
	/**
	 * Get the target original gravity.
	 * @return The target OG.
	 */
	@Column(name="target_og")
	public float getTargetOG() {
		return targetOG;
	}

	/**
	 * Set the target original gravity.
	 * @param targetOG The target OG.
	 */
	public void setTargetOG(float targetOG) {
		this.targetOG = targetOG;
	}

	/**
	 * Get the target final gravity.
	 * @return The target FG.
	 */
	@Column(name="target_fg")
	public float getTargetFG() {
		return targetFG;
	}

	/**
	 * Set the target final gravity.
	 * @param targetFG The target FG.
	 */
	public void setTargetFG(float targetFG) {
		this.targetFG = targetFG;
	}
	
	/**
	 * Get the grain amount information.
	 * @return The grain info.
	 */
	@OneToMany(mappedBy="recipe", cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<RecipeGrain> getGrainInfo() {
		return grains;
	}
	
	/**
	 * Set the grain amount information.
	 * @param grains The grain info.
	 */
	public void setGrainInfo(List<RecipeGrain> grains) {
		for (RecipeGrain grain : grains) {
			grain.setRecipe(this);
		}
		
		this.grains = grains;
	}
	
	/**
	 * Get the hop amount information.
	 * @return The hop info.
	 */
	@OneToMany(mappedBy="recipe", cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<RecipeHop> getHopInfo() {
		return hops;
	}
	
	/**
	 * Set the hop amount information.
	 * @param hops The hop info.
	 */
	public void setHopInfo(List<RecipeHop> hops) {
		for (RecipeHop hop : hops) {
			hop.setRecipe(this);
		}
		
		this.hops = hops;
	}
	
	/**
	 * Get the mash temperatures.
	 * @return The mash temps.
	 */
	@OneToMany(mappedBy="recipe", cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<RecipeMashStep> getMashInfo() {
		return mashTemps;
	}
	
	/**
	 * Set the mash temperatures.
	 * @param temps The mash temps.
	 */
	public void setMashInfo(List<RecipeMashStep> temps) {
		for (RecipeMashStep temp : temps) {
			temp.setRecipe(this);
		}
		
		this.mashTemps = temps;
	}
	
	/**
	 * Get the yeast.
	 * @return The yeast.
	 */
	@OneToOne
	@JoinColumn(name="yeast_strain_id")
	public Yeast getYeast() {
		return yeast;
	}
	
	/**
	 * Set the yeast.
	 * @param yeast The yeast.
	 */
	public void setYeast(final Yeast yeast) {
		this.yeast = yeast;
	}
	
	/**
	 * Get the clarifying agent.
	 * @return The agent id.
	 */
	@OneToOne
	@JoinColumn(name="clar_agent_id")
	public ClarifyingAgent getClarifyingAgent() {
		return agent;
	}
	
	/**
	 * Set the clarifying agent.
	 * @param agent The agent.
	 */
	public void setClarifyingAgent(final ClarifyingAgent agent) {
		this.agent = agent;
	}
	
	/**
	 * Get indicator of if a yeast starter was used.
	 * @return True if a starter was used; otherwise false.
	 */
	@Column(name="yeast_starter")
	public boolean getYeastStarter() {
		return yeastStarter;
	}
	
	/**
	 * Set whether or not a yeast starter was used.
	 * @param starter True if a starter was used; otherwise false.
	 */
	public void setYeastStarter(final boolean starter) {
		this.yeastStarter = starter;
	}
	
	/**
	 * Get the target yeast pitch temperature.
	 * @return The target temp.
	 */
	@Column(name="pitch_temp")
	public float getTargetPitchTemp() {
		return targetPitchTemp;
	}
	
	/**
	 * Set the target yeast pitch temperature.
	 * @param temp The target temp.
	 */
	public void setTargetPitchTemp(final float temp) {
		targetPitchTemp = temp;
	}
	
	/**
	 * Get the clarifying agent amount.
	 * @return The amount.
	 */
	@Column(name="clar_amount")
	public float getClarifierAmount() {
		return clarifierAmount;
	}
	
	/**
	 * Set the clarifying agent amount.
	 * @param amount The amount.
	 */
	public void setClarifierAmount(final Float amount) {
		clarifierAmount = amount;
	}
	
	/**
	 * Get the clarifying agent addition time.
	 * @return The addition time.
	 */
	@Column(name="clar_time")
	public float getClarifierAddTime() {
		return clarifierTime;
	}
	
	/**
	 * Set the clarifying agent addition time.
	 * @param amount The addition time.
	 */
	public void setClarifierAddTime(final Float time) {
		clarifierTime = time;
	}
	
	/**
	 * Get the boil volume.
	 * @return The volume.
	 */
	@Column(name="boil_volume")
	public float getBoilVolume() {
		return boilVolume;
	}
	
	/**
	 * Set the boil volume.
	 * @param volume The volume.
	 */
	public void setBoilVolume(final float volume) {
		this.boilVolume = volume;
	}
	
	/**
	 * Get the boil time.
	 * @return The time.
	 */
	@Column(name="boil_time")
	public float getBoilTime() {
		return boilTime;
	}
	
	/**
	 * Set the boil time.
	 * @param time The time.
	 */
	public void setBoilTime(final float time) {
		this.boilTime = time;
	}
	
	/**
	 * Get the fermentation schedule.
	 * @return The fermentation schedule.
	 */
	@Column(name="ferm_schedule")
	public String getFermentationSchedule() {
		return fermSchedule;
	}
	
	/**
	 * Set the fermentation schedule.
	 * @param schedule The fermentation schedule.
	 */
	public void setFermentationSchedule(final String schedule) {
		fermSchedule = schedule;
	}
	
	/**
	 * Get the notes.
	 * @return The notes.
	 */
	@Column(name="notes")
	public String getNotes() {
		return notes;
	}
	
	/**
	 * Set the notes.
	 * @param notes The notes.
	 */
	public void setNotes(final String notes) {
		this.notes = notes;
	}
	
	/**
	 * Get the recipe created date.
	 * @return The recipe created date.
	 */
	@Column(name="create_date")
	public LocalDateTime getCreatedDate() {
		return createDate;
	}
	
	/**
	 * Set the recipe created date.
	 * @param date The created date.
	 */
	public void setCreatedDate(LocalDateTime date) {
		createDate = date;
	}
	
	private String name, notes, fermSchedule;
	private int id, batchSize;
	private float targetOG, targetFG, targetPitchTemp, boilVolume, boilTime;
	private List<RecipeGrain> grains;
	private List<RecipeHop> hops;
	private List<RecipeMashStep> mashTemps;
	private boolean yeastStarter;
	private Float clarifierAmount, clarifierTime;
	private LocalDateTime createDate;
	private ClarifyingAgent agent;
	private Yeast yeast;
	private BJCPSubStyle substyle;
}
