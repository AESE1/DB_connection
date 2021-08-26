package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCconnection {

	static final String DB_URL = "jdbc:mysql://latestdb.cqmp4iplbfwr.eu-west-1.rds.amazonaws.com/AntonsGameShop";
	private  String user;
	private String pass;
	
	static Connection conn = null;
	static Statement stmt = null;
	
	public JDBCconnection(String user, String pass) {
		this.user=user;
		this.pass=pass;
		try {
			conn = DriverManager.getConnection(DB_URL, user, pass);
			stmt = conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public void exUpdate(String query) {
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
					e.printStackTrace();
					
				}
			}
	public ResultSet exQuery(String query) {
		ResultSet response = null;
		try {
			response = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
}
