package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test
	void createLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
		
	}

	@Test
	void addEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", "09/11/2020", null); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	
	@Test
	void getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		ligue.getNom();	
		assertEquals("Fléchettes", ligue.getNom());
	}
	
	
	@Test
	void setNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		ligue.getNom();
		String nom = "P�tanque";
		ligue.setNom(nom);
		assertFalse(ligue.getNom().contains("Fléchettes"));
		assertEquals("P�tanque", ligue.getNom());
		
	}
	
	@Test
	void removeLigue() throws SauvegardeImpossible
	{
		Ligue ligue = this.gestionPersonnel.addLigue("Fléchettes"); 
		assertEquals("Fléchettes", ligue.getNom());
		ligue.remove();
		assertTrue(gestionPersonnel.getLigues().isEmpty());
	}
	
	
	@Test
	void removeEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = this.gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", "09/11/2020", null); 
		assertTrue(ligue.getEmployes().contains(employe));
		ligue.setAdministrateur(employe);
		employe.remove();
		assertFalse(ligue.getEmployes().contains(employe));
		assertEquals(this.gestionPersonnel.getRoot(), ligue.getAdministrateur());
	}
	
	@Test
	void checkPassword() throws SauvegardeImpossible
	{
		Ligue ligue = this.gestionPersonnel.addLigue("Fléchettes"); 
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", "09/11/2020", null);
		assertTrue(employe.checkPassword("azerty"));
		assertFalse(employe.checkPassword(null));
		assertFalse(employe.checkPassword("azertyu"));
	}
	
	@Test
	void setAdmin() throws SauvegardeImpossible
	{
		Ligue ligue = this.gestionPersonnel.addLigue("Fléchettes"); 
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", "09/11/2020", null);
		ligue.setAdministrateur(employe);
		assertTrue(employe.estAdmin(ligue));
	}
	
}
