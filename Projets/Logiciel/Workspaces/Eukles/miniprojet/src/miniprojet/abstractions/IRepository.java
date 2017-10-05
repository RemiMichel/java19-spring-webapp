package miniprojet.abstractions;

import java.util.List;

public interface IRepository<T> extends IObserveur{

	/**
	 * @param objet l'objet à ajouter au dépôt
	 */
	void create(T objet);
	
	/**
	 * @param id identifiant de l'objet à retourner
	 * @return objet à retourner
	 */
	T read(String id);
	
	/**
	 * @param id id de l'objet à modifier au dépôt
	 * @param objet l'objet à modifier au dépôt
	 */
	void update(String id, T objet);
	
	/**
	 * @param objet l'objet à supprimer au dépôt
	 */
	void delete(T objet);
	
	/**
	 * @return retourne l'image de l'interieur du dépôt, sous forme de liste
	 */
	List<T> list();
	
}
