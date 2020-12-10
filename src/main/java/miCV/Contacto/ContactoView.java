package miCV.Contacto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import miCV.Contacto.subClasses.Email;
import miCV.Contacto.subClasses.Teléfono;
import miCV.Contacto.subClasses.Web;

public class ContactoView implements Initializable {

	public ContactoView() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ContactoView/ContactoView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@FXML
    private SplitPane root;

	@FXML
    private TableView<Teléfono> TableView_Telefonos;

    @FXML
    private Button Añadir_Button_TableView_Teléfonos;

    @FXML
    private Button Eliminar_Button_TableView_Teléfonos;

    @FXML
    private TableView<Email> TableView_DireccionesCorreo;

    @FXML
    private Button Añadir_Button_TableView_DireccionesCorreo;

    @FXML
    private Button Eliminar_Button_TableView_DireccionesCorreo;

    @FXML
    private TableView<Web> TableView_Webs;

    @FXML
    private Button Button_Añadir_TableView_Webs;

    @FXML
    private Button Eliminar_Button_TableView_Webs;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public SplitPane getRoot() {
		return root;
	}

	public TableView<Teléfono> getTableView_Telefonos() {
		return TableView_Telefonos;
	}

	public Button getAñadir_Button_TableView_Teléfonos() {
		return Añadir_Button_TableView_Teléfonos;
	}

	public Button getEliminar_Button_TableView_Teléfonos() {
		return Eliminar_Button_TableView_Teléfonos;
	}

	public TableView<Email> getTableView_DireccionesCorreo() {
		return TableView_DireccionesCorreo;
	}

	public Button getAñadir_Button_TableView_DireccionesCorreo() {
		return Añadir_Button_TableView_DireccionesCorreo;
	}

	public Button getEliminar_Button_TableView_DireccionesCorreo() {
		return Eliminar_Button_TableView_DireccionesCorreo;
	}

	public TableView<Web> getTableView_Webs() {
		return TableView_Webs;
	}

	public Button getButton_Añadir_TableView_Webs() {
		return Button_Añadir_TableView_Webs;
	}

	public Button getEliminar_Button_TableView_Webs() {
		return Eliminar_Button_TableView_Webs;
	}
	
	
}
