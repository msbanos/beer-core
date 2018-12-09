package banos.ms.beer;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import banos.ms.beer.session.BrewSession;

/**
 * [Author]			Mike Banos
 * [Date]			10/13/2018
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		A score sheet.
 */
@Entity
@Table(name="score_sheet")
public class ScoreSheet {
	/**
	 * Default ctor.
	 */
	public ScoreSheet() { }
	
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
	 * Get the corresponding brew session.
	 * @return The session.
	 */
	@OneToOne
	@JoinColumn(name="brew_session_id")
	public BrewSession getSession() {
		return session;
	}
	
	/**
	 * Set the corresponding brew session.
	 * @param session The session.
	 */
	public void setSession(final BrewSession session) {
		this.session = session;
	}
	
	/**
	 * Get the name of the competition.
	 * @return The competition name.
	 */
	@Column(name="comp_name")
	public String getCompetitionName() {
		return compName;
	}
	
	/**
	 * Set the name of the competition.
	 * @param name The competition name.
	 */
	public void setCompetitionName(final String name) {
		compName = name;
	}
	
	/**
	 * Get the location of the competition.
	 * @return The competition location.
	 */
	@Column(name="comp_loc")
	public String getCompetitionLocation() {
		return compLoc;
	}
	
	/**
	 * Set the location of the competition.
	 * @param name The competition location.
	 */
	public void setCompetitionLocation(final String loc) {
		compLoc = loc;
	}
	
	/**
	 * Get the competition date.
	 * @return The competition date.
	 */
	@Column(name="comp_date")
	public LocalDate getCompetitionDate() {
		return compDate;
	}
	
	/**
	 * Set the competition date.
	 * @param date The competition date.
	 */
	public void setCompetitionDate(final LocalDate date) {
		compDate = date;
	}
	
	/**
	 * Get the judge.
	 * @return The judge.
	 */
	@OneToOne
	@JoinColumn(name="judge_id")
	public Judge getJudge() {
		return judge;
	}
	
	/**
	 * Set the judge.
	 * @param judge The judge.
	 */
	public void setJudge(final Judge judge) {
		this.judge = judge;
	}
	
	/**
	 * Get the position of the sample in the flight.
	 * @return The flight position.
	 */
	@Column(name="flight_pos")
	public int getFlightPosition() {
		return flightPos;
	}
	
	/**
	 * Set the position of the sample in the flight.
	 * @param pos The flight position.
	 */
	public void setFlightPosition(final int pos) {
		flightPos = pos;
	}
	
	/**
	 * Get the total number of samples in the flight.
	 * @return The flight sample count.
	 */
	@Column(name="flight_count")
	public int getFlightCount() {
		return flightCount;
	}
	
	/**
	 * Set the total number of samples in the flight.
	 * @param count The flight sample count.
	 */
	public void setFlightCount(final int count) {
		flightCount = count;
	}
	
	/**
	 * Get if the sample advanced to the mini Best of Show.
	 * @return True if the sample advanced to the mini-BOS; otherwise false.
	 */
	@Column(name="in_bos")
	public boolean getInBOS() {
		return bos;
	}
	
	/**
	 * Set if the sample advanced to the mini Best of Show.
	 * @param bos True if the sample advanced to the mini-BOS; otherwise false.
	 */
	public void setInBOS(final boolean bos) {
		this.bos = bos;
	}
	
	/**
	 * Get the mini Best of Show placement.
	 * @return The min-BOS place.
	 */
	@Column(name="bos_place")
	public Integer getBOSPlace() {
		return bosPlace;
	}
	
	/**
	 * Set the mini Best of Show placement.
	 * @param place The min-BOS place.
	 */
	public void setBOSPlace(final Integer place) {
		bosPlace = place;
	}
	
	/**
	 * Get the consensus score.
	 * @return The consensus score.
	 */
	@Column(name="consensus_score")
	public int getConsensusScore() {
		return consensus;
	}
	
	/**
	 * Set the consensus score.
	 * @param score The consensus score.
	 */
	public void setConsensusScore(final int score) {
		consensus = score;
	}
	
