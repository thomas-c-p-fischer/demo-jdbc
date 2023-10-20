package fr.diginamic.tpJdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.mariadb.jdbc.Driver;

public class TestConnexionJdbc {

	/**
	 * @param args
	 * @throws SQLException 
	 * @author thomas.fischer
	 */
	public static void main(String[] args) {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
			System.out.println(connection);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("Connection impossible vérifiez votre URL.");
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}	
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				throw new RuntimeException("Il n'y a pas de connection couramment établie.");
			}
		}
	}
}