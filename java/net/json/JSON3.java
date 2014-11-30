package net.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSON3 {

	private String name;
	private static final JSON3 instance = new JSON3(MAIN.name, MAIN.texture, MAIN.isBlock, MAIN.isFence, MAIN.isSlab, MAIN.isStairs, MAIN.isPortal, MAIN.isGrass);

	protected String fileName;
	protected String path, texture;
	protected BufferedWriter writer;

	private boolean isBlock, fence, slab, stairs, portal, grass;

	public JSON3(String f, String tex, boolean block, boolean isFence, boolean isSlab, boolean isStairs, boolean isPortal, boolean isGrass) {
		name = f;
		grass = isGrass;
		texture = tex;
		isBlock = block;
		fence = isFence;
		slab = isSlab;
		stairs = isStairs;
		portal = isPortal;
		String s = MAIN.DEBUG ? "C:/Users/User/Desktop/test" : "C:/Users/User/Desktop/JSONS/eotg/models/block";
		String s1 = MAIN.DEBUG ? "/" + f + " BLOCK MODEL.json" : "/" + f + ".json";
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
		if(stairs) {
			writeToFile("{");
			writeToFile("	\"parent\": \"block/stairs\",");
			writeToFile("	\"textures\": {");
			writeToFile("		\"bottom\": \"" + MAIN.modID + "blocks/" + texture + "\",");
			writeToFile("		\"top\": \"" + MAIN.modID + "blocks/" + texture + "\",");
			writeToFile("		\"side\": \"" + MAIN.modID + "blocks/" + texture + "\"");
			writeToFile("	}");
			writeToFile("}");
		} 

		else if(grass) {
			writeToFile("{");
			writeToFile("	\"parent\": \"" + MAIN.modID + "block/grass\",");
			writeToFile("	\"textures\": {");
			writeToFile("		\"particle\": \"" + MAIN.modID + "blocks/" + MAIN.textureBottom + "\",");
			writeToFile("		\"bottom\": \"" + MAIN.modID + "blocks/" + MAIN.textureBottom + "\",");
			writeToFile("		\"top\": \"" + MAIN.modID + "blocks/" + MAIN.textureTop + "\",");
			writeToFile("		\"side\": \"" + MAIN.modID + "blocks/" + MAIN.textureSide + "\"");
			writeToFile("	}");
			writeToFile("}");
		} else if(!portal){
			writeToFile("{");
			writeToFile("	\"parent\": \"block/cube_all\",");
			writeToFile("	\"textures\": {");
			writeToFile("		\"all\": \"" + MAIN.modID + "blocks/" + name + "\"");
			writeToFile("	}");
			writeToFile("}");
		}
	}
}