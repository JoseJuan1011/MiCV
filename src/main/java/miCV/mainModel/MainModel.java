package miCV.mainModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import miCV.Personal.Nacionalidad;
import miCV.mainController.MainController;
import miCV.mainUtils.Cv;

public class MainModel {

	private File ArchivoCv;
	
	private Cv cv;
	
	public MainModel() {
		ArchivoCv = new File("\\src\\main\\resources\\DefaultCvLocation\\Untitled.cv");
		cv = new Cv();
	}
	
	public MainModel(File ArchivoCv, Cv cv) {
		this.ArchivoCv = ArchivoCv;
		this.cv = cv;
	}

	public File getArchivoCv() {
		return ArchivoCv;
	}

	public void setArchivoCv(File archivoCv) {
		ArchivoCv = archivoCv;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}
}
