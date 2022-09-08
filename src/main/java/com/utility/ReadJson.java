package com.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONObject;

public class ReadJson {
	
	public static String jsonFile = "RCB.json";
	
	public String readRCBjsonFile() throws IOException {

		ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource(jsonFile).getFile());
		String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
		return content;
	}
	 
}
