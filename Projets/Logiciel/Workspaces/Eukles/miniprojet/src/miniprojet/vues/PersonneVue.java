package miniprojet.vues;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import miniprojet.abstractions.IControler;
import miniprojet.abstractions.IObserveur;

/**
 * @author R�mi
 * 
 * Vue globale qui contient le contr�leur de la vue de la classe Personne.
 *
 */
public class PersonneVue extends Parent implements IObserveur{

	private PersonneFormFX form;
	private Button btnSubmitFX = new Button("Submit");
	
	private IControler<PersonneFormFX> controleur;

	public PersonneVue(PersonneFormFX aform, IControler<PersonneFormFX> acontroleur) {
		super();
		this.form = aform;
		this.controleur = acontroleur;
		
		btnSubmitFX.setOnMouseReleased(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				/*
				 * On contr�le la vue de fa�on statique.
				 * Par l'appui d'un bouton apr�s la saisie de l'utilisateur.
				 */
				controleur.control(form);
				
			}
		});
		
		btnSubmitFX.setPrefWidth(250);
		
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(this.form);
		vbox.getChildren().add(new Label(" "));
		vbox.getChildren().add(btnSubmitFX);
		
		getChildren().add(vbox);
	}

	@Override
	public void update() {
		System.out.println("PersonneVue : 'Mon sujet a �t� mis a jour !'");
	}

	
	
	
	
}
