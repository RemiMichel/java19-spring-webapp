package miniprojet;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import miniprojet.metiers.DefaultViewManager;
import miniprojet.metiers.TestApplication;
import miniprojet.mock.PersonneRepositoryMock;

public class Main extends Application{
	
	
	public static void main(String[] args) {
		
		 new JFXPanel(); // initializes JavaFX environment
		
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		TestApplication app = TestApplication.getInstance();
		
		PersonneRepositoryMock mock = new PersonneRepositoryMock();
		DefaultViewManager vm = new DefaultViewManager();
		
		app.setRepository(mock);
		app.setViewManager(vm);
		
		app.start(primaryStage);
		
	}

	
	
	
}
