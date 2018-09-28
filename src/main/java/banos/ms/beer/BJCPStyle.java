package banos.ms.beer;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * [Author]			Mike Banos
 * [Date]			12/14/2017
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		A BJCP style definition.
 */
@Entity
@Table(name="bjcp_style")
public class BJCPStyle {
	/**
	 * Default ctor.
	 */
	public BJCPStyle() { }
	
	@Column(name="year")
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="style")
	public int getStyleId() {
		return styleId;
	}
	
	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="styleId")
	public List<BJCPSubStyle> getSubstyles() {
		return substyles;
	}
	
	public void setSubstyles(List<BJCPSubStyle> substyles) {
		this.substyles = substyles;
	}
	
	private int year;
	private int id;
	private int styleId;
	private String name;
	private List<BJCPSubStyle> substyles;
}
