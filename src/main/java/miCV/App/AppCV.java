package miCV.App;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import miCV.mainController.MainController;

public class AppCV extends Application {

	MainController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new MainController();
		
		Scene scene = new Scene(controller.getMainView().getRoot());
		primaryStage.setTitle("MiCV");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
