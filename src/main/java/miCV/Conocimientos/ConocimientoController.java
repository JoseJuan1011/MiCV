package miCV.Conocimientos;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Pair;
import miCV.Conocimientos.subClasses.Idioma;
import miCV.Conocimientos.subClasses.Nivel;

public class ConocimientoController {
	
	private static ConocimientosView view;
	
	private static Dialog<Pair<String,Nivel>> conocimientosDialog_1;
	
	private static Dialog<Pair<Pair<String,Nivel>,String>> conocimientosDialog_2;
	
	public ConocimientoController() throws IOException {
		view = new ConocimientosView();
		
		view.getAñadirConocimiento_Button_TableView_Conocimientos().setOnAction((Event) -> {
			añadirConocimiento_1();
		});
		
		view.getAñadirIdioma_Button_TableView_Conocimientos().setOnAction((Event) -> {
			añadirConocimiento_2();
		});
		
		view.getEliminar_Button_TableView_Conocimientos().setOnAction((Event) -> {
			eliminarConocimiento();
		});
	}
	
	public void clearFields() {
		int size = view.getTableView_Conocimientos().getItems().size();
		for (int i=0;i<size;i++) {
			view.getTableView_Conocimientos().getItems().remove(i);
		}
		view.getTableView_Conocimientos().refresh();
	}
	
	public void setFields(List<Conocimiento> c) {
		clearFields();
		view.getTableView_Conocimientos().getItems().addAll(c);
	}
	
	public static void añadirConocimiento_1() {
		conocimientosDialog_1 = new Dialog<>();
		
		ButtonType loginButtonType = new ButtonType("Añadir", ButtonData.OK_DONE);
		conocimientosDialog_1.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));
		
		TextField denominacion_TextField = new TextField();
		
		ComboBox<Nivel> nivel_ComboBox = new ComboBox<Nivel>();
		nivel_ComboBox.getItems().addAll(Nivel.AVANZADO,Nivel.MEDIO,Nivel.BASICO);
		
		Button button_null = new Button("X");
		button_null.setOnAction((Event) -> {
			nivel_ComboBox.setValue(null);
		});
		
		HBox row_HBox = new HBox(nivel_ComboBox,button_null);
		row_HBox.setSpacing(5);
		
		grid.add(new Label("Denominación "), 0, 0);
		grid.add(denominacion_TextField, 1, 0);
		grid.add(new Label("Nivel "), 0, 1);
		grid.add(row_HBox, 1, 1);
		
		conocimientosDialog_1.getDialogPane().setContent(grid);
		
		conocimientosDialog_1.setResultConverter(dialogButton -> {
		    if (dialogButton == loginButtonType) {
		    	return new Pair<>(denominacion_TextField.getText(),nivel_ComboBox.getSelectionModel().getSelectedItem());
		        
		    }
		    return null;
		});
		
		Optional<Pair<String,Nivel>> result = conocimientosDialog_1.showAndWait();
		result.ifPresent(Conocimiento_1 -> {
			view.getTableView_Conocimientos().getItems().add(new Conocimiento(Conocimiento_1.getKey(),Conocimiento_1.getValue()));
		});
	}
	
	public static void añadirConocimiento_2() {
		conocimientosDialog_2 = new Dialog<>();
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));
		
		ButtonType loginButtonType = new ButtonType("Añadir", ButtonData.OK_DONE);
		conocimientosDialog_2.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		
		TextField denominacion_TextField = new TextField();
		
		ComboBox<Nivel> nivel_ComboBox = new ComboBox<Nivel>();
		nivel_ComboBox.getItems().addAll(Nivel.AVANZADO,Nivel.MEDIO,Nivel.BASICO);
		
		Button button_null = new Button("X");
		
		TextField certificacion_TextField = new TextField();
		
		HBox row_HBox = new HBox(nivel_ComboBox,button_null);
		row_HBox.setSpacing(5);
		
		grid.add(new Label("Denominación "), 0, 0);
		grid.add(denominacion_TextField, 1, 0);
		grid.add(new Label("Nivel "), 0, 1);
		grid.add(row_HBox, 1, 1);
		grid.add(new Label("Certificación "), 0,2);
		grid.add(certificacion_TextField, 1, 2);
		
		conocimientosDialog_2.getDialogPane().setContent(grid);
		
		conocimientosDialog_2.setResultConverter(dialogButton -> {
		    if (dialogButton == loginButtonType) {
		        return new Pair<>(new Pair<>(denominacion_TextField.getText(),nivel_ComboBox.getValue()),certificacion_TextField.getText());
		    }
		    return null;
		});
		
		Optional<Pair<Pair<String,Nivel>,String>> result = conocimientosDialog_2.showAndWait();
		result.ifPresent(Conocimiento_2 -> {
			String denominacion = Conocimiento_2.getKey().getKey();
			Nivel nivel = Conocimiento_2.getKey().getValue();
			Idioma idioma = new Idioma(Conocimiento_2.getValue());
			
			view.getTableView_Conocimientos().getItems().add(new Conocimiento(denominacion,idioma,nivel));
		});
	}
	
	public static void eliminarConocimiento() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación Eliminación Conocimiento");
		alert.setContentText("¿Está seguro que quiere eliminar el siguiente Conocimiento?");
		
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.get().equals(ButtonType.CANCEL)) {
			int selected = view.getTableView_Conocimientos().getSelectionModel().getSelectedIndex();
			view.getTableView_Conocimientos().getItems().remove(selected);
		}
	}
	
	public ConocimientosView getConocimientosView() {
		return view;
	}
	
	public void setConocimientosView(ConocimientosView view) {
		this.view = view;
	}
}
