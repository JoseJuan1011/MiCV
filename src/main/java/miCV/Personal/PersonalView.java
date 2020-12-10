package miCV.Personal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonalView implements Initializable {
	
	public PersonalView() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/PersonalView/PersonalView2.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@FXML
    private GridPane root;

    @FXML
    private TextField DNI_TextField;

    @FXML
    private TextField Nombre_TextField;

    @FXML
    private TextField Apellidos_TextField;

    @FXML
    private DatePicker Fecha_DatePicker;

    @FXML
    private TextArea Dirección_TextArea;

    @FXML
    private TextField CódigoPostal_TextField;

    @FXML
    private TextField Localidad_TextField;

    @FXML
    private ComboBox<String> País_ComboBox;

    @FXML
    private ListView<Nacionalidad> Nacionalidad_ListView;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		País_ComboBox.getItems().addAll("España","Inglaterra","Portugal");
	}
	
	@FXML
    void onAddNacionalidadAction(ActionEvent event) {
		PersonalController.addNacionalidad();
    }
	
	@FXML
    void OnEliminarNacionalidad(ActionEvent event) {
		PersonalController.deleteNacionalidad();
    }
	
	public GridPane getRoot() {
		return root;
	}

	public TextField getDNI_TextField() {
		return DNI_TextField;
	}

	public TextField getNombre_TextField() {
		return Nombre_TextField;
	}

	public TextField getApellidos_TextField() {
		return Apellidos_TextField;
	}

	public DatePicker getFecha_DatePicker() {
		return Fecha_DatePicker;
	}

	public TextArea getDirección_TextArea() {
		return Dirección_TextArea;
	}

	public TextField getCódigoPostal_TextField() {
		return CódigoPostal_TextField;
	}

	public TextField getLocalidad_TextField() {
		return Localidad_TextField;
	}

	public ComboBox<String> getPaís_ComboBox() {
		return País_ComboBox;
	}

	public ListView<Nacionalidad> getNacionalidad_ListView() {
		return Nacionalidad_ListView;
	}
	
}
