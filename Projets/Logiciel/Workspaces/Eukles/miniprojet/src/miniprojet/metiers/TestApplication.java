package miniprojet.metiers;

import javafx.stage.Stage;
import miniprojet.abstractions.IRepository;
import miniprojet.abstractions.IViewManager;
import miniprojet.mock.PersonneRepositoryMock;
import miniprojet.model.Personne;

/**
 * @author Rémi Michel
 * 
 * Classe principale de l'application
 * 
 * contient un viewManager et un repository.
 * 
 * /!\ ne pas oublier d'initialiser tous les attributs de cette classe au lancement de l'app /!\
 *
 */
public class TestApplication{

	private static TestApplication instance;
	
	private IRepository<?> repository;
	private IViewManager viewManager;
	
	private TestApplication()
	{
		repository = new PersonneRepositoryMock();
		viewManager = new DefaultViewManager();
	}
	
	public IRepository<?> getRepository() {
		return repository;
	}

	public void setRepository(IRepository<?> repository) {
		this.repository = repository;
	}
	public IViewManager getViewManager() {
		return viewManager;
	}

	public void setViewManager(IViewManager viewManager) {
		this.viewManager = viewManager;
	}

	/**
	 * @return retourne l'instance de la class TestApplication
	 */
	public static TestApplication getInstance() {
		if(instance == null) instance = new TestApplication();
		return instance;
	}

	/**
	 * @param primaryStage utilisé pour la construction de la vue
	 * 
	 * la méthode start a pour but de lancer l'application après avoir été initialisée 
	 * dans la méthode main de ma classe Main
	 * 
	 */
	public void start(Stage primaryStage){
		
		Personne sujet = (Personne) repository.read("Jean");
		//Je peux me permettre de caster l'objet retourné par le repository car je le mock
		//j'aurais aussi pu le caster en ISujet
		
		sujet.ajoutesObserveur(repository);
		//J'abonne mon repository à mon objet car je veux qu'il << s'update >> quand mon sujet va changer
		
		viewManager.buildAndShowGUI(primaryStage);
		//Construction de la vue en JavaFX
		
	}

	
}
