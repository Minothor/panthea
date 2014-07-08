package panthea.db.entities;

import javax.persistence.*;


@Entity
@Table(name="PANTHEON")
public class Pantheon {
	
	@Id
	@GeneratedValue
	@Column(name="PANTHEON_ID")
	private long pantheonId;

	@Column(name="NAME")
	private String name;
	
	@Transient
	private Deity ruler;
	
	@Transient
	private double collectivePower;
	
	private Pantheon(){}
	
	public Pantheon(String name)
	{
		setName(name);
	}
	
	
	
	public long getPantheonId() {
		return pantheonId;
	}

	public void setPantheonId(long pantheonId) {
		this.pantheonId = pantheonId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Deity getRuler()
{
		return ruler;
	}

	public void setRuler(Deity ruler)
	{
		this.ruler = ruler;
	}

	public double getCollectivePower()
	{
		return collectivePower;
	}

	public void setCollectivePower(double collectivePower) {
		this.collectivePower = collectivePower;
	}
	
}