	/**
	 * Get if the bottle was deemed OK.
	 * @return True if the OK box was checked; otherwise false.
	 */
	@Column(name="bottle_ok")
	public boolean getBottleOK() {
		return bottleOk;
	}
	
	/**
	 * Set if the bottle was deemed OK.
	 * @param ok True if the OK box was checked; otherwise false.
	 */
	public void setBottleOK(final boolean ok) {
		bottleOk = ok;
	}
	
	/**
	 * Get the bottle comment.
	 * @return The bottle comment.
	 */
	@Column(name="bottle_comment")
	public String getBottleComment() {
		return bottleComment;
	}
	
	/**
	 * Set the bottle comment.
	 * @param comment The bottle comment.
	 */
	public void setBottleComment(final String comment) {
		bottleComment = comment;
	}
	
	/**
	 * Get the mapping of flaw to level.
	 * @return The flaw mapping.
	 */
	@ElementCollection
	@CollectionTable(name="ss_flaws", joinColumns=@JoinColumn(name="score_sheet_id"))
	@Column(name="flaw_level")
	@MapKeyColumn(name="flaw")
	@MapKeyEnumerated(EnumType.STRING)
	public Map<Flaw, FlawLevel> getFlaws() {
		return flaws;
	}
	
	/**
	 * Set the mapping of flaw to level.
	 * @param flaws The flaw mapping.
	 */
	public void setFlaws(final Map<Flaw, FlawLevel> flaws) {
		this.flaws = flaws;
	}
	
	/**
	 * Get the judge's feedback.
	 * @return The feedback.
	 */
	@Column(name="feedback")
	public String getFeedback() {
		return feedback;
	}
	
	/**
	 * Set the judge's feedback.
	 * @param feedback The feedback.
	 */
	public void setFeedback(final String feedback) {
		this.feedback = feedback;
	}
	
	/**
	 * Get the judge's total score.
	 * @return The total score.
	 */
	@Column(name="judge_total")
	public int getJudgeTotal() {
		return total;
	}
	
	/**
	 * Set the judge's total score.
	 * @param total The total.
	 */
	public void setJudgeTotal(final int total) {
		this.total = total;
	}
	
	/**
	 * Get the aroma score.
	 * @return The score.
	 */
	@Column(name="aroma_score")
	public int getAromaScore() {
		return aromaScore;
	}
	
	/**
	 * Set the aroma score.
	 * @param score The score.
	 */
	public void setAromaScore(final int score) {
		aromaScore = score;
	}
	
	/**
	 * Get the appearance score.
	 * @return The score.
	 */
	@Column(name="app_score")
	public int getAppearanceScore() {
		return appScore;
	}
	
	/**
	 * Set the appearance score.
	 * @param score The score.
	 */
	public void setAppearanceScore(final int score) {
		appScore = score;
	}
	
	/**
	 * Get the flavor score.
	 * @return The score.
	 */
	@Column(name="flavor_score")
	public int getFlavorScore() {
		return flavorScore;
	}
	
	/**
	 * Set the flavor score.
	 * @param score The score.
	 */
	public void setFlavorScore(final int score) {
		flavorScore = score;
	}
	
	/**
	 * Get the mouthfeel score.
	 * @return The score.
	 */
	@Column(name="mf_score")
	public int getMouthfeelScore() {
		return mfScore;
	}
	
	/**
	 * Set the mouthfeel score.
	 * @param score The score.
	 */
	public void setMouthfeelScore(final int score) {
		mfScore = score;
	}
	
	/**
	 * Get the overall score.
	 * @return The score.
	 */
	@Column(name="overall_score")
	public int getOverallScore() {
		return overallScore;
	}
	
	/**
	 * Set the overall score.
	 * @param score The score.
	 */
	public void setOverallScore(final int score) {
		overallScore = score;
	}
	
	/**
	 * Get the "aroma - other" comment.
	 * @return The "other" comment.
	 */
	@Column(name="aroma_other")
	public String getAromaOther() {
		return aromaOther;
	}
	
	/**
	 * Set the "aroma - other" comment.
	 * @param other The "other" comment.
	 */
	public void setAromaOther(final String other) {
		this.aromaOther = other;
	}
	
