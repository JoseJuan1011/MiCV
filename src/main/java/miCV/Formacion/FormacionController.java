package miCV.Formacion;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class FormacionController {
	
	private static FormacionView view;
	
	private static Dialog <Pair<Pair<String,String>,Pair<LocalDate,LocalDate>>> titulo_dialog;
	
	public FormacionController() throws IOException {
		view = new FormacionView();
		
		view.getAñadir_Button_TableView_Formacion().setOnAction((Event) -> {
			añadirTitulo();
		});
		
		view.getEliminar_Button_TableView_Formacion().setOnAction((Event) -> {
			deleteTitulo();
		});
	}
	
	public FormacionView getFormacionView() {
		return view;
	}
	
	public void setFormacionView(FormacionView view) {
		this.view = view;
	}
	
	public void clearFields() {
		int size = view.getTableView_Formacion().getItems().size();
		for (int i=0;i<size;i++) {
			view.getTableView_Formacion().getItems().remove(i);
		}
		view.getTableView_Formacion().refresh();
	}
	
	//Variable f equivalente a Formación
	public void setFields(List<Titulo> f) {
		clearFields();
		view.getTableView_Formacion().getItems().addAll(f);
	}
	
	public static void añadirTitulo() {
		titulo_dialog = new Dialog<>();
		titulo_dialog.setTitle("Nuevo Título");
		
		ButtonType loginButtonType = new ButtonType("Añadir", ButtonData.OK_DONE);
		titulo_dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));
		
		TextField denominación_TextField = new TextField();
		
		TextField organizador_TextField = new TextField();
		
		DatePicker desde_DatePicker = new DatePicker();
		
		DatePicker hasta_DatePicker = new DatePicker();
		
		grid.add(new Label("Denominación "), 0, 0);
		grid.add(denominación_TextField, 1, 0);
		grid.add(new Label("Organizador "), 0, 1);
		grid.add(organizador_TextField, 1, 1);
		grid.add(new Label("Desde "), 0, 2);
		grid.add(desde_DatePicker, 1, 2);
		grid.add(new Label("Hasta "), 0, 3);
		grid.add(hasta_DatePicker, 1, 3);
		
		titulo_dialog.getDialogPane().setContent(grid);
		
		titulo_dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == loginButtonType) {
		        return new Pair<>(new Pair<String,String>(denominación_TextField.getText(), organizador_TextField.getText()),new Pair<LocalDate,LocalDate>(desde_DatePicker.getValue(), hasta_DatePicker.getValue()));
		    }
		    return null;
		});
		
		Optional<Pair<Pair<String, String>, Pair<LocalDate, LocalDate>>> result = titulo_dialog.showAndWait();
		result.ifPresent(Titulo -> {
			LocalDate Desde = Titulo.getValue().getKey();
			LocalDate Hasta = Titulo.getValue().getValue();
			String Denominacion = Titulo.getKey().getKey();
			String Organizador = Titulo.getKey().getValue();
			
			view.getTableView_Formacion().getItems().add(new Titulo(Desde,Hasta,Denominacion,Organizador));
		});
	}
	
	public static void deleteTitulo() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación Eliminación Título");
		alert.setContentText("¿Está seguro que quiere eliminar el siguiente Título?");
		
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.get().equals(ButtonType.CANCEL)) {
			int selected = view.getTableView_Formacion().getSelectionModel().getSelectedIndex();
			view.getTableView_Formacion().getItems().remove(selected);
		}
	}
}
