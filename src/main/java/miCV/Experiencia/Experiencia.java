package miCV.Experiencia;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Experiencia {
	
	private StringProperty desde;
	private StringProperty hasta;
	private StringProperty denominacion;
	private StringProperty empleador;
	
	public Experiencia () {
		
	}
	
	public Experiencia (LocalDate desde, LocalDate hasta, String denominacion, String empleador) {
		this.desde = new SimpleStringProperty(desde.toString());
		this.hasta = new SimpleStringProperty(hasta.toString());
		this.denominacion = new SimpleStringProperty(denominacion);
		this.empleador = new SimpleStringProperty(empleador);
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
		this.denominacion.set(denominacion);;
	}

	public StringProperty getEmpleador() {
		return empleador;
	}

	public void setEmpleador(String empleador) {
		this.empleador.set(empleador);
	}

	@Override
	public String toString() {
		return "Experiencia [desde=" + desde.get() + ", hasta=" + hasta.get() + ", denominacion=" + denominacion.get() + ", empleador="
				+ empleador.get() + "]";
	}
	
}
