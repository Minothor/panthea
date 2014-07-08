package panthea.db.entities;

import javax.persistence.*;

import net.minecraft.block.Block;

@Entity
@Table(name="ALTARS")
public class Altar {
	
	@Id
	@Column(name="ALTAR_ID")
	private long altarID;
	
	@Transient
	private int[] locationArray = new int[3];
	
	@Column(name= "LOCATION")
	private String locationString;
	
	@ManyToOne(optional=true)
	@JoinColumn(referencedColumnName="deity_id")
	private Deity deity;
	
	private Altar() {}
	
	public Altar(int x, int y, int z, Deity deity, Block block)
	{
		
	}

	public long getAltarID()
	{
		return altarID;
	}

	public void setAltarID(long altarID)
	{
		this.altarID = altarID;
	}

	public String getLocationString()
	{
		return locationString;
	}

	public void setLocationString(String locationString)
	{
		this.locationString = locationString;
	}

	public Deity getDeity()
	{
		return deity;
	}

	public void setDeity(Deity deity)
	{
		this.deity = deity;
	}
	
	public String getLocation()
	{
		String response = locToString();
		return response;
	}
	
	public void setLocation(int x, int y, int z)
	{
		locationArray= new int[]{x,y,z};
		locationString = locToString();
	}
	
	private String locToString()
	{
		String response = ""+locationArray[0];
		for (int i=1; i<locationArray.length;i++) {
			response+=(","+locationArray[i]);
		}
		return response;
	}
	
}
