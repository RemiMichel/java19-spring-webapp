package miniprojet.vues;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * @author Rémi Michel
 * 
 * Vue de la classe Personne
 *
 */
public class PersonneFormFX extends Parent{
	
	private TextField txtFieldNom;
	private Spinner<Integer> spinnerAge;
	
	public PersonneFormFX(String name, int age) {
		super();
		

		txtFieldNom = new TextField();
		txtFieldNom.setText(name);
		txtFieldNom.setPrefColumnCount(20);
		spinnerAge = new Spinner<>(-999, 999, age);
		
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(5));
		hbox.getChildren().add(txtFieldNom);
		hbox.getChildren().add(spinnerAge);
		getChildren().add(hbox);
	}

	public TextField getTxtFieldNom() {
		return txtFieldNom;
	}

	public Spinner<Integer> getSpinnerAge() {
		return spinnerAge;
	}
	
	

}
