package panthea.db.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @author Minothor
 * @version 1.0.0
 * Stores an "emotional state" for a deity as a floating point value of Dopamine, Noradrenaline and Serotonin values.
 * Inspired by the Lövheim cube of emotion, used to map emotional response by resultant endocrinology.
 * Default state of "Neutral" is defined by the midpoint [0.5F,0.5F,0.5F]. 
 *
 */

@Entity
@Table(name="MOOD")
public class Mood  implements Serializable
{

	@Id
	@ManyToOne
	@JoinColumn(name="deity_id")
	private Deity deityID;

	@OneToOne
	@JoinColumn(referencedColumnName="deity_id")
	private Deity targetDeity;

	@Column(name="DOPAMINE")
	private float dopamine=0.5F;

	@Column(name="NORADRENALINE")
	private float noradrenaline=0.5F;

	@Column(name="SEROTONIN")
	private float serotonin=0.5F;

	private Mood(){}

	public Mood(Deity deityID, Deity targetDeity, float dopamine, float noradrenaline, float serotonin)
	{
		setDeityID(deityID);
		setTargetDeity(targetDeity);
		setDopamine(dopamine);
		setNoradrenaline(noradrenaline);
		setSerotonin(serotonin);
	}

	public Mood(Deity origin, float dopamine, float noradrenaline, float serotonin)
	{
		this(origin,null,dopamine,noradrenaline,serotonin);
	}

	public Deity getDeityID()
	{
		return deityID;
	}

	public void setDeityID (Deity deityID)
	{
		this.deityID = deityID;
	}

	public Deity getTargetDeity()
	{
		return targetDeity;
	}

	public void setTargetDeity(Deity targetDeity)
	{
		this.targetDeity = targetDeity;
	}

	public float getDopamine()
	{
		return dopamine;
	}

	public void setDopamine(float dopamine)
	{
		this.dopamine = dopamine;
	}

	public float getNoradrenaline()
	{
		return noradrenaline;
	}

	public void setNoradrenaline(float noradrenaline)
	{
		this.noradrenaline = noradrenaline;
	}

	public float getSerotonin()
	{
		return serotonin;
	}

	public void setSerotonin(float serotonin)
	{
		this.serotonin = serotonin;
	}
}