package panthea.db.entities;

import javax.persistence.*;

@Entity
@Table(name="DEITY_TYPE")
public class Type {
	
	@Id
	@GeneratedValue
	@Column(name="TYPE_ID")
	private long id;
	
	@Column(name="TYPE_NAME")
	private String name;
	
	@Column(name="FOOD_HOLY")
	private String foodHoly;
	
	@Column(name="FOOD_FORBIDDEN")
	private String foodForbidden;
	
	@Column(name="MOB_HOLY")
	private String mobHoly;
	
	@Column(name="MOB_HATED")
	private String mobHated;
	
	@ManyToOne(optional=true)
	@JoinColumn(referencedColumnName="type_id")
	private Type typeLiked;
	
	@ManyToOne(optional=true)
	@JoinColumn(referencedColumnName="type_id")
	private Type typeHated;
	
	
	private Type(){}
	
	public Type(String name, String foodHoly, String foodForbidden, String mobHoly, String mobHated, Type typeLiked, Type typeHated) {
		setName(name);
		setFoodHoly(foodHoly);
		setFoodForbidden(foodForbidden);
		setMobHoly(mobHoly);
		setMobHated(mobHated);
		setTypeLiked(typeLiked);
		setTypeHated(typeHated);
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

	public String getMobHated() {
		return mobHated;
	}

	public void setMobHated(String mobHated) {
		this.mobHated = mobHated;
	}

	public Type getTypeLiked() {
		return typeLiked;
	}

	public void setTypeLiked(Type typeLiked) {
		this.typeLiked = typeLiked;
	}

	public Type getTypeHated() {
		return typeHated;
	}

	public void setTypeHated(Type typeHated) {
		this.typeHated = typeHated;
	}
	
	
	

}
