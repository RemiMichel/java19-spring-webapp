package miniprojet.abstractions;

public interface ISujet {

	void ajoutesObserveur(IObserveur obs);
	void supprimesObserveur(IObserveur obs);
	void supprimesTesObserveurs();
	void notifiesTesObserveurs();
	
}