	/**
	 * Get the "appearance - other" comment.
	 * @return The "other" comment.
	 */
	@Column(name="app_other")
	public String getAppearanceOther() {
		return appOther;
	}
	
	/**
	 * Set the "appearance - other" comment.
	 * @param other The "other" comment.
	 */
	public void setAppearanceOther(final String other) {
		this.appOther = other;
	}
	
	/**
	 * Get the "appearance - texture" comment.
	 * @return The "other" comment.
	 */
	@Column(name="app_texture")
	public String getAppearanceTexture() {
		return appTexture;
	}
	
	/**
	 * Set the "appearance - texture" comment.
	 * @param texture The "other" comment.
	 */
	public void setAppearanceTexture(final String texture) {
		this.appTexture = texture;
	}
	
	/**
	 * Get the "flavor - other" comment.
	 * @return The "other" comment.
	 */
	@Column(name="flav_other")
	public String getFlavorOther() {
		return flavorOther;
	}
	
	/**
	 * Set the "flavor - other" comment.
	 * @param other The "other" comment.
	 */
	public void setFlavorOther(final String other) {
		this.flavorOther = other;
	}
	
	/**
	 * Get the "mouthfeel - other" comment.
	 * @return The "other" comment.
	 */
	@Column(name="mf_other")
	public String getMouthfeelOther() {
		return mfOther;
	}
	
	/**
	 * Set the "mouthfeel - other" comment.
	 * @param other The "other" comment.
	 */
	public void setMouthfeelOther(final String other) {
		this.mfOther = other;
	}
	
	/**
	 * Get the overall style rating (0="Classic Example" - 4="Not to Style").
	 * @return The style rating.
	 */
	@Column(name="style_overall")
	public int getOverallStyle() {
		return overallStyle;
	}
	
	/**
	 * Set the overall style rating (0="Classic Example" - 4="Not to Style").
	 * @param style The style rating.
	 */
	public void setOverallStyle(final int style) {
		this.overallStyle = style;
	}
	
	/**
	 * Set the overall impression rating (0="Wonderful" - 4="Lifeless").
	 * @return The impression rating.
	 */
	@Column(name="impr_overall")
	public int getOverallImpression() {
		return overallImpression;
	}
	
	/**
	 * Set the overall impression rating (0="Wonderful" - 4="Lifeless").
	 * @param imp The impression rating.
	 */
	public void setOverallImpression(final int imp) {
		overallImpression = imp;
	}
	
	/**
	 * Get the overall flaws rating (0="Flawless" - 4="Significant Flaws").
	 * @return The flaws rating.
	 */
	@Column(name="flaws_overall")
	public float getOverallFlaws() {
		return overallFlaws;
	}
	
	/**
	 * Set the overall flaws rating (0="Flawless" - 4="Significant Flaws").
	 * @param flaws The flaws rating.
	 */
	public void setOverallFlaws(final float flaws) {
		overallFlaws = flaws;
	}
	
	/**
	 * Get the perceived malt aroma level.
	 * @return The malt level.
	 */
	@Column(name="malt_aroma_level")
	@Enumerated(EnumType.STRING)
	public IngrediantLevel getMaltAromaLevel() {
		return maltAromaLevel;
	}
	
	/**
	 * Set the perceived malt aroma level.
	 * @param level The malt level.
	 */
	public void setMaltAromaLevel(final IngrediantLevel level) {
		maltAromaLevel = level;
	}
	
	/**
	 * Get whether the malt aroma level was inappropriate.
	 * @return True if the level was inappropriate; otherwise false.
	 */
	@Column(name="ma_inappr")
	public boolean getMaltAromaInappropriate() {
		return maltAromaInapp;
	}
	
	/**
	 * Set whether the malt aroma level was inappropriate.
	 * @param inapp True if the level was inappropriate; otherwise false.
	 */
	public void setMaltAromaInappropriate(final boolean inapp) {
		maltAromaInapp = inapp;
	}
	
	/**
	 * Get the malt aroma comment.
	 * @return The comment.
	 */
	@Column(name="ma_comment")
	public String getMaltAromaComment() {
		return maltAromaComment;
	}
	
	/**
	 * Set the malt aroma comment.
	 * @param comment The comment.
	 */
	public void setMaltAromaComment(final String comment) {
		maltAromaComment = comment;
	}
	
