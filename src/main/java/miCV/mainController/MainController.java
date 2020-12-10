package miCV.mainController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import miCV.Conocimientos.ConocimientoController;
import miCV.Conocimientos.ConocimientosView;
import miCV.Contacto.ContactoController;
import miCV.Contacto.ContactoView;
import miCV.Experiencia.ExperienciaController;
import miCV.Experiencia.ExperienciaView;
import miCV.Formacion.FormacionController;
import miCV.Formacion.FormacionView;
import miCV.Personal.Nacionalidad;
import miCV.Personal.PersonalController;
import miCV.Personal.PersonalView;
import miCV.mainModel.MainModel;
import miCV.mainUtils.Cv;
import miCV.mainUtils.JSONUtils;
import miCV.mainView.MainView;

public class MainController {
	
	private MainView view;
	
	private MainModel model;
	
	private PersonalController personalController;
	
	private ContactoController contactoController;
	
	private FormacionController formacionController;
	
	private ExperienciaController experienciaController;
	
	private ConocimientoController conocimientosController;

	public MainController() throws IOException {
		view = new MainView();
		model = new MainModel();
		
		personalController = new PersonalController();
		
		contactoController = new ContactoController();
		
		formacionController = new FormacionController();
		
		experienciaController = new ExperienciaController();
		
		conocimientosController = new ConocimientoController();
		
		//Tabs
		
		view.getTab_Personal().setContent(personalController.getPersonalView().getRoot());
		view.getTab_Contacto().setContent(contactoController.getContactoView().getRoot());
		view.getTab_Formación().setContent(formacionController.getFormacionView().getRoot());
		view.getTab_Experiencia().setContent(experienciaController.getExperienciaView().getRoot());
		view.getTab_Conocimientos().setContent(conocimientosController.getConocimientosView().getRoot());
		
		//Bindings
		
		//PersonalTab
		personalController.getPersonalView().getDNI_TextField().textProperty().bindBidirectional(model.getCv().getPersonal().getIdentificacion());
		personalController.getPersonalView().getNombre_TextField().textProperty().bindBidirectional(model.getCv().getPersonal().getNombre());
		personalController.getPersonalView().getApellidos_TextField().textProperty().bindBidirectional(model.getCv().getPersonal().getApellidos());
		personalController.getPersonalView().getFecha_DatePicker().getEditor().textProperty().bindBidirectional(model.getCv().getPersonal().getFechaNacimiento());
		personalController.getPersonalView().getDirección_TextArea().textProperty().bindBidirectional(model.getCv().getPersonal().getDirección());
		personalController.getPersonalView().getCódigoPostal_TextField().textProperty().bindBidirectional(model.getCv().getPersonal().getCodigoPostal());
		personalController.getPersonalView().getLocalidad_TextField().textProperty().bindBidirectional(model.getCv().getPersonal().getLocalidad());
		personalController.getPersonalView().getPaís_ComboBox().valueProperty().bindBidirectional(model.getCv().getPersonal().getPais());
		
		Bindings.bindContent(model.getCv().getPersonal().getNacionalidades(), personalController.getPersonalView().getNacionalidad_ListView().getItems());
		
		//ContactoTab
		Bindings.bindContent(model.getCv().getContacto().getTelefono(), contactoController.getContactoView().getTableView_Telefonos().getItems());
		Bindings.bindContent(model.getCv().getContacto().getEmail(), contactoController.getContactoView().getTableView_DireccionesCorreo().getItems());
		Bindings.bindContent(model.getCv().getContacto().getWeb(), contactoController.getContactoView().getTableView_Webs().getItems());
		
		//FormacionTab
		Bindings.bindContent(model.getCv().getFormacion(), formacionController.getFormacionView().getTableView_Formacion().getItems());
		
		//ExperienciaTab
		Bindings.bindContent(model.getCv().getExperiencia(), experienciaController.getExperienciaView().getTableView_Experiencia().getItems());
		
		//ConocimientosTab
		Bindings.bindContent(model.getCv().getConocimientos(), conocimientosController.getConocimientosView().getTableView_Conocimientos().getItems());
		
		view.getMenuItem_Nuevo().setOnAction((Event) -> {
			try {
				nuevoArchivo();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		view.getMenuItem_Abrir().setOnAction((Event) -> {
			try {
				abrirArchivo();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		view.getMenuItem_Guardar().setOnAction((Event) -> {
			try {
				guardarArchivo();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		view.getMenuItem_GuardarComo().setOnAction((Event) -> {
			try {
				guardarComoArchivo();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	public static ArrayList<Nacionalidad> CargarNacionalidadesCSV(File csv) throws IOException {
		String content = FileUtils.readFileToString(csv, Charset.forName("UTF-8"));
		List<String> contents = Arrays.asList(content.split("\r\n"));
		ArrayList<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();
		for (int i=0;i<contents.size();i++) {
			nacionalidades.add(i, new Nacionalidad(contents.get(i)));
		}
		return nacionalidades;
	}
	
	public void nuevoArchivo() throws IOException {
		ButtonType TipoBoton;
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmacion de Creación de Nuevo Archivo");
		alert.setContentText("¿Está Seguro que quiere crear un nuevo archivo?, los cambios no guardados se eliminaran");
		alert.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
		
		if ((!model.getArchivoCv().equals(null))||(!model.getCv().equals(new Cv()))) {
			alert.showAndWait();
			model.setCv(new Cv());
			model.setArchivoCv(null);
			personalController.clearFields();
		}
		else {
			model.setCv(new Cv());
			model.setArchivoCv(null);
			personalController.clearFields();
			contactoController.clearFields();
			formacionController.clearFields();
			experienciaController.clearFields();
			conocimientosController.clearFields();
		}
	}
	
	public void abrirArchivo() throws IOException {
		FileChooser fileChooser = new FileChooser();
		Stage stage = new Stage();
		fileChooser.setTitle("Open .cv File");
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Cv Files","*.cv"),
				new ExtensionFilter("All Files", "*.*")
		);
		try {
			File selectedFile = fileChooser.showOpenDialog(stage);
			model.setArchivoCv(selectedFile);
			model.setCv(JSONUtils.jsonToObject(selectedFile));
			
			personalController.setFields(model.getCv().getPersonal());
			contactoController.setFields(model.getCv().getContacto());
			formacionController.setFields(model.getCv().getFormacion());
			experienciaController.setFields(model.getCv().getExperiencia());
			conocimientosController.setFields(model.getCv().getConocimientos());
			
		}
		catch (Exception e) {
			System.out.println("El archivo no ha podido ser abierto o no se ha abierto");
		}
	}
	
	public void guardarArchivo() throws IOException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open .cv File");
		fileChooser.setInitialDirectory(model.getArchivoCv());
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Cv Files","*.cv"),
				new ExtensionFilter("All Files", "*.*")
		);
		
		try {
			String jsonCv = JSONUtils.objectToJson(model.getCv());
			FileUtils.writeStringToFile(model.getArchivoCv(), jsonCv);
		}
		catch (NullPointerException e) {
			try {
				model.setArchivoCv(fileChooser.showSaveDialog(new Stage()));
				String jsonCv = JSONUtils.objectToJson(model.getCv());
				FileUtils.writeStringToFile(model.getArchivoCv(), jsonCv);
			}
			catch (NullPointerException e1) {
				System.out.println("No se han guardado los cambios al archivo todavía");
			}
		}
	}
	
	public void guardarComoArchivo() throws IOException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open .cv File");
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Cv Files","*.cv"),
				new ExtensionFilter("All Files", "*.*")
		);
		try {
			File selectedFile = fileChooser.showSaveDialog((new Stage ()));
			model.setArchivoCv(selectedFile);
			String jsonCv = JSONUtils.objectToJson(model.getCv());
			FileUtils.writeStringToFile(model.getArchivoCv(), jsonCv);
		}
		catch (Exception e) {
			System.out.println("No se ha seleccionado ninguna localización");
			e.printStackTrace();
		}
	}
	
	public MainView getMainView() {
		return view;
	}

	public MainModel getModel() {
		return model;
	}
}
