package miniprojet.controleurs;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import miniprojet.abstractions.IControler;
import miniprojet.abstractions.IRepository;
import miniprojet.exceptions.InvalidAgeException;
import miniprojet.exceptions.InvalidNomException;
import miniprojet.metiers.TestApplication;
import miniprojet.model.Personne;
import miniprojet.vues.PersonneFormFX;

/**
 * @author Rémi Michel
 * 
 * Le contrôleur va contrôler les saisies de l'utilisateur, modifier le sujet 
 * à travers l'API de persistance et mettre à jour les observeurs du sujet.
 * 
 * Il informe aussi l'utilisateur de l'erreur sur le formulaire
 *
 */
public class PersonneControleur implements IControler<PersonneFormFX>{
	
	private Personne personne;
	private String invalidChars = ",;:!?./§*%µ^$¨£²&\"()=<>#1234567890°+}]^@|[{";
	
	private Border defaultBorder = new TextField().getBorder();
	
	public PersonneControleur(Personne personne) {
		super();
		this.personne = personne;
	}
	
	@SuppressWarnings("unchecked")
	public void control(PersonneFormFX controlable)
	{
		String oldId = personne.getNom(); // Cette id est nécessaire pour modifier l'objet dans la base de données
		// il se compose simplement du nom de l'objet personne.
		
		if(controlable == null)
			throw new NullPointerException("le controlable est NULL !");
		
		String newNom = controlable.getTxtFieldNom().getText();
		int newAge = controlable.getSpinnerAge().getValue();
		
		controlable.getTxtFieldNom().setBorder(defaultBorder);
		controlable.getSpinnerAge().setBorder(defaultBorder);
		
		Paint redPaint = Paint.valueOf("RED");
		BorderStrokeStyle bss =
				new BorderStrokeStyle(StrokeType.CENTERED
						, StrokeLineJoin.BEVEL
						, StrokeLineCap.ROUND, 1, 0, null);
		
		Border redBorder = new Border(
				new BorderStroke(redPaint, redPaint, redPaint, redPaint
						, bss, bss, bss, bss, new CornerRadii(0), BorderWidths.DEFAULT, new Insets(0)));

		boolean ok = false;
		
		try {
			controlNom(newNom);
			ok = true;
		} catch (InvalidNomException e) {
			ok = false;
			controlable.getTxtFieldNom().setBorder(redBorder);
			e.printStackTrace();
		}
		try {
			controlAge(newAge);
			ok = (ok == true);
		} catch (InvalidAgeException e) {
			ok = false;
			controlable.getSpinnerAge().setBorder(redBorder);
			e.printStackTrace();
		}
		if(ok)
		{
			
			personne.setNom(newNom);
			personne.setAge(newAge);
			
			//Cast du dépôt de l'application car je manipule le dépôt sans passer par une méthode 
			//de la classe TestApplication
			((IRepository<Personne>)TestApplication.getInstance().getRepository()).update(oldId, personne);
			
			personne.notifiesTesObserveurs();
		}
		
	}
	
	private void controlNom(String newNom) throws InvalidNomException
	{
		String invalidCharsInName = "";
		for(String s : invalidChars.split(""))
		{
			if(newNom.contains(s))
			{
				invalidCharsInName += s +", ";
			}
		}
		if(!"".equals(invalidCharsInName))
		{
			throw new InvalidNomException("Caractère(s) : "+invalidCharsInName+"Invalide(s)");
		}
		
	}
	private void controlAge(int newAge) throws InvalidAgeException
	{
		if(newAge < 0)
		{
			throw new InvalidAgeException(newAge+" < 0 !");
		}
	}
	
	

}
