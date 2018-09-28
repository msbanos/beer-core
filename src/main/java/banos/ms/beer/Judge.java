package banos.ms.beer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * [Author]			Mike Banos
 * [Date]			06/07/2018
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		A beer judge.
 */
@Entity
@Table(name="judge")
public class Judge {
	/**
	 * Default ctor.
	 */
	public Judge() { }
	
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
	 * Get the first name.
	 * @return The first name.
	 */
	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the first name.
	 * @param name The first name.
	 */
	public void setFirstName(final String name) {
		this.firstName = name;
	}
	/**
	 * Get the last name.
	 * @return The last name.
	 */
	@Column(name="last_name")
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set the last name.
	 * @param name The last name.
	 */
	public void setLastName(final String name) {
		this.lastName = name;
	}
	
	/**
	 * Get the email address.
	 * @return The email address.
	 */
	@Column(name="email")
	public String getEmailAddress() {
		return email;
	}

	/**
	 * Set the email address.
	 * @param email The email address.
	 */
	public void setEmailAddress(final String email) {
		this.email = email;
	}
	
	/**
	 * Get the BJCP number.
	 * @return The BJCP number.
	 */
	@Column(name="bjcp_id")
	public String getBJCPNumber() {
		return bjcpId;
	}

	/**
	 * Set the BJCP number.
	 * @param number The BJCP number.
	 */
	public void setBJCPNumber(final String number) {
		this.bjcpId = number;
	}
	
	/**
	 * Get the cicerone rank.
	 * @return The cicerone rank.
	 */
	@Column(name="cicerone_rank")
	public String getCiceroneRank() {
		return ciceroneRank;
	}

	/**
	 * Set the cicerone rank.
	 * @param rank The cicerone rank.
	 */
	public void setCiceroneRank(final String rank) {
		this.ciceroneRank = rank;
	}

	/**
	 * Get the brewery name.
	 * @return The brewery name.
	 */
	@Column(name="brewery")
	public String getBrewerName() {
		return brewery;
	}

	/**
	 * Set the brewery name.
	 * @param name The brewery name.
	 */
	public void setBrewerName(final String name) {
		this.brewery = name;
	}
	
	/**
	 * Get the industry description.
	 * @return The industry description.
	 */
	@Column(name="industry")
	public String getIndustryDescription() {
		return industry;
	}

	/**
	 * Set the industry description.
	 * @param desc The industry description.
	 */
	public void setIndustryDescription(final String desc) {
		this.industry = desc;
	}
	
	/**
	 * Get the years of judging experience.
	 * @return The years judging.
	 */
	@Column(name="judging_years")
	public String getYearsJudging() {
		return judgingYears;
	}

	/**
	 * Set the years of judging experience.
	 * @param years The years judging.
	 */
	public void setYearsJudging(final String years) {
		this.judgingYears = years;
	}
	
	private int id;
	private String firstName, lastName, email, bjcpId, ciceroneRank, brewery, industry, judgingYears;
}
