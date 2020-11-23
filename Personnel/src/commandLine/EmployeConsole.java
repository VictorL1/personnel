package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.time.LocalDate;

import commandLineMenus.ListOption;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import personnel.Employe;

public class EmployeConsole 
{
	private Option afficher(final Employe employe)
	{
		return new Option("Afficher l'employe", "l", () -> {System.out.println(employe);});
	}

	ListOption<Employe> editerEmploye()
	{
		return (employe) -> editerEmploye(employe);		
	}

	Option editerEmploye(Employe employe)
	{
			Menu menu = new Menu("Gerer le compte " + employe.getNom(), "c");
			menu.add(afficher(employe));
			menu.add(changerNom(employe));
			menu.add(changerPrenom(employe));
			menu.add(changerMail(employe));
			menu.add(changerPassword(employe));
			menu.add(changerDateD�part(employe));
			menu.add(changerDateArriv�e(employe));
			menu.addBack("q");
			return menu;
	}

	private Option changerNom(final Employe employe)
	{
		return new Option("Changer le nom", "n", () -> {employe.setNom(getString("Nouveau nom : "));});
	}
	
	private Option changerPrenom(final Employe employe)
	{
		return new Option("Changer le prenom", "p", () -> {employe.setPrenom(getString("Nouveau prenom : "));});
	}
	
	private Option changerMail(final Employe employe)
	{
		return new Option("Changer le mail", "e", () -> {employe.setMail(getString("Nouveau mail : "));});
	}
	
	private Option changerPassword(final Employe employe)
	{
		return new Option("Changer le password", "x", () -> {employe.setPassword(getString("Nouveau password : "));});
	}
	private Option changerDateD�part(final Employe employe)
	{
		return new Option("Changer la date de d�part", "dd", () -> 
		{System.out.println(employe.getdatedepart());
		employe.setdatedepart(LocalDate.parse(getString("Nouvelle date : ")));});
	}
	private Option changerDateArriv�e(final Employe employe)
	{
		return new Option("Changer la date d'arriv�e", "da", () -> 
		{System.out.println(employe.getdatearrivee());
		employe.setdatearrivee(LocalDate.parse(getString("Nouvelle date : ")));});
	}

}
