package jdbcConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Runner {

	public static void main(String[] args) {
		JDBCconnection dbCon = new JDBCconnection("admin","Surveyor2");
//		String query = "INSERT INTO customer VALUES(2, 'jon jonboy','no@no.com',53)";
//		dbCon.exUpdate(query);
		String query = "SELECT * FROM customer";
		ResultSet result = dbCon.exQuery(query);
		try {
			while(result.next()) {
				int ID = result.getInt("ID");
				String name = result.getString("name");
				String email = result.getNString("email");
				int houseNo = result.getInt("houseNo");
				System.out.println("The customer ID: " + ID+ " " +name+ " " +email+ "" +houseNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
