package miCV.Formacion;

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

public class FormacionView implements Initializable {

	public FormacionView() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FormacionView/FormacionView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@FXML
    private HBox root;

    @FXML
    private TableView<Titulo> TableView_Formacion;

    @FXML
    private Button Añadir_Button_TableView_Formacion;

    @FXML
    private Button Eliminar_Button_TableView_Formacion;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public HBox getRoot() {
		return root;
	}


	public TableView<Titulo> getTableView_Formacion() {
		return TableView_Formacion;
	}


	public Button getAñadir_Button_TableView_Formacion() {
		return Añadir_Button_TableView_Formacion;
	}


	public Button getEliminar_Button_TableView_Formacion() {
		return Eliminar_Button_TableView_Formacion;
	}
	
	
}
