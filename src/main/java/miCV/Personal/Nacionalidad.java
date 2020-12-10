package miCV.Personal;

public class Nacionalidad {
	
	private String denominacion;
	
	public Nacionalidad() {
		this.denominacion="";
	}
	
	public Nacionalidad(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	@Override
	public String toString() {
		return "Nacionalidad [denominacion=" + denominacion + "]";
	}

}
