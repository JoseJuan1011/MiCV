package miCV.Conocimientos.subClasses;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Idioma {
	
	private StringProperty certificacion;
	
	public Idioma(String certificacion) {
		this.certificacion = new SimpleStringProperty(certificacion);
	}

	public Idioma() {
		this.certificacion = new SimpleStringProperty();
	}

	public StringProperty getCertificacion() {
		return certificacion;
	}

	public void setCertificacion(String certificacion) {
		this.certificacion.set(certificacion);
	}
	
	

}
