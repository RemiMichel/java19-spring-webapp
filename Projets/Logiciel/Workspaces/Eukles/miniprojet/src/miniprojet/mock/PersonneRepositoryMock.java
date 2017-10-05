package miniprojet.mock;

import java.util.List;

import miniprojet.abstractions.IRepository;
import miniprojet.model.Personne;

/**
 * @author R�mi Michel
 * 
 * Cette classe va simmuler une impl�mentation CRUD
 * 
 * la m�thod qui nous int�resse est la m�thode read()
 * cette metode va retourn� une r�f�rence de l'objet Pesonne stock� en local
 * 
 * Son r�le est de gerer la persistance des objet java
 *
 */
public class PersonneRepositoryMock implements IRepository<Personne>{

	private Personne personne = new Personne("Jean", 33);
	
	@Override
	public void create(Personne objet) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Personne objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Personne> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "'Je suis un d�p�t de personne simul�, qui contient une personne.\nCette personne se nomme "+personne.getNom()+", et elle a "+personne.getAge()+" an(s).'";
	}

	/* (non-Javadoc)
	 * @see abstractions.IRepository#read(java.lang.String)
	 * @param id inutile dans ce cas
	 * @return la personne du d�p�t
	 */
	@Override
	public Personne read(String id) {
		// TODO Auto-generated method stub
		return this.personne;
	}

	@Override
	public void update(String id, Personne objet) {
		
		System.out.println("RepositoryMock : Modification dans le syst�me de persistance de l'application, via l'interface CRUD.");
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("RepositoryMock : le sujet a chang� !");
		System.out.println(toString());
		System.out.println(" : RepositoryMock");
	}
	
}
