/**
 * 
 */
package fr.diginamic.tpJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.mariadb.jdbc.Driver;

import fr.diginamic.tpJdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.tpJdbc.entities.Fournisseur;

/**
 * 
 */
public class TestDaoJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Fournisseur fourni = new Fournisseur(4, "France de matériaux");
		
		Connection conn = null;
		try {
			DriverManager.registerDriver(new Driver());
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
			FournisseurDaoJdbc fourniDaoJdbc = new FournisseurDaoJdbc(conn);
			fourniDaoJdbc.insert(fourni);
			System.out.println(fourniDaoJdbc.extraire());
			fourniDaoJdbc.update("France de matériaux", "France matériaux");
			System.out.println(fourniDaoJdbc.extraire());
			fourniDaoJdbc.delete(fourni);
			System.out.println(fourniDaoJdbc.extraire());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("Il n'y a pas de connection couramment établie.");
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}	
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				throw new RuntimeException("Il n'y a pas de connection couramment établie.");
			}
		}			
	}
}