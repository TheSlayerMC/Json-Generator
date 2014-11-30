package net.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSON1 {

	private String name;
	private static final JSON1 instance = new JSON1(MAIN.name, MAIN.texture, MAIN.isBlock, MAIN.isTool, MAIN.isFence, MAIN.isSlab, MAIN.isStairs, MAIN.isPortal, MAIN.isGrass);

	protected String fileName;
	protected String path, texture;
	protected BufferedWriter writer;
	private boolean isBlock, isTool, fence, slab, stairs, portal, grass;

	public JSON1(String f, String tex, boolean block, boolean isTool, boolean isFence, boolean isSlab, boolean isStairs, boolean isPortal, boolean isGrass) {
		name = f;
		grass = isGrass;
		isBlock = block;
		fence = isFence;
		slab = isSlab;
		stairs = isStairs;
		portal = isPortal;
		this.isTool = isTool;
		String s = MAIN.DEBUG ? "C:/Users/User/Desktop/test" : "C:/Users/User/Desktop/JSONS/eotg/models/item";
		String s1 = MAIN.DEBUG ? "/" + f + " ITEM MODEL.json" : "/" + f + ".json";
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
		if(isBlock && !stairs) {
			writeToFile("{");
			writeToFile("	\"parent\": \"" + MAIN.modID + "block/" + name + "\",");
			writeToFile("	\"display\": {");
			writeToFile("		\"thirdperson\": {");
			writeToFile("			\"rotation\": [ 10, -45, 170 ],");
			writeToFile("			\"translation\": [ 0, 1.5, -2.75 ],");
			writeToFile("			\"scale\": [ 0.375, 0.375, 0.375 ]");
			writeToFile("		}");
			writeToFile("	}");
			writeToFile("}");
		} 
		
		else if(stairs) {
			writeToFile("{");
			writeToFile("	\"parent\": \"" + MAIN.modID + "block/" + name + "\",");
			writeToFile("	\"display\": {");
			writeToFile("		\"thirdperson\": {");
			writeToFile("			\"rotation\": [ 10, -45, 170 ],");
			writeToFile("			\"translation\": [ 0, 1.5, -2.75 ],");
			writeToFile("			\"scale\": [ 0.375, 0.375, 0.375 ]");
			writeToFile("		},");
			writeToFile("		\"gui\": {");
			writeToFile("			\"rotation\": [ 0, 180, 0 ]");
			writeToFile("		}");
			writeToFile("	}");
			writeToFile("}");
		}
		
		else if(isTool) {
			writeToFile("{");
			writeToFile("	\"parent\": \"builtin/generated\",");
			writeToFile("	\"textures\": {");
			writeToFile("		\"layer0\": \"" + MAIN.modID + "items/" + name + "\"");
			writeToFile("	},");
			writeToFile("	\"display\": {");
			writeToFile("		\"thirdperson\": {");
			writeToFile("			\"rotation\": [ 0, 90, -35 ],");
			writeToFile("			\"translation\": [ 0, 1.25, -3.5 ],");
			writeToFile("			\"scale\": [ 0.85, 0.85, 0.85 ]");
			writeToFile("		},");
			writeToFile("		\"firstperson\": {");
			writeToFile("			\"rotation\": [ 0, -135, 25 ],");
			writeToFile("			\"translation\": [ 0, 4, 2 ],");
			writeToFile("			\"scale\": [ 1.7, 1.7, 1.7 ]");
			writeToFile("		}");
			writeToFile("	}");
			writeToFile("}");
		} else {
			writeToFile("{");
			writeToFile("	\"parent\": \"builtin/generated\",");
			writeToFile("	\"textures\": {");
			writeToFile("		\"layer0\": \"" + MAIN.modID + "items/" + name + "\"");
			writeToFile("	},");
			writeToFile("	\"display\": {");
			writeToFile("		\"thirdperson\": {");
			writeToFile("			\"rotation\": [ -90, 0, 0 ],");
			writeToFile("			\"translation\": [ 0, 1, -3 ],");
			writeToFile("			\"scale\": [ 0.55, 0.55, 0.55 ]");
			writeToFile("		},");
			writeToFile("		\"firstperson\": {");
			writeToFile("			\"rotation\": [ 0, -135, 25 ],");
			writeToFile("			\"translation\": [ 0, 4, 2 ],");
			writeToFile("			\"scale\": [ 1.7, 1.7, 1.7 ]");
			writeToFile("		}");
			writeToFile("	}");
			writeToFile("}");
		}
	}
}