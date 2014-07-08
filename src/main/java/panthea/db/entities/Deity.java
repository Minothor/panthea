package panthea.db.entities;

import javax.persistence.*;

import com.google.common.collect.BiMap;

//import 

// http://docs.jboss.org/hibernate/orm/4.2/quickstart/en-US/html/ch03.html
@Entity
@Table(name="DEITY")
public class Deity {
	
	@Id
	@GeneratedValue
	@Column(name="DEITY_ID")
	private long id;
	
	@Column(name="DEITY_NAME")
	private String name;
	
	@OneToOne
	@JoinColumn(referencedColumnName="altar_id")
	private Altar primaryAltar;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="type_id")
	private Type type;
	
	@Column(name="DEITY_POWER")
	private double power;
	
	@Column(name="DEITY_GENDER")
	private char gender;
	
	@Column(name="FOOD_HOLY")
	private String foodHoly;
	
	@Column(name="FOOD_FORBIDDEN")
	private String foodForbidden;
	
	@Column(name="MOB_HOLY")
	private String mobHoly;
	
	@Column(name="HOB_HATED")
	private String mobHated;

	@ManyToOne(optional=true)
	@JoinColumn(referencedColumnName="pantheon_id")
	private Pantheon pantheon;
	
	@ManyToOne(optional=true)
	@JoinColumn(referencedColumnName="deity_id")
	private Mood mood;
	
	private Deity(){}
	
	public Deity(String name, Type type, char gender, Pantheon pantheon)
	{
		setName(name);
		setType(type);
		setGender(gender);
		setPantheon(pantheon);
		setFoodHoly(getRandomEntry(type.getFoodHoly()));
		setFoodForbidden(getRandomEntry(type.getFoodForbidden()));
		setMobHoly(getRandomEntry(type.getMobHoly()));
		setMobHated(getRandomEntry(type.getMobHated()));
		
		
	}

	public String getFoodHoly() {
		return foodHoly;
	}

	public void setFoodHoly(String foodHoly) {
		this.foodHoly = foodHoly;
	}

	public String getFoodForbidden() {
		return foodForbidden;
	}

	public void setFoodForbidden(String foodForbidden) {
		this.foodForbidden = foodForbidden;
	}

	public String getMobHoly() {
		return mobHoly;
	}

	public void setMobHoly(String mobHoly) {
		this.mobHoly = mobHoly;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Pantheon getPantheon() {
		return pantheon;
	}

	public void setPantheon(Pantheon pantheon) {
		this.pantheon = pantheon;
	}
	
	public String getMobHated() {
		return mobHated;
	}

	public void setMobHated(String mobHated) {
		this.mobHated = mobHated;
	}
	
	public Mood getMood() {
		return mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}
	
	private static synchronized String getRandomEntry(String valueList)
	{
		String[] values = valueList.split(",");
		return values[(int)(Math.random()*(values.length-1))];
	}
	
}
