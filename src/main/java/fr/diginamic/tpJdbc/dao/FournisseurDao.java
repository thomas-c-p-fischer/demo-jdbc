/**
 * 
 */
package fr.diginamic.tpJdbc.dao;

import java.util.List;

import fr.diginamic.tpJdbc.entities.Fournisseur;

/**
 * 
 */
public interface FournisseurDao {
	List<Fournisseur> extraire();
	void insert(Fournisseur fournisseur);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Fournisseur fournisseur);
}