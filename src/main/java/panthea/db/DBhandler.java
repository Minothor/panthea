package panthea.db;

import java.sql.*;

import javax.persistence.*;
import javax.sql.*;

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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Type earth = new Type("Earth", "Minecraft:itemBread", "Minecraft:itemSteak", "Sheep", "Blaze", null, null);
		em.persist(earth);
		earth.setTypeLiked(earth);
		Deity gaia = new Deity("Gaia",earth,'F',null);
		em.persist(gaia);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
