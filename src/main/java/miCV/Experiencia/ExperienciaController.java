package miCV.Experiencia;

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

public class ExperienciaController {
	
	private static ExperienciaView view;
	
	private static Dialog <Pair<Pair<String,String>,Pair<LocalDate,LocalDate>>> experiencia_dialog;
	
	public ExperienciaController() throws IOException {
		view = new ExperienciaView();
		
		view.getAñadir_Button_TableView_Experiencia().setOnAction((Event) -> {
			añadirExperiencia();
		});
		
		view.getEliminar_Button_TableView_Experiencia().setOnAction((Event) -> {
			eliminarExperiencia();
		});
	}
	
	public void clearFields() {
		int size = view.getTableView_Experiencia().getItems().size();
		for (int i=0;i<size;i++) {
			view.getTableView_Experiencia().getItems().remove(i);
		}
		view.getTableView_Experiencia().refresh();
	}
	
	public void setFields(List<Experiencia> e) {
		clearFields();
		view.getTableView_Experiencia().getItems().addAll(e);
	}
	
	public static void añadirExperiencia() {
		experiencia_dialog = new Dialog<>();
		experiencia_dialog.setTitle("Nuevo Título");
		
		ButtonType AñadirButtonType = new ButtonType("Añadir", ButtonData.OK_DONE);
		experiencia_dialog.getDialogPane().getButtonTypes().addAll(AñadirButtonType, ButtonType.CANCEL);
		
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
		grid.add(new Label("Empleador "), 0, 1);
		grid.add(organizador_TextField, 1, 1);
		grid.add(new Label("Desde "), 0, 2);
		grid.add(desde_DatePicker, 1, 2);
		grid.add(new Label("Hasta "), 0, 3);
		grid.add(hasta_DatePicker, 1, 3);
		
		experiencia_dialog.getDialogPane().setContent(grid);
		
		experiencia_dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == AñadirButtonType) {
		        return new Pair<>(new Pair<String,String>(denominación_TextField.getText(), organizador_TextField.getText()),new Pair<LocalDate,LocalDate>(desde_DatePicker.getValue(), hasta_DatePicker.getValue()));
		    }
		    return null;
		});
		
		Optional<Pair<Pair<String, String>, Pair<LocalDate, LocalDate>>> result = experiencia_dialog.showAndWait();
		result.ifPresent(Titulo -> {
			LocalDate Desde = Titulo.getValue().getKey();
			LocalDate Hasta = Titulo.getValue().getValue();
			String Denominacion = Titulo.getKey().getKey();
			String Empleador = Titulo.getKey().getValue();
			
			view.getTableView_Experiencia().getItems().add(new Experiencia(Desde,Hasta,Denominacion,Empleador));
		});
	}
	
	public static void eliminarExperiencia() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación Eliminación Experiencia");
		alert.setContentText("¿Está seguro que quiere eliminar la siguiente Experiencia?");
		
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.get().equals(ButtonType.CANCEL)) {
			int selected = view.getTableView_Experiencia().getSelectionModel().getSelectedIndex();
			view.getTableView_Experiencia().getItems().remove(selected);
		}
	}
	
	public ExperienciaView getExperienciaView() {
		return view;
	}
	
	public void setExperienciaView(ExperienciaView view) {
		this.view = view;
	}
}