	/**
	 * Get the perceived hop aroma level.
	 * @return The aroma level.
	 */
	@Column(name="hop_aroma_level")
	@Enumerated(EnumType.STRING)
	public IngrediantLevel getHopAromaLevel() {
		return hopAromaLevel;
	}
	
	/**
	 * Set the perceived hop aroma level.
	 * @param level The aroma level.
	 */
	public void setHopAromaLevel(final IngrediantLevel level) {
		hopAromaLevel = level;
	}
	
	/**
	 * Get whether the hop aroma level was inappropriate.
	 * @return True if the level was inappropriate; otherwise false.
	 */
	@Column(name="ha_inappr")
	public boolean getHopAromaInappropriate() {
		return hopAromaInapp;
	}
	
	/**
	 * Set whether the hop aroma level was inappropriate.
	 * @param inapp True if the level was inappropriate; otherwise false.
	 */
	public void setHopAromaInappropriate(final boolean inapp) {
		hopAromaInapp = inapp;
	}
	
	/**
	 * Get the hop aroma comment.
	 * @return The comment.
	 */
	@Column(name="ha_comment")
	public String getHopAromaComment() {
		return hopAromaComment;
	}
	
	/**
	 * Set the hop aroma comment.
	 * @param comment The comment.
	 */
	public void setHopAromaComment(final String comment) {
		hopAromaComment = comment;
	}
	
	/**
	 * Get the perceived fermentation aroma level.
	 * @return The aroma level.
	 */
	@Column(name="ferm_aroma_level")
	@Enumerated(EnumType.STRING)
	public IngrediantLevel getFermentationAromaLevel() {
		return fermAromaLevel;
	}
	
	/**
	 * Set the perceived fermentation aroma level.
	 * @param level The aroma level.
	 */
	public void setFermentationAromaLevel(final IngrediantLevel level) {
		fermAromaLevel = level;
	}
	
	/**
	 * Get whether the fermentation aroma level was inappropriate.
	 * @return True if the level was inappropriate; otherwise false.
	 */
	@Column(name="fa_inappr")
	public boolean getFermentationAromaInappropriate() {
		return fermAromaInapp;
	}
	
	/**
	 * Set whether the fermentation aroma level was inappropriate.
	 * @param inapp True if the level was inappropriate; otherwise false.
	 */
	public void setFermentationAromaInappropriate(final boolean inapp) {
		fermAromaInapp = inapp;
	}
	
	/**
	 * Get the fermentation aroma comment.
	 * @return The comment.
	 */
	@Column(name="fa_comment")
	public String getFermentationAromaComment() {
		return fermAromaComment;
	}
	
	/**
	 * Set the fermentation aroma comment.
	 * @param comment The comment.
	 */
	public void setFermentationAromaComment(final String comment) {
		fermAromaComment = comment;
	}
	
	/**
	 * Get the beer color.
	 * @return The color.
	 */
	@Column(name="beer_color")
	@Enumerated(EnumType.STRING)
	public BeerColor getBeerColor() {
		return bColor;
	}
	
	/**
	 * Set the beer color.
	 * @param color The color.
	 */
	public void setBeerColor(final BeerColor color) {
		this.bColor = color;
	}
	
	/**
	 * Get whether the beer color was inappropriate.
	 * @return True if the color was inappropriate; otherwise false.
	 */
	@Column(name="bc_inappr")
	public boolean getBeerColorInappropriate() {
		return bColorInapp;
	}
	
	/**
	 * Set whether the beer color was inappropriate.
	 * @param inapp True if the color was inappropriate; otherwise false.
	 */
	public void setBeerColorInappropriate(final boolean inapp) {
		bColorInapp = inapp;
	}
	
	/**
	 * Get the head color.
	 * @return The color.
	 */
	@Column(name="head_color")
	@Enumerated(EnumType.STRING)
	public HeadColor getHeadColor() {
		return hColor;
	}
	
	/**
	 * Set the head color.
	 * @param color The color.
	 */
	public void setHeadColor(final HeadColor color) {
		this.hColor = color;
	}
	
