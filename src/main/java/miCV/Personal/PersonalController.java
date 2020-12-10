package miCV.Personal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.scene.control.ChoiceDialog;
import miCV.mainController.MainController;

public class PersonalController {
	
	private static PersonalView view;
	
	private File ArchivoNacionalidades;
	
	private static ArrayList<Nacionalidad> nacionalidadesCSV;
	
	private static ChoiceDialog<Nacionalidad> nacionalidadesDialog;
	
	public PersonalController() throws IOException {
		view = new PersonalView();
		ArchivoNacionalidades = new File("Nacionalidades.csv");
		try {
			nacionalidadesCSV = MainController.CargarNacionalidadesCSV(ArchivoNacionalidades);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		nacionalidadesDialog = new ChoiceDialog<Nacionalidad>(new Nacionalidad("Elija Nacionalidad"), nacionalidadesCSV);
		nacionalidadesDialog.setTitle("Nacionalidades");
		nacionalidadesDialog.setHeaderText("Escoja su nacionalidad");
		nacionalidadesDialog.setContentText("Escoja una de las que aparecen en la siguiente lista: ");
		
	}
	
	public static void addNacionalidad() {
		Optional<Nacionalidad> result = nacionalidadesDialog.showAndWait();
		result.ifPresent(nacionalidadSelected -> {
			view.getNacionalidad_ListView().getItems().add(nacionalidadSelected);
		});
	}
	
	public void clearFields() {
		view.getDNI_TextField().setText("");
		view.getNombre_TextField().setText("");
		view.getApellidos_TextField().setText("");
		view.getFecha_DatePicker().getEditor().setText("");
		view.getDirección_TextArea().setText("");
		view.getCódigoPostal_TextField().setText("");
		view.getLocalidad_TextField().setText("");
		view.getPaís_ComboBox().getEditor().setText("");
		view.getNacionalidad_ListView().getItems().clear();
		view.getNacionalidad_ListView().refresh();
	}
	
	public void setFields(Personal p) {
		view.getDNI_TextField().setText(p.getIdentificacion().get());
		view.getNombre_TextField().setText(p.getNombre().get());
		view.getApellidos_TextField().setText(p.getApellidos().get());
		view.getFecha_DatePicker().getEditor().setText(p.getFechaNacimiento().get());
		view.getDirección_TextArea().setText(p.getDirección().get());
		view.getCódigoPostal_TextField().setText(p.getCodigoPostal().get());
		view.getLocalidad_TextField().setText(p.getLocalidad().get());
		view.getPaís_ComboBox().getEditor().setText(p.getPais().get());
		view.getNacionalidad_ListView().getItems().clear();
		view.getNacionalidad_ListView().getItems().addAll(p.getNacionalidades());
		view.getNacionalidad_ListView().refresh();
	}

	public static void deleteNacionalidad() {
		int selected = view.getNacionalidad_ListView().getSelectionModel().getSelectedIndex();
		view.getNacionalidad_ListView().getItems().remove(selected);
	}
	
	public File getArchivoNacionalidades() {
		return ArchivoNacionalidades;
	}

	public void setArchivoNacionalidades(File archivoNacionalidades) {
		ArchivoNacionalidades = archivoNacionalidades;
	}

	public ArrayList<Nacionalidad> getNacionalidadesCSV() {
		return nacionalidadesCSV;
	}

	public void setNacionalidadesCSV(ArrayList<Nacionalidad> nacionalidadesCSV) {
		this.nacionalidadesCSV = nacionalidadesCSV;
	}

	public PersonalView getPersonalView() {
		return view;
	}
	
	public void setPersonalView(PersonalView view) {
		this.view = view;
	}

}
