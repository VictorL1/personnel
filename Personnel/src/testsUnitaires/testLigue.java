package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test
	void createLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		assertEquals("Flechettes", ligue.getNom());
		
	}

	@Test
	void addEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "azerty",  LocalDate.parse("2020-09-11"),  LocalDate.parse("2020-12-09")); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	
	@Test
	void getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		ligue.getNom();	
		assertEquals("Flechettes", ligue.getNom());
	}
	
	
	@Test
	void setNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		ligue.getNom();
		String nom = "Pétanque";
		ligue.setNom(nom);
		assertFalse(ligue.getNom().contains("Flechettes"));
		assertEquals("Pétanque", ligue.getNom());
		
	}
	
	@Test
	void removeLigue() throws SauvegardeImpossible
	{
		Ligue ligue = this.gestionPersonnel.addLigue("Flechettes"); 
		assertEquals("Flechettes", ligue.getNom());
		ligue.remove();
		assertTrue(gestionPersonnel.getLigues().isEmpty());
	}
	
	
	@Test
	void removeEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = this.gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "azerty",  LocalDate.parse("09/11/2020"), null); 
		assertTrue(ligue.getEmployes().contains(employe));
		ligue.setAdministrateur(employe);
		employe.remove();
		assertFalse(ligue.getEmployes().contains(employe));
		assertEquals(this.gestionPersonnel.getRoot(), ligue.getAdministrateur());
	}
	
	@Test
	void checkPassword() throws SauvegardeImpossible
	{
		Ligue ligue = this.gestionPersonnel.addLigue("Flechettes"); 
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "azerty", LocalDate.parse("2020-09-10") , null);
		assertTrue(employe.checkPassword("azerty"));
		assertFalse(employe.checkPassword(null));
		assertFalse(employe.checkPassword("azertyu"));
	}
	
	@Test
	void setAdmin() throws SauvegardeImpossible
	{
		Ligue ligue = this.gestionPersonnel.addLigue("Flechettes"); 
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "azerty",  LocalDate.parse("09/11/2020"), null);
		ligue.setAdministrateur(employe);
		assertTrue(employe.estAdmin(ligue));
	}
	
}
