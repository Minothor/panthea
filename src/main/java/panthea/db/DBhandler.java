package panthea.db;

import java.sql.*;

import javax.sql.*;

import panthea.db.entities.*;

public class DBhandler {
	
	// https://my.vertabelo.com
	
	static void connectDB() throws Exception
	{
		
		// http://www.programmingforfuture.com/2011/02/in-process-mode-of-hsqldb-in-web.html
		
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		
		Connection dbCon = DriverManager.getConnection("jdbc:hsqldb:pantheonDB/data","hlidskjalf","");
		System.out.println(dbCon!=null);
		
	}
	
	
	public static void main(String[] args) {
		try {
			connectDB();
			System.err.println(Deity.class.getSimpleName());
			Field classFields[] = Deity.class.getDeclaredFields();
			System.err.println(Deity.class.getDeclaredFields());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