	/**
	 * Get whether the head color was inappropriate.
	 * @return True if the color was inappropriate; otherwise false.
	 */
	@Column(name="hc_inappr")
	public boolean getHeadColorInappropriate() {
		return hColorInapp;
	}
	
	/**
	 * Set whether the head color was inappropriate.
	 * @param inapp True if the color was inappropriate; otherwise false.
	 */
	public void setHeadColorInappropriate(final boolean inapp) {
		hColorInapp = inapp;
	}
	
	/**
	 * Get the clarity.
	 * @return The clarity.
	 */
	@Column(name="clarity")
	@Enumerated(EnumType.STRING)
	public Clarity getClarity() {
		return clarity;
	}
	
	/**
	 * Set the clarity.
	 * @param clarity The clarity.
	 */
	public void setClarity(final Clarity clarity) {
		this.clarity = clarity;
	}
	
	/**
	 * Get whether the clarity was inappropriate.
	 * @return True if the clarity was inappropriate; otherwise false.
	 */
	@Column(name="clar_inappr")
	public boolean getClarityInappropriate() {
		return clarityInapp;
	}
	
	/**
	 * Set whether the clarity was inappropriate.
	 * @param inapp True if the clarity was inappropriate; otherwise false.
	 */
	public void setClarityInappropriate(final boolean inapp) {
		clarityInapp = inapp;
	}
	
	/**
	 * Get the head retention.
	 * @return The retention.
	 */
	@Column(name="retention")
	@Enumerated(EnumType.STRING)
	public HeadRetention getHeadRetention() {
		return retention;
	}
	
	/**
	 * Set the head retention.
	 * @param retention The retention.
	 */
	public void setHeadRetention(final HeadRetention retention) {
		this.retention = retention;
	}
	
	/**
	 * Get whether the head retention was inappropriate.
	 * @return True if the retention was inappropriate; otherwise false.
	 */
	@Column(name="hret_inappr")
	public boolean getRetentionInappropriate() {
		return retInapp;
	}
	
	/**
	 * Set whether the head retention was inappropriate.
	 * @param inapp True if the retention was inappropriate; otherwise false.
	 */
	public void setRetentionInappropriate(final boolean inapp) {
		retInapp = inapp;
	}
	
	/**
	 * Get the perceived malt flavor level.
	 * @return The flavor level.
	 */
	@Column(name="malt_flav_level")
	@Enumerated(EnumType.STRING)
	public IngrediantLevel getMaltFlavorLevel() {
		return maltFlavorLevel;
	}
	
	/**
	 * Set the perceived malt flavor level.
	 * @param level The flavor level.
	 */
	public void setMaltFlavorLevel(final IngrediantLevel level) {
		maltFlavorLevel = level;
	}
	
	/**
	 * Get whether the malt flavor was inappropriate.
	 * @return True if the flavor was inappropriate; otherwise false.
	 */
	@Column(name="mf_inappr")
	public boolean getMaltFlavorInappropriate() {
		return maltFlavorInapp;
	}
	
	/**
	 * Set whether the malt flavor was inappropriate.
	 * @param inapp True if the flavor was inappropriate; otherwise false.
	 */
	public void setMaltFlavorInappropriate(final boolean inapp) {
		maltFlavorInapp = inapp;
	}
	
	/**
	 * Get the malt flavor comment.
	 * @return The flavor comment.
	 */
	@Column(name="mf_comment")
	public String getMaltFlavorComment() {
		return maltFlavorComment;
	}
	
	/**
	 * Set the malt flavor comment.
	 * @param comment The flavor comment.
	 */
	public void setMaltFlavorComment(final String comment) {
		maltFlavorComment = comment;
	}
	
	/**
	 * Get the perceived hop flavor level.
	 * @return The flavor level.
	 */
	@Column(name="hop_flav_level")
	@Enumerated(EnumType.STRING)
	public IngrediantLevel getHopFlavorLevel() {
		return hopFlavorLevel;
	}
	
	/**
	 * Set the perceived hop flavor level.
	 * @param level The flavor level.
	 */
	public void setHopFlavorLevel(final IngrediantLevel level) {
		hopFlavorLevel = level;
	}
	
