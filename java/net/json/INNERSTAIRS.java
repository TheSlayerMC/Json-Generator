package net.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class INNERSTAIRS {

	private static final INNERSTAIRS instance = new INNERSTAIRS(MAIN.name, MAIN.texture);

	protected String fileName;
	protected String path, texture;
	protected BufferedWriter writer;

	public INNERSTAIRS(String f, String tex) {
		texture = tex;
		String s = MAIN.DEBUG ? "C:/Users/User/Desktop/test" : "C:/Users/User/Desktop/JSONS/eotg/models/block";
		String s1 = MAIN.DEBUG ? "/" + f + "INNER BLOCK MODEL.json" : "/" + f + "Inner.json";
		this.fileName = s1;
		this.path = s;
		File file = null;
		file = new File(path + fileName);
		try {
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void init(){
		instance.addNames();
		try {
			instance.writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeToFile(String text){
		try {
			writer.write(text + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addNames() {
		writeToFile("{");
		writeToFile("	\"parent\": \"block/stairs\",");
		writeToFile("	\"textures\": {");
		writeToFile("		\"bottom\": \"" + MAIN.modID + "blocks/" + texture + "\",");
		writeToFile("		\"top\": \"" + MAIN.modID + "blocks/" + texture + "\",");
		writeToFile("		\"side\": \"" + MAIN.modID + "blocks/" + texture + "\"");
		writeToFile("	}");
		writeToFile("}");
	}
}