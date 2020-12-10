package miCV.Personal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hildan.fxgson.adapters.properties.ObjectPropertyTypeAdapter;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.beans.InvalidationListener;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personal {

	private StringProperty identificacion;
	private StringProperty nombre;
	private StringProperty Apellidos;
	private StringProperty fechaNacimiento;
	private StringProperty dirección;
	private StringProperty codigoPostal;
	private StringProperty localidad;
	private StringProperty pais;
	
	private List<Nacionalidad> nacionalidades;
	
	public Personal() {
		this.identificacion = new SimpleStringProperty("");
		this.nombre = new SimpleStringProperty("");
		this.Apellidos = new SimpleStringProperty("");
		this.fechaNacimiento = new SimpleStringProperty("");
		this.dirección = new SimpleStringProperty("");
		this.codigoPostal = new SimpleStringProperty("");
		this.localidad = new SimpleStringProperty("");
		this.pais = new SimpleStringProperty("");
		this.nacionalidades = new ArrayList<Nacionalidad>();
	}
	
	public Personal (String identificacion, String nombre, String Apellidos, LocalDate fechaNacimiento, String direccion, int codigoPostal, String localidad, String pais, List<Nacionalidad> nacionalidades) {
		this.identificacion = new SimpleStringProperty(identificacion);
		this.nombre = new SimpleStringProperty(nombre);
		this.Apellidos = new SimpleStringProperty(Apellidos);
		this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento.toString());
		this.dirección = new SimpleStringProperty(direccion);
		this.codigoPostal = new SimpleStringProperty(""+codigoPostal);
		this.localidad = new SimpleStringProperty(localidad);
		this.pais = new SimpleStringProperty(pais);
		this.nacionalidades = nacionalidades;
	}

	public StringProperty getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion.set(identificacion);;
	}

	public StringProperty getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre.set(nombre);;
	}

	public StringProperty getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		this.Apellidos.set(apellidos);;
	}

	public StringProperty getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento.set(fechaNacimiento.toString());;
	}

	public StringProperty getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección.set(dirección);;
	}

	public StringProperty getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal.set(""+codigoPostal);;
	}

	public StringProperty getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad.set(localidad);
	}

	public StringProperty getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais.set(pais);
	}

	public List<Nacionalidad> getNacionalidades() {
		return nacionalidades;
	}

	public void setNacionalidades(List<Nacionalidad> nacionalidades) {
		this.nacionalidades = nacionalidades;
	}

	@Override
	public String toString() {
		String aux;
		aux = "Personal [identificacion=" + identificacion.get() + ", nombre=" + nombre.get() + ", Apellidos=" + Apellidos.get()
		+ ", fechaNacimiento=" + fechaNacimiento.get() + ", dirección=" + dirección.get() + ", codigoPostal=" + codigoPostal.get()
		+ ", localidad=" + localidad.get() + ", pais=" + pais.get() + ", nacionalidades: ";
		for (int i=0;i<nacionalidades.size();i++) {
			aux += nacionalidades.get(i).getDenominacion()+", ";
		}
		return aux;
	}
	
	
}
