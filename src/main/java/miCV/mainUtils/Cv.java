package miCV.mainUtils;

import java.util.ArrayList;
import java.util.List;

import miCV.Conocimientos.Conocimiento;
import miCV.Contacto.Contacto;
import miCV.Experiencia.Experiencia;
import miCV.Formacion.Titulo;
import miCV.Personal.Personal;

public class Cv {
	
	private Personal personal;
	
	private Contacto contacto;
	
	private List<Titulo> formacion;
	
	private List<Experiencia> experiencia;
	
	private List<Conocimiento> conocimientos;
	
	public Cv() {
		this.personal = new Personal();
		this.contacto = new Contacto();
		this.formacion = new ArrayList<Titulo>();
		this.experiencia = new ArrayList<Experiencia>();
		this.conocimientos = new ArrayList<Conocimiento>();
	}

	public Cv(Personal personal, Contacto contacto, ArrayList<Titulo> formacion, ArrayList<Experiencia> experiencia, ArrayList<Conocimiento> conocimientos) {
		this.personal = personal;
		this.contacto = contacto;
		this.formacion = formacion;
		this.experiencia = experiencia;
		this.conocimientos = conocimientos;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public List<Titulo> getFormacion() {
		return formacion;
	}

	public void setFormacion(ArrayList<Titulo> formacion) {
		this.formacion = formacion;
	}

	public List<Experiencia> getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(ArrayList<Experiencia> experiencia) {
		this.experiencia = experiencia;
	}

	public List<Conocimiento> getConocimientos() {
		return conocimientos;
	}

	public void setConocimientos(ArrayList<Conocimiento> conocimientos) {
		this.conocimientos = conocimientos;
	}

	@Override
	public String toString() {
		return "Cv [personal=" + personal.toString() + ", contacto=" + contacto.toString() + ", formacion=" + formacion.toString() + ", experiencia="
				+ experiencia.toString() + ", conocimientos=" + conocimientos.toString() + "]";
	}
}
