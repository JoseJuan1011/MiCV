package miCV.Conocimientos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import miCV.Conocimientos.subClasses.Idioma;
import miCV.Conocimientos.subClasses.Nivel;

public class Conocimiento {
	
	private StringProperty denominación;
	private Idioma idioma;
	private Nivel nivel;
	
	public Conocimiento () {
		this.denominación = new SimpleStringProperty();
		this.idioma = new Idioma();
		this.nivel = null;
	}
	
	public Conocimiento(String denominacion, Nivel nivel) {
		this.denominación = new SimpleStringProperty(denominacion);
		this.nivel = nivel;
		this.idioma = new Idioma();
	}
	
	public Conocimiento(String denominacion,Idioma idioma, Nivel nivel) {
		this.denominación = new SimpleStringProperty(denominacion);
		this.idioma = idioma;
		this.nivel = nivel;
	}

	public StringProperty getDenominación() {
		return denominación;
	}

	public void setDenominación(String denominación) {
		this.denominación.set(denominación);
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "Conocimiento [denominación=" + denominación.get() + ", idioma=" + idioma.getCertificacion().get() + ", nivel=" + nivel + "]";
	}
	
	
}
