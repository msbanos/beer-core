package banos.ms.beer;

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
 * [Summary]		A BJCP substyle definition.
 */
@Entity
@Table(name="bjcp_substyle")
public class BJCPSubStyle {
	/**
	 * Default ctor.
	 */
	public BJCPSubStyle() { }
	
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
	
	@Column(name="bjcp_style_id")
	public int getStyleId() {
		return styleId;
	}
	
	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}
	
	@Column(name="substyle")
	public String getSubstyle() {
		return substyle;
	}
	
	public void setSubstyle(String substyle) {
		this.substyle = substyle;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	private int id;
	private int styleId;
	private String substyle;
	private String name;
}
