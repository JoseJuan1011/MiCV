package miCV.Contacto.subClasses;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Email {
	
	private StringProperty direccion;
	
	public Email() {
		this.direccion = new SimpleStringProperty();
	}
	
	public Email(String direccion) {
		this.direccion = new SimpleStringProperty(direccion);
	}

	public StringProperty getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion.set(direccion);
	}

}
