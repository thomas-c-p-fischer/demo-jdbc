/**
 * 
 */
package fr.diginamic.tpJdbc.entities;

/**
 * 
 */
public class Fournisseur {
	
	/** ID */
	private int ID;
	/** Nom */
	private String Nom;
	
	
	/** Constructeur
	 * @param iD
	 * @param nom
	 */
	public Fournisseur(int iD, String nom) {
		super();
		ID = iD;
		Nom = nom;
	}

	@Override
	public String toString() {
		return "Fournisseur: -ID: " + ID + ""
				+ " -Nom: " + Nom + ".";
	}

	/** Getter
	 * @return
	 */
	public int getID() {
		return ID;
	}

	/** Setter
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/** Getter
	 * @return
	 */
	public String getNom() {
		return Nom;
	}

	/** Setter
	 * @param nom
	 */
	public void setNom(String nom) {
		Nom = nom;
	}
	
}