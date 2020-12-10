package miCV.mainUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.hildan.fxgson.FxGson;

import com.google.gson.Gson;

public class JSONUtils {
	
	private static Gson fxGson = FxGson.coreBuilder().setPrettyPrinting().create();
	
	public JSONUtils() {
		
	}
	
	public static Cv jsonToObject(File archivoCv) throws IOException {
		String json = FileUtils.readFileToString(archivoCv, Charset.forName("UTF-8"));
		Cv cv = fxGson.fromJson(json, Cv.class);
		return cv;
	}
	
	public static String objectToJson(Cv cv) {
		return fxGson.toJson(cv);
	}

}
