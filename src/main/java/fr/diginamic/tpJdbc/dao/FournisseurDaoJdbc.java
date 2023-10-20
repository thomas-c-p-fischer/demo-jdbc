/**
 * 
 */
package fr.diginamic.tpJdbc.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.tpJdbc.entities.Fournisseur;

/**
 * 
 */
public class FournisseurDaoJdbc implements FournisseurDao {
	
	/** connection */
	private Connection connection;
	
	/** Constructeur
	 * @param connection
	 */
	public FournisseurDaoJdbc(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public List<Fournisseur> extraire() {
		ArrayList<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
		Statement stt = null;
		ResultSet curseur = null;
		try {
			stt = connection.createStatement();
			curseur = stt.executeQuery("SELECT * FROM FOURNISSEUR");
			while(curseur.next()) {
				Integer id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");
				Fournisseur fournisseur = new Fournisseur(id, nom);
				fournisseurs.add(fournisseur);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("Connection impossible vérifiez votre URL ou votre requête.");
		} finally {
			try {
				if(curseur != null) {
					curseur.close();
				}
				if(stt != null)	{
					stt.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				throw new RuntimeException("Il n'y a pas de requêtes ou de connection couramment établie.");
			}
		}
		return fournisseurs;
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		Statement stt = null;
		try {
			stt = connection.createStatement();
			int requeteInsert = stt.executeUpdate("INSERT INTO FOURNISSEUR (ID, NOM) VALUES ("
												+ fournisseur.getID() + ", '" + fournisseur.getNom() + "')");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("Connection impossible vérifiez votre URL ou votre requête.");
		} finally {
			try {
				if(stt != null) {
					stt.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				throw new RuntimeException("Il n'y a pas de connection couramment établie.");
			}
		}
	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		Statement stt = null;
		try {
			stt = connection.createStatement();
			int requeteInsert = stt.executeUpdate("UPDATE FOURNISSEUR SET NOM='" + nouveauNom + "' WHERE NOM='" + ancienNom + "'");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("Connection impossible vérifiez votre URL ou votre requête.");
		} finally {
			try {
				if(stt != null) {
					stt.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				throw new RuntimeException("Il n'y a pas de connection couramment établie.");
			}
		}
		return 0;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		Statement stt = null;
		try {
			stt = connection.createStatement();
			int requeteInsert = stt.executeUpdate("DELETE FROM FOURNISSEUR WHERE ID=" + fournisseur.getID());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("Connection impossible vérifiez votre URL ou votre requête.");
		} finally {
			try {
				if(stt != null) {
					stt.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				throw new RuntimeException("Il n'y a pas de connection couramment établie.");
			}
		}
		return false;
	}	
}