	/**
	 * Get whether the hop flavor was inappropriate.
	 * @return True if the flavor was inappropriate; otherwise false.
	 */
	@Column(name="hflav_innappr")
	public boolean getHopFlavorInappropriate() {
		return hopFlavorInapp;
	}
	
	/**
	 * Set whether the hop flavor was inappropriate.
	 * @param inapp True if the flavor was inappropriate; otherwise false.
	 */
	public void setHopFlavorInappropriate(final boolean inapp) {
		hopFlavorInapp = inapp;
	}
	
	/**
	 * Get the hop flavor comment.
	 * @return The flavor comment.
	 */
	@Column(name="hflav_comment")
	public String getHopFlavorComment() {
		return hopFlavorComment;
	}
	
	/**
	 * Set the hop flavor comment.
	 * @param comment The flavor comment.
	 */
	public void setHopFlavorComment(final String comment) {
		hopFlavorComment = comment;
	}
	
	/**
	 * Get the perceived bitterness flavor level.
	 * @return The flavor level.
	 */
	@Column(name="bit_flav_level")
	@Enumerated(EnumType.STRING)
	public IngrediantLevel getBitternessFlavorLevel() {
		return bitFlavorLevel;
	}
	
	/**
	 * Set the perceived bitterness flavor level.
	 * @param level The flavor level.
	 */
	public void setBitternessFlavorLevel(final IngrediantLevel level) {
		bitFlavorLevel = level;
	}
	
	/**
	 * Get whether the bitterness flavor was inappropriate.
	 * @return True if the flavor was inappropriate; otherwise false.
	 */
	@Column(name="bitflav_innappr")
	public boolean getBitternessFlavorInappropriate() {
		return bitFlavorInapp;
	}
	
	/**
	 * Set whether the bitterness flavor was inappropriate.
	 * @param inapp True if the flavor was inappropriate; otherwise false.
	 */
	public void setBitternessFlavorInappropriate(final boolean inapp) {
		bitFlavorInapp = inapp;
	}
	
	/**
	 * Get the bitterness flavor comment.
	 * @return The flavor comment.
	 */
	@Column(name="bitflav_comment")
	public String getBitternessFlavorComment() {
		return bitFlavorComment;
	}
	
	/**
	 * Set the bitterness flavor comment.
	 * @param comment The flavor comment.
	 */
	public void setBitternessFlavorComment(final String comment) {
		bitFlavorComment = comment;
	}
	
	/**
	 * Get the perceived fermentation flavor level.
	 * @return The flavor level.
	 */
	@Column(name="ferm_flav_level")
	@Enumerated(EnumType.STRING)
	public IngrediantLevel getFermentationFlavorLevel() {
		return fermFlavorLevel;
	}
	
	/**
	 * Set the perceived fermentation flavor level.
	 * @param level The flavor level.
	 */
	public void setFermentationFlavorLevel(final IngrediantLevel level) {
		fermFlavorLevel = level;
	}
	
	/**
	 * Get whether the fermentation flavor was inappropriate.
	 * @return True if the flavor was inappropriate; otherwise false.
	 */
	@Column(name="ferm_flav_inappr")
	public boolean getFermentationFlavorInappropriate() {
		return fermFlavorInapp;
	}
	
	/**
	 * Set whether the fermentation flavor was inappropriate.
	 * @param inapp True if the flavor was inappropriate; otherwise false.
	 */
	public void setFermentationFlavorInappropriate(final boolean inapp) {
		fermFlavorInapp = inapp;
	}
	
	/**
	 * Get the fermentation flavor comment.
	 * @return The flavor comment.
	 */
	@Column(name="ferm_flav_comment")
	public String getFermentationFlavorComment() {
		return fermFlavorComment;
	}
	
	/**
	 * Set the fermentation flavor comment.
	 * @param comment The flavor comment.
	 */
	public void setFermentationFlavorComment(final String comment) {
		fermFlavorComment = comment;
	}
	
	/**
	 * Get the flavor balance.
	 * @return The balance.
	 */
	@Column(name="flav_balance")
	@Enumerated(EnumType.STRING)
	public FlavorBalance getBalance() {
		return balance;
	}
	
	/**
	 * Set the flavor balance.
	 * @param balance The balance.
	 */
	public void setBalance(final FlavorBalance balance) {
		this.balance = balance;
	}
	
