package miCV.mainController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import miCV.Personal.PersonalView;
import miCV.mainView.MainView;

public class MainController {
	
	private MainView view;
	
	public MainController() throws IOException {
		view = new MainView();
		
		
	}
	
	public MainView getMainView() {
		return view;
	}
}
