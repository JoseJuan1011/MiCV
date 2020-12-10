package miCV.Formacion;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Titulo {

	private StringProperty desde;
	private StringProperty hasta;
	private StringProperty denominacion;
	private StringProperty organizador;
	
	public Titulo () {
		this.desde = new SimpleStringProperty();
		this.hasta = new SimpleStringProperty();
		this.denominacion = new SimpleStringProperty();
		this.organizador = new SimpleStringProperty();
	}
	
	public Titulo(LocalDate desde,LocalDate hasta, String denominacion, String organizador) {
		this.desde= new SimpleStringProperty(desde.toString());
		this.hasta= new SimpleStringProperty(hasta.toString());
		this.denominacion = new SimpleStringProperty(denominacion);;
		this.organizador= new SimpleStringProperty(organizador);
	}

	public StringProperty getDesde() {
		return desde;
	}

	public void setDesde(LocalDate desde) {
		this.desde.set(desde.toString());
	}

	public StringProperty getHasta() {
		return hasta;
	}

	public void setHasta(LocalDate hasta) {
		this.hasta.set(hasta.toString());
	}

	public StringProperty getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion.set(denominacion);
	}

	public StringProperty getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador.set(organizador);
	}

	@Override
	public String toString() {
		return "Titulo [desde=" + desde.get() + ", hasta=" + hasta.get() + ", denominacion=" + denominacion.get() + ", organizador="
				+ organizador.get() + "]";
	}
	
	
}
