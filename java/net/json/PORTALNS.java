package net.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PORTALNS {

	private String name;
	private static final PORTALNS instance = new PORTALNS(MAIN.name, MAIN.texture);

	protected String fileName;
	protected String path, texture;
	protected BufferedWriter writer;

	public PORTALNS(String f, String tex) {
		name = f;
		String s = MAIN.DEBUG ? "C:/Users/User/Desktop/test" : "C:/Users/User/Desktop/JSONS/eotg/models/block";
		String s1 = MAIN.DEBUG ? "/" + f + " NS.json" : "/" + f + "_ns.json";
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
		writeToFile("	\"textures\": {");
		writeToFile("		\"particle\": \"" + MAIN.modID + "blocks/" + name + "\",");
		writeToFile("		\"portal\": \"" + MAIN.modID + "blocks/" + name + "\",");
		writeToFile("	},");
		writeToFile("	\"elements\": [");
		writeToFile("		{  \"from\": [ 0, 0, 6 ],");
		writeToFile("			\"to\": [ 16, 16, 10 ],");
		writeToFile("			\"faces\": {");
		writeToFile("				\"north\": { \"uv\": [ 0, 0, 16, 16 ], \"texture\": \"#portal\" },");
		writeToFile("				\"south\": { \"uv\": [ 0, 0, 16, 16 ], \"texture\": \"#portal\" }");
		writeToFile("			}");
		writeToFile("		}");
		writeToFile("	]");
		writeToFile("}");
	}
}