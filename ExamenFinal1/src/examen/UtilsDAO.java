//nota 10 -> de verificat

package examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilsDAO {
	private static Connection c;

	public static void setConnection () {
		try {
			Class.forName("org.sqlite.jdbc");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection () {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static String selectData() throws SQLException {
		StringBuilder retval = new StringBuilder();
		String sql = "SELECT * FROM cars";
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String separator = System.getProperty("line.separator");

		while (rs.next()) {
			retval.append(
					String.format("ID: %d | MODEL: %s | PRICE: %.2f | WEIGHT: %.2f" + separator, rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4))
					);
		}
		return retval.toString(); //nu uita de return
	}
}
