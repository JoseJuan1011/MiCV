package miCV.Contacto;

import java.io.IOException;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import miCV.Contacto.subClasses.Email;
import miCV.Contacto.subClasses.Teléfono;
import miCV.Contacto.subClasses.TipoTeléfono;
import miCV.Contacto.subClasses.Web;

public class ContactoController {

	private static ContactoView view;
	
	static Dialog<Pair<String, TipoTeléfono>> telefono_dialog;
	
	static TextInputDialog email_dialog;
	
	static TextInputDialog web_dialog;
	
	public ContactoController() {
		try {
			view = new ContactoView();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		view.getAñadir_Button_TableView_Teléfonos().setOnAction((Event) -> {
			añadirTelefono();
		});
		
		view.getAñadir_Button_TableView_DireccionesCorreo().setOnAction((Event) -> {
			añadirCorreo();
		});
		
		view.getButton_Añadir_TableView_Webs().setOnAction((Event) -> {
			añadirWeb();
		});
		
		view.getEliminar_Button_TableView_Teléfonos().setOnAction((Event) -> {
			deleteTelefono();
		});
		
		view.getEliminar_Button_TableView_DireccionesCorreo().setOnAction((Event) -> {
			deleteCorreo();
		});
		
		view.getEliminar_Button_TableView_Webs().setOnAction((Event) -> {
			deleteWeb();
		});
	}
	
	public void clearFields() {
		view.getTableView_Telefonos().getItems().clear();
		view.getTableView_DireccionesCorreo().getItems().clear();
		view.getTableView_Webs().getItems().clear();
		view.getTableView_Telefonos().refresh();
		view.getTableView_DireccionesCorreo().refresh();
		view.getTableView_Webs().refresh();
	}
	
	public void setFields(Contacto c) {
		clearFields();
		view.getTableView_Telefonos().getItems().addAll(c.getTelefono());
		view.getTableView_DireccionesCorreo().getItems().addAll(c.getEmail());
		view.getTableView_Webs().getItems().addAll(c.getWeb());
	}

	public static void añadirTelefono() {
		telefono_dialog = new Dialog<>();
		telefono_dialog.setTitle("Nuevo Teléfono");
		telefono_dialog.setHeaderText("Introduzca un número de teléfono");
		
		TextField Telefono_TextField;
		
		ButtonType AñadirButtonType = new ButtonType("Añadir", ButtonData.OK_DONE);
		telefono_dialog.getDialogPane().getButtonTypes().addAll(AñadirButtonType, ButtonType.CANCEL);
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		Telefono_TextField = new TextField();
		Telefono_TextField.setPromptText("Teléfono");
		
		ComboBox<TipoTeléfono> tipotelefono;
		
		tipotelefono = new ComboBox<TipoTeléfono>();
		tipotelefono.getItems().addAll(TipoTeléfono.DOMICILIO,TipoTeléfono.MÓVIL);

		grid.add(new Label("Teléfono:"), 0, 0);
		grid.add(Telefono_TextField, 1, 0);
		grid.add(new Label("TipoTeléfono:"), 0, 1);
		grid.add(tipotelefono, 1, 1);
		
		telefono_dialog.getDialogPane().setContent(grid);
		
		telefono_dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == AñadirButtonType) {
		        return new Pair<>(Telefono_TextField.getText(), tipotelefono.getSelectionModel().getSelectedItem());
		    }
		    return null;
		});
		
		Optional<Pair<String, TipoTeléfono>> result = telefono_dialog.showAndWait();
		result.ifPresent(telefonoYtipo -> {
			view.getTableView_Telefonos().getItems().add(new Teléfono(telefonoYtipo.getValue(),telefonoYtipo.getKey()));
		});
	}
	
	public static void añadirCorreo() {
		email_dialog = new TextInputDialog();
		email_dialog.setTitle("Nuevo e-mail");
		email_dialog.setHeaderText("Crea una nueva dirección de correo.");
		email_dialog.setContentText("E-mail: ");
		
		Optional<String> result = email_dialog.showAndWait();
		result.ifPresent(email -> {
			view.getTableView_DireccionesCorreo().getItems().add(new Email(email));
		});
	}
	
	public static void añadirWeb() {
		web_dialog = new TextInputDialog();
		web_dialog.setTitle("Nueva Web");
		web_dialog.setHeaderText("Crea una dirección web.");
		web_dialog.setContentText("URL:");
		web_dialog.getEditor().setText("http://");
		
		Optional<String> result = web_dialog.showAndWait();
		result.ifPresent(web -> {
			view.getTableView_Webs().getItems().add(new Web(web));
		});
	}
	
	public static void deleteTelefono() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación Eliminación Teléfono");
		alert.setContentText("¿Está seguro que quiere eliminar el siguiente Teléfono?");
		
		Optional<ButtonType> result = alert.showAndWait();
		
		if (!result.get().equals(ButtonType.CANCEL)) {
			int selected = view.getTableView_Telefonos().getSelectionModel().getSelectedIndex();
			view.getTableView_Telefonos().getItems().remove(selected);
		}		
	}
	
	public static void deleteCorreo() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación Eliminación Correo");
		alert.setContentText("¿Está seguro que quiere eliminar el siguiente Correo?");
		
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.get().equals(ButtonType.CANCEL)) {
			int selected = view.getTableView_DireccionesCorreo().getSelectionModel().getSelectedIndex();
			view.getTableView_DireccionesCorreo().getItems().remove(selected);
		}
	}

	public static void deleteWeb() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación Eliminación Web");
		alert.setContentText("¿Está seguro que quiere eliminar la siguiente Web/URL?");
		
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.get().equals(ButtonType.CANCEL)) {
			int selected = view.getTableView_Webs().getSelectionModel().getSelectedIndex();
			view.getTableView_Webs().getItems().remove(selected);
		}
	}
	
	public ContactoView getContactoView() {
		return view;
	}

	public static void setContactoView(ContactoView view) {
		ContactoController.view = view;
	}	
}
