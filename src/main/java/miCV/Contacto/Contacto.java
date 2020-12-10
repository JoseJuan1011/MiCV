package miCV.Contacto;

import java.util.ArrayList;
import java.util.List;

import miCV.Contacto.subClasses.Email;
import miCV.Contacto.subClasses.Teléfono;
import miCV.Contacto.subClasses.Web;

public class Contacto {
	
	private List<Teléfono> telefono;
	private List<Email> email;
	private List<Web> web;
	
	public Contacto() {
		this.telefono = new ArrayList<Teléfono>();
		this.email = new ArrayList<Email>();
		this.web = new ArrayList<Web>();
	}
	
	public Contacto(ArrayList<Teléfono> telefono, ArrayList<Email> email, ArrayList<Web> web) {
		this.telefono = telefono;
		this.email = email;
		this.web = web;
	}

	public List<Teléfono> getTelefono() {
		return telefono;
	}

	public void setTelefono(ArrayList<Teléfono> telefono) {
		this.telefono = telefono;
	}

	public List<Email> getEmail() {
		return email;
	}

	public void setEmail(ArrayList<Email> email) {
		this.email = email;
	}

	public List<Web> getWeb() {
		return web;
	}

	public void setWeb(ArrayList<Web> web) {
		this.web = web;
	}

	@Override
	public String toString() {
		return "Contacto [Telefono=" + telefono.toString() + ", email=" + email.toString() + ", web=" + web.toString() + "]";
	}
	
}