	/**
	 * Get whether the flavor balance was inappropriate.
	 * @return True if the balance was inappropriate; otherwise false.
	 */
	@Column(name="bal_inappr")
	public boolean getBalanceInappropriate() {
		return balInapp;
	}
	
	/**
	 * Set whether the flavor balance was inappropriate.
	 * @param inapp True if the balance was inappropriate; otherwise false.
	 */
	public void setBalanceInappropriate(final boolean inapp) {
		balInapp = inapp;
	}
	
	/**
	 * Get the flavor balance comment.
	 * @return The balance comment.
	 */
	@Column(name="flav_bal_comment")
	public String getFlavorBalanceComment() {
		return balComment;
	}
	
	/**
	 * Set the flavor balance comment.
	 * @param comment The balance comment.
	 */
	public void setFlavorBalanceComment(final String comment) {
		balComment = comment;
	}
	
	/**
	 * Get the flavor finish.
	 * @return The finish.
	 */
	@Column(name="beer_finish")
	@Enumerated(EnumType.STRING)
	public BeerFinish getFinish() {
		return finish;
	}
	
	/**
	 * Set the flavor finish.
	 * @param finish The finish.
	 */
	public void setFinish(final BeerFinish finish) {
		this.finish = finish;
	}
	
	/**
	 * Get whether the finish was inappropriate.
	 * @return True if the finish was inappropriate; otherwise false.
	 */
	@Column(name="finish_inappr")
	public boolean getFinishInappropriate() {
		return flavInapp;
	}
	
	/**
	 * Set whether the finish was inappropriate.
	 * @param inapp True if the finish was inappropriate; otherwise false.
	 */
	public void setFinishInappropriate(final boolean inapp) {
		flavInapp = inapp;
	}
	
	/**
	 * Get the finish comment.
	 * @return The finish comment.
	 */
	@Column(name="finish_comment")
	public String getFinishComment() {
		return finishComment;
	}
	
	/**
	 * Set the finish comment.
	 * @param comment The finish comment.
	 */
	public void setFinishComment(final String comment) {
		finishComment = comment;
	}
	
	/**
	 * Get the beer body.
	 * @return The body.
	 */
	@Column(name="beer_body")
	@Enumerated(EnumType.STRING)
	public BeerBody getBody() {
		return body;
	}
	
	/**
	 * Set the beer body.
	 * @param body The body.
	 */
	public void setBody(final BeerBody body) {
		this.body = body;
	}
	
	/**
	 * Get whether the body was inappropriate.
	 * @return True if the body was inappropriate; otherwise false.
	 */
	@Column(name="body_inappr")
	public boolean getBodyInappropriate() {
		return bodyInapp;
	}
	
	/**
	 * Set whether the body was inappropriate.
	 * @param inapp True if the body was inappropriate; otherwise false.
	 */
	public void setBodyInappropriate(final boolean inapp) {
		bodyInapp = inapp;
	}
	
	/**
	 * Get the perceived creaminess level.
	 * @return The creaminess level.
	 */
	@Column(name="cream_level")
	@Enumerated(EnumType.STRING)
	public IngrediantLevel getCreaminessLevel() {
		return creamLevel;
	}
	
	/**
	 * Set the perceived creaminess level.
	 * @param level The creaminess level.
	 */
	public void setCreaminessLevel(final IngrediantLevel level) {
		creamLevel = level;
	}
	
	/**
	 * Get whether the creaminess was inappropriate.
	 * @return True if the creaminess was inappropriate; otherwise false.
	 */
	@Column(name="cream_inappr")
	public boolean getCreaminessInappropriate() {
		return creamInapp;
	}
	
	/**
	 * Set whether the creaminess was inappropriate.
	 * @param inapp True if the creaminess was inappropriate; otherwise false.
	 */
	public void setCreaminessInappropriate(final boolean inapp) {
		creamInapp = inapp;
	}
	
	/**
	 * Get the perceived carbonation level.
	 * @return The carbonation level.
	 */
	@Column(name="carb_level")
	@Enumerated(EnumType.STRING)
	public IngrediantLevel getCarbonationLevel() {
		return carbLevel;
	}
	
	/**
	 * Set the perceived carbonation level.
	 * @param level The carbonation level.
	 */
	public void setCarbonationLevel(final IngrediantLevel level) {
		carbLevel = level;
	}
	
	/**
	 * Get whether the carbonation was inappropriate.
	 * @return True if the carbonation was inappropriate; otherwise false.
	 */
	@Column(name="carb_inappr")
	public boolean getCarbonationInappropriate() {
		return carbInapp;
	}
	
	/**
	 * Set whether the carbonation was inappropriate.
	 * @param inapp True if the carbonation was inappropriate; otherwise false.
	 */
	public void setCarbonationInappropriate(final boolean inapp) {
		carbInapp = inapp;
	}
	
	/**
	 * Get the perceived astringency level.
	 * @return The astringency level.
	 */
	@Column(name="astr_level")
	@Enumerated(EnumType.STRING)
	public IngrediantLevel getAstringencyLevel() {
		return astrLevel;
	}
	
	/**
	 * Set the perceived astringency level.
	 * @param level The astringency level.
	 */
	public void setAstringencyLevel(final IngrediantLevel level) {
		astrLevel = level;
	}
	
	/**
	 * Get whether the astringency level was inappropriate.
	 * @return True if the astringency level was inappropriate; otherwise false.
	 */
	@Column(name="astr_inappr")
	public boolean getAstringencyInappropriate() {
		return astrInapp;
	}
	
	/**
	 * Set whether the astringency level was inappropriate.
	 * @param inapp True if the astringency level was inappropriate; otherwise false.
	 */
	public void setAstringencyInappropriate(final boolean inapp) {
		astrInapp = inapp;
	}
	
	/**
	 * Get the perceived warmth level.
	 * @return The warmth level.
	 */
	@Column(name="warmth_level")
	@Enumerated(EnumType.STRING)
	public IngrediantLevel getWarmthLevel() {
		return warmthLevel;
	}
	
	/**
	 * Set the perceived warmth level.
	 * @param level The warmth level.
	 */
	public void setWarmthLevel(final IngrediantLevel level) {
		warmthLevel = level;
	}
	
	/**
	 * Get whether the warmth was inappropriate.
	 * @return True if the warmth was inappropriate; otherwise false.
	 */
	@Column(name="warmth_inappr")
	public boolean getWarmthInappropriate() {
		return warmthInapp;
	}
	
	/**
	 * Set whether the warmth was inappropriate.
	 * @param inapp True if the warmth was inappropriate; otherwise false.
	 */
	public void setWarmthInappropriate(final boolean inapp) {
		warmthInapp = inapp;
	}
	
	private int id, flightPos, flightCount, consensus, total, aromaScore, appScore, flavorScore, mfScore, overallScore,
		overallStyle, overallImpression;
	private float overallFlaws;
	private Integer bosPlace;
	private String compName, compLoc, bottleComment, feedback, aromaOther, appOther, appTexture, flavorOther, mfOther,
		maltAromaComment, hopAromaComment, fermAromaComment, maltFlavorComment, hopFlavorComment, bitFlavorComment, 
		fermFlavorComment, balComment, finishComment;
	private LocalDate compDate;
	private Judge judge;
	private boolean bos, bottleOk, maltAromaInapp, hopAromaInapp, fermAromaInapp, bColorInapp, hColorInapp, 
		clarityInapp, retInapp, maltFlavorInapp, hopFlavorInapp, bitFlavorInapp, fermFlavorInapp, balInapp, 
		flavInapp, bodyInapp, creamInapp, carbInapp, astrInapp, warmthInapp;
	private Map<Flaw, FlawLevel> flaws;
	private IngrediantLevel maltAromaLevel, hopAromaLevel, fermAromaLevel, maltFlavorLevel, hopFlavorLevel, 
		bitFlavorLevel, fermFlavorLevel, creamLevel, carbLevel, astrLevel, warmthLevel;
	private BeerColor bColor;
	private HeadColor hColor;
	private Clarity clarity;
	private HeadRetention retention;
	private FlavorBalance balance;
	private BeerFinish finish;
	private BeerBody body;
	private BrewSession session;
}
