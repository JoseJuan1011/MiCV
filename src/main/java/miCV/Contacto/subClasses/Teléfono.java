package miCV.Contacto.subClasses;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teléfono {
	
	private TipoTeléfono tipoTelefono; 
	private StringProperty numero;
	
	public Teléfono(TipoTeléfono tipoTelefono, String string) {
		this.tipoTelefono = tipoTelefono;
		this.numero = new SimpleStringProperty(string); 
	}

	public Teléfono() {
		this.tipoTelefono = TipoTeléfono.DOMICILIO;
		this.numero = new SimpleStringProperty();
	}

	public TipoTeléfono getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(TipoTeléfono tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	public StringProperty getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero.set(numero);;
	}

}
