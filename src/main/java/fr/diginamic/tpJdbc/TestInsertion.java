/**
 * 
 */
package fr.diginamic.tpJdbc;

import java.sql.Statement;

import org.mariadb.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */
public class TestInsertion {

	/**
	 * @param args
	 * @throws SQLException
	 * @author thomas.fischer 
	 */
	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		try {
			DriverManager.registerDriver(new Driver());
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
			Statement stt = con.createStatement();
			int requete = stt.executeUpdate("INSERT INTO FOURNISSEUR (ID, NOM) VALUES (4, 'GIGA')");
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			throw new SQLException();
		} finally {
			try {
				if(con != null) {
					con.close();
				}	
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				throw new SQLException();
			}
		}
	}
}