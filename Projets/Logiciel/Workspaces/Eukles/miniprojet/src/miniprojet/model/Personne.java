package miniprojet.model;

import java.util.ArrayList;
import java.util.List;

import miniprojet.abstractions.IObserveur;
import miniprojet.abstractions.ISujet;

public class Personne implements Comparable<Personne>, ISujet{
	
	private List<IObserveur> observeurs = new ArrayList<>();
	
	private String nom = "Aucun";
	private int age = 0;
	
	public Personne() {
		// TODO Auto-generated constructor stub
	}

	public Personne(String nom, int age) {
		super();
		this.nom = nom;
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Personne o) {
		
		boolean memeNom = nom.compareTo(o.getNom()) == 0;
		
		if(memeNom)
		{
			return age - o.getAge();
		}
		else
		{
			return nom.compareTo(o.getNom()) ;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		//Si this est l'objet pointé par la référence obj
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (age != other.age)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@Override
	public void ajoutesObserveur(IObserveur obs) {
		observeurs.add(obs);
	}

	@Override
	public void supprimesObserveur(IObserveur obs) {
		observeurs.remove(obs);
	}

	@Override
	public void supprimesTesObserveurs() {
		observeurs = new ArrayList<>();
	}

	@Override
	public void notifiesTesObserveurs() {
		
		for(IObserveur o : observeurs)
			o.update();
		
	}
	
	
	
}
