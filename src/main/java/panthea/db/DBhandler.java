package panthea.db;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;
import javax.sql.*;

import net.minecraft.init.Blocks;
import panthea.db.entities.*;

public class DBhandler {
	static Connection dbCon;
	
	// https://my.vertabelo.com
	
	//for setting player deity:
	//http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/modification-development/1434857-
	
	public static void connectDB() throws Exception
	{
		
		// http://www.programmingforfuture.com/2011/02/in-process-mode-of-hsqldb-in-web.html
		
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		
		dbCon = DriverManager.getConnection("jdbc:hsqldb:pantheonDB/data","hlidskjalf","");
		System.out.println(dbCon!=null);
		
	}
	
	public static void disconnectDB() {
		try {
			dbCon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pantheaPersist",loadProperties("localhost:3306/pantheondb","hlidskjalf","",true,"create"));
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Type earth = new Type("Earth", "Minecraft:itemBread,Minecraft:itemCarrot,Minecraft:ItemBakedPotato", "Minecraft:itemRawBeef,Minecraft:itemSteak,Minecraft:itemRawMutton,Minecraft:itemCookedMutton,Minecraft:itemRawPorkchop,Minecraft:itemcookedPorkChop", "entityCow,entitySheep,entityHorse,entityPig", "entityBlaze,entitySkeleton,entityWither", null, null);
		em.persist(earth);
		earth.setTypeLiked(earth);
		Deity gaia = new Deity("Gaia",earth,'F',null);
		em.persist(gaia);
		Altar gaia1 = new Altar(24,1,10,gaia,Blocks.log);
		em.persist(gaia1);
		gaia.setPrimaryAltar(gaia1);
		Mood neutralMood = new Mood(gaia, null,0.5F,0.5F,0.5F);
		em.persist(neutralMood);
		gaia.setMood(neutralMood);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	private static Map loadProperties(String url, String username, String pass, boolean mySQL,String dbOp) {
		
		String driver = "";
		
		if(mySQL)
		{
			url = "mysql://"+url;
			driver ="com.mysql.jdbc.Driver";
		} else {
			url = "hsqldb:pantheonDB/data";
			driver ="org.hsqldb.jdbc.JDBCDriver";
			username = "hlidskjalf";
			pass = "";
		}
		
		
			
		Map<String,String> emfProperties = new HashMap<String,String>();
		emfProperties.put("hibernate.archive.autodetection", "class");
		emfProperties.put("hibernate.connection.driver_class",driver);
		emfProperties.put("hibernate.connection.url","jdbc:"+url);
		emfProperties.put("hibernate.connection.username", username);
		emfProperties.put("hibernate.connection.password",pass);
		emfProperties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		emfProperties.put("hibernate.hbm2ddl.auto",dbOp);
		
		return emfProperties;
	}

}
