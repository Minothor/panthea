package panthea.db.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="MOOD")
public class Mood  implements Serializable{

@Id
@ManyToOne
@JoinColumn(name="deity_id")
private Deity deityID;

@OneToOne
@JoinColumn(referencedColumnName="deity_id")
private Deity targetDeity;

@Column(name="DIRECTION")
private float direction;

@Column(name="MAGNITUDE")
private float magnitude;

private Mood(){}

public Mood(Deity deityID, Deity targetDeity, float direction, float magnitude)
	{
		setDeityID(deityID);
		setTargetDeity(targetDeity);
		setDirection(direction);
		setMagnitude(magnitude);
	}

public Mood(Deity origin, float direction, float magnitude)
	{
		this(origin,null,direction,magnitude);
	}

public Deity getDeityID() {
	return deityID;
}

public void setDeityID (Deity deityID) {
	this.deityID = deityID;
}

public Deity getTargetDeity() {
	return targetDeity;
}

public void setTargetDeity(Deity targetDeity) {
	this.targetDeity = targetDeity;
}

public float getDirection() {
	return direction;
}

public void setDirection(float direction) {
	this.direction = direction;
}

public float getMagnitude() {
	return magnitude;
}

public void setMagnitude(float magnitude) {
	this.magnitude = magnitude;
}
}
