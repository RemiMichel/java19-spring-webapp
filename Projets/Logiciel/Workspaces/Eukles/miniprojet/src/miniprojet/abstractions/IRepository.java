package miniprojet.abstractions;

import java.util.List;

public interface IRepository<T> extends IObserveur{

	/**
	 * @param objet l'objet � ajouter au d�p�t
	 */
	void create(T objet);
	
	/**
	 * @param id identifiant de l'objet � retourner
	 * @return objet � retourner
	 */
	T read(String id);
	
	/**
	 * @param id id de l'objet � modifier au d�p�t
	 * @param objet l'objet � modifier au d�p�t
	 */
	void update(String id, T objet);
	
	/**
	 * @param objet l'objet � supprimer au d�p�t
	 */
	void delete(T objet);
	
	/**
	 * @return retourne l'image de l'interieur du d�p�t, sous forme de liste
	 */
	List<T> list();
	
}
