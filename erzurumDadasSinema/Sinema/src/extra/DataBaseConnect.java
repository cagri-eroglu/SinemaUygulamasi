package extra;
import java.sql.*;
public class DataBaseConnect {
	Connection c = null;
	
	public DataBaseConnect() {}

	public Connection dataBaseConnection() {
		try {
			this.c = DriverManager.getConnection("jdbc:mysql://localhost:3335/sinema?user=root&password = 1234");
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	
}
