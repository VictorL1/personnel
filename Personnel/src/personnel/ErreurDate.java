package personnel;

public class ErreurDate extends Exception{
	public ErreurDate() {
		System.out.println("Erreur ! Votre date d'arrivee est apres votre date de depart !");
	}

}
