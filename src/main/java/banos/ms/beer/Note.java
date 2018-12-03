package banos.ms.beer;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * [Author]			Mike Banos
 * [Date]			11/17/2018
 * [Licensing ]		All works licensed by the Lesser GPL
 * 		@link http://www.gnu.org/licenses/lgpl.html
 * [Summary]		A note.
 */
@Entity
@Table(name="notes")
public class Note {
	/**
	 * Default ctor.
	 */
	public Note() { }
	
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
	 * Get the note text.
	 * @return The text
	 */
	@Column(name="note")
	public String getText() {
		return text;
	}

	/**
	 * Set the note text.
	 * @param text The text.
	 */
	public void setText(final String text) {
		this.text = text;
	}

	/**
	 * Get the note type.
	 * @return The type.
	 */
	@Column(name="note_type")
	@Enumerated(EnumType.STRING)
	public NoteType getType() {
		return type;
	}

	/**
	 * Set the note type.
	 * @param type The type.
	 */
	public void setType(final NoteType type) {
		this.type = type;
	}
	
	/**
	 * Get the related entity id.
	 * @return The entity id.
	 */
	@Column(name="entity_id")
	public int getEntityId() {
		return eid;
	}
	
	/**
	 * Set the related entity id.
	 * @param eid The entity id.
	 */
	public void setEntityId(final int eid) {
		this.eid = eid;
	}
	
	/**
	 * Get the date.
	 * @return The date.
	 */
	@Column(name="date")
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Set the date.
	 * @param date The date.
	 */
	public void setDate(final LocalDate date) {
		this.date = date;
	}

	/**
	 * Get the note entity type.
	 * @return The type.
	 */
	@Column(name="entity_type")
	public NoteEntity getEntityType() {
		return eType;
	}

	/**
	 * Set the entity type.
	 * @param eType The type.
	 */
	public void setEntityType(NoteEntity eType) {
		this.eType = eType;
	}

	private int id, eid;
	String text;
	NoteType type;
	private LocalDate date;
	NoteEntity eType;
}
