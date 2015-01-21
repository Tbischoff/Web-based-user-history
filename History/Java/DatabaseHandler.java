import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

/**
 * simple database handling routine
 * 
 * @author tbischoff, lkastler
 *
 */
public class DatabaseHandler {
	// simple variables
	final String hostname = "localhost";
	final String port = "3306";
	final String dbname = "dbName";
	final String user = "dbUser";
	final String password = "DbPassword";
	
	// singleton
	private static DatabaseHandler instance = null;
	
	private Connection connection;
	
	/**
	 * returns the instance of the database connection.
	 * @return the instance of the database connection.
	 */
	public static DatabaseHandler getInstance() {
		if(instance == null) {
			instance = new DatabaseHandler();
		}
		return instance;
	}
	
	private DatabaseHandler() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + dbname, user, password);
			
			
		} catch (Exception e) {
			System.err.println("Not able to load driver.");
		}
	}
	
	public Connection getConnection() throws SQLException {
		return connection;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		connection.close();
	}
	
	
}
