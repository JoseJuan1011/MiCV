package miCV.Contacto.subClasses;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Web {
	
	private StringProperty url;
	
	public Web() {
		this.url=new SimpleStringProperty();
	}
	
	public Web(String url) {
		this.url=new SimpleStringProperty(url);
	}

	public StringProperty getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url.set(url);
	}
	
}
