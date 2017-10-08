package miniprojet.metiers;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import miniprojet.abstractions.IRepository;
import miniprojet.abstractions.IViewManager;
import miniprojet.controleurs.PersonneControleur;
import miniprojet.model.Personne;
import miniprojet.vues.PersonneFormFX;
import miniprojet.vues.PersonneVue;

/**
 * @author Rémi Michel
 *
 */
public class DefaultViewManager implements IViewManager{
	
	//private List<Parent> views = new ArrayList<>();
	private Personne sujet;
	private PersonneVue vue;
	private PersonneControleur controleur;
	
	public DefaultViewManager() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void buildAndShowGUI(Stage stage)
	{
		Group root = new Group();
		
        Scene scene = new Scene(root, 400, 100, Color.GHOSTWHITE);
        
        // on place le contexte
        sujet = ((IRepository<Personne>) TestApplication.getInstance().getRepository()).read("Id du sujet");
        controleur = new PersonneControleur(sujet);
        vue = new PersonneVue(new PersonneFormFX(sujet.getNom(), sujet.getAge()), controleur);
        
        sujet.ajoutesObserveur(vue);

        root.getChildren().add(vue);
        
        stage.setScene(scene);

        stage.centerOnScreen();
        stage.show();
	}
	
	/*
	@Override
	public void addView(Parent parent) {
		views.add(parent);
	}
	*/

}
