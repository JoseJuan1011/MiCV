package miCV.Experiencia;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class ExperienciaView implements Initializable {

	public ExperienciaView() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ExperienciaView/ExperienciaView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@FXML
    private HBox root;

    @FXML
    private TableView<Experiencia> TableView_Experiencia;

    @FXML
    private Button Añadir_Button_TableView_Experiencia;

    @FXML
    private Button Eliminar_Button_TableView_Experiencia;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public HBox getRoot() {
		return root;
	}

	public TableView<Experiencia> getTableView_Experiencia() {
		return TableView_Experiencia;
	}

	public Button getAñadir_Button_TableView_Experiencia() {
		return Añadir_Button_TableView_Experiencia;
	}

	public Button getEliminar_Button_TableView_Experiencia() {
		return Eliminar_Button_TableView_Experiencia;
	}
	
}
