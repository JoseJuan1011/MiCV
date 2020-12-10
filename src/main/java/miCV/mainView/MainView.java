package miCV.mainView;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import miCV.Personal.PersonalView;
import miCV.Conocimientos.ConocimientosView;
import miCV.Contacto.ContactoView;
import miCV.Experiencia.ExperienciaView;
import miCV.Formacion.FormacionView;

public class MainView implements Initializable {

	public MainView() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainCvView/MiCvView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private BorderPane root;

	@FXML
	private MenuBar Menu;

	@FXML
	private Menu Menu_File;

	@FXML
	private MenuItem MenuItem_Nuevo;

	@FXML
	private MenuItem MenuItem_Abrir;

	@FXML
	private MenuItem MenuItem_Guardar;

	@FXML
	private MenuItem MenuItem_GuardarComo;

	@FXML
	private SeparatorMenuItem MenuItem_Separator;

	@FXML
	private MenuItem MenuItem_Salir;

	@FXML
	private Menu Menu_Ayuda;

	@FXML
	private MenuItem MenuItem_AcercaDe;

	@FXML
	private TabPane TabPane;

	@FXML
	private Tab Tab_Personal;

	@FXML
	private Tab Tab_Contacto;

	@FXML
	private Tab Tab_Formación;

	@FXML
	private Tab Tab_Experiencia;

	@FXML
	private Tab Tab_Conocimientos;
	
	private PersonalView PersonalView;
	
	private ContactoView ContactoView;
	
	private FormacionView FormacionView;
	
	private ExperienciaView ExperienciaView;
	
	private ConocimientosView ConocimientosView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			PersonalView = new PersonalView();
			ContactoView = new ContactoView();
			FormacionView = new FormacionView();
			ExperienciaView = new ExperienciaView();
			ConocimientosView = new ConocimientosView();
			
			Tab_Personal.setContent(PersonalView.getRoot());
			Tab_Contacto.setContent(ContactoView.getRoot());
			Tab_Formación.setContent(FormacionView.getRoot());
			Tab_Experiencia.setContent(ExperienciaView.getRoot());
			Tab_Conocimientos.setContent(ConocimientosView.getRoot());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void OnAbrirArchhivoAction(ActionEvent event) {
		
    }

    @FXML
    void OnGuardarAction(ActionEvent event) {

    }

    @FXML
    void OnGuardarComoAction(ActionEvent event) {

    }
	
	@FXML
    void OnSalirAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación de Salida del Programa");
		alert.setContentText("¿Está seguro que quiere salir del programa? Los cambios no guardados se eliminaran");
		
		Optional<ButtonType> result = alert.showAndWait();
		
		if (result.get().equals(ButtonType.OK)) {
			System.exit(0);
		}
    }

	public MenuItem getMenuItem_Nuevo() {
		return MenuItem_Nuevo;
	}

	public MenuItem getMenuItem_Abrir() {
		return MenuItem_Abrir;
	}

	public MenuItem getMenuItem_Guardar() {
		return MenuItem_Guardar;
	}

	public MenuItem getMenuItem_GuardarComo() {
		return MenuItem_GuardarComo;
	}

	public Tab getTab_Personal() {
		return Tab_Personal;
	}

	public Tab getTab_Contacto() {
		return Tab_Contacto;
	}

	public Tab getTab_Formación() {
		return Tab_Formación;
	}

	public Tab getTab_Experiencia() {
		return Tab_Experiencia;
	}

	public Tab getTab_Conocimientos() {
		return Tab_Conocimientos;
	}

	public BorderPane getRoot() {
		return root;
	}
}
