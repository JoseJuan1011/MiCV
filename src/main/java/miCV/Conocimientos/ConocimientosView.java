package miCV.Conocimientos;

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

public class ConocimientosView implements Initializable {

	public ConocimientosView() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ConocimientosView/ConocimientosView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@FXML
    private HBox root;

    @FXML
    private TableView<Conocimiento> TableView_Conocimientos;

    @FXML
    private Button AñadirConocimiento_Button_TableView_Conocimientos;

    @FXML
    private Button AñadirIdioma_Button_TableView_Conocimientos;

    @FXML
    private Button Eliminar_Button_TableView_Conocimientos;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public HBox getRoot() {
		return root;
	}

	public TableView<Conocimiento> getTableView_Conocimientos() {
		return TableView_Conocimientos;
	}

	public Button getAñadirConocimiento_Button_TableView_Conocimientos() {
		return AñadirConocimiento_Button_TableView_Conocimientos;
	}

	public Button getAñadirIdioma_Button_TableView_Conocimientos() {
		return AñadirIdioma_Button_TableView_Conocimientos;
	}

	public Button getEliminar_Button_TableView_Conocimientos() {
		return Eliminar_Button_TableView_Conocimientos;
	}

}
