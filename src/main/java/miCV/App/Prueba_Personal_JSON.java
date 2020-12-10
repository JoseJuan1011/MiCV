package miCV.App;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.hildan.fxgson.FxGson;

import com.google.gson.Gson;

import miCV.Conocimientos.Conocimiento;
import miCV.Conocimientos.subClasses.Idioma;
import miCV.Conocimientos.subClasses.Nivel;
import miCV.Contacto.Contacto;
import miCV.Contacto.subClasses.Email;
import miCV.Contacto.subClasses.Teléfono;
import miCV.Contacto.subClasses.TipoTeléfono;
import miCV.Contacto.subClasses.Web;
import miCV.Experiencia.Experiencia;
import miCV.Formacion.Titulo;
import miCV.Personal.Nacionalidad;
import miCV.Personal.Personal;
import miCV.mainController.MainController;

/*
Nacionalidad nacionalidad = new Nacionalidad("Española");
Nacionalidad nacionalidad_2 = new Nacionalidad("Inglesa");
ArrayList<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();
nacionalidades.add(nacionalidad);
nacionalidades.add(nacionalidad_2);
LocalDate FechaNacimiento = LocalDate.now();
//"1","Alex", "Iglesias",FechaNacimiento,"C/ Illo Juanes", "111110", "Manchester", "Inglaterra", nacionalidades
//Personal persona = new Personal("1","Alex", "Iglesias", FechaNacimiento, "C/ Illo Juanes", "111110", "Manchester", "Inglaterra", nacionalidades);
System.out.println(persona.toString());
*/

public class Prueba_Personal_JSON {
	
	public static void main(String[] args) {
		/*
		Nacionalidad nacionalidad = new Nacionalidad("Española");
		Nacionalidad nacionalidad_2 = new Nacionalidad("Inglesa");
		ArrayList<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();
		nacionalidades.add(nacionalidad);
		nacionalidades.add(nacionalidad_2);
		LocalDate FechaNacimiento = LocalDate.now();
		Personal persona = new Personal("1","Alex", "Iglesias", FechaNacimiento, "C/ Illo Juanes", 111110, "Manchester", "Inglaterra", nacionalidades);
		String json = MainController.convertToJson(persona);
		System.out.println(json);
		System.out.println("-------------------------------------");
		Personal result = new Personal();
		result = (Personal) MainController.convertFromJsonToObject(json, Personal.class);
		System.out.println(result.toString());
		*/
	}
}
