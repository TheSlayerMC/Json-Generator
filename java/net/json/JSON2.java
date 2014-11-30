package net.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSON2 {

	private String name;
	private static final JSON2 instance = new JSON2(MAIN.name, MAIN.isBlock, MAIN.isFence, MAIN.isSlab, MAIN.isStairs, MAIN.isPortal, MAIN.isGrass);

	protected String fileName;
	protected String path;
	protected BufferedWriter writer;

	private boolean isBlock, fence, slab, stairs, portal, grass;

	public JSON2(String f, boolean block, boolean isFence, boolean isSlab, boolean isStairs, boolean isPortal, boolean isGrass) {
		name = f;
		isBlock = block;
		fence = isFence;
		grass = isGrass;
		slab = isSlab;
		stairs = isStairs;
		portal = isPortal;
		String s = MAIN.DEBUG ? "C:/Users/User/Desktop/test" : "C:/Users/User/Desktop/JSONS/eotg/blockstates";
		String s1 = MAIN.DEBUG ? "/" + f + " BLOCK STATE.json" : "/" + f + ".json";
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
		if(stairs){
			writeToFile("{");
			writeToFile("	\"variants\": {");
			writeToFile("		\"facing=east,half=bottom,shape=straight\":  { \"model\": \"" + MAIN.modID + name + "\" },");
			writeToFile("		\"facing=west,half=bottom,shape=straight\":  { \"model\": \"" + MAIN.modID + name + "\", \"y\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=south,half=bottom,shape=straight\": { \"model\": \"" + MAIN.modID + name + "\", \"y\": 90, \"uvlock\": true },");
			writeToFile("		\"facing=north,half=bottom,shape=straight\": { \"model\": \"" + MAIN.modID + name + "\", \"y\": 270, \"uvlock\": true },");
			writeToFile("		\"facing=east,half=bottom,shape=outer_right\":  { \"model\": \"" + MAIN.modID + name + "Outer\" },");
			writeToFile("		\"facing=west,half=bottom,shape=outer_right\":  { \"model\": \"" + MAIN.modID + name + "Outer\", \"y\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=south,half=bottom,shape=outer_right\": { \"model\": \"" + MAIN.modID + name + "Outer\", \"y\": 90, \"uvlock\": true },");
			writeToFile("		\"facing=north,half=bottom,shape=outer_right\": { \"model\": \"" + MAIN.modID + name + "Outer\", \"y\": 270, \"uvlock\": true },");
			writeToFile("		\"facing=east,half=bottom,shape=outer_left\":  { \"model\": \"" + MAIN.modID + name + "Outer\", \"y\": 270, \"uvlock\": true },");
			writeToFile("		\"facing=west,half=bottom,shape=outer_left\":  { \"model\": \"" + MAIN.modID + name + "Outer\", \"y\": 90, \"uvlock\": true },");
			writeToFile("		\"facing=south,half=bottom,shape=outer_left\": { \"model\": \"" + MAIN.modID + name + "Outer\" },");
			writeToFile("		\"facing=north,half=bottom,shape=outer_left\": { \"model\": \"" + MAIN.modID + name + "Outer\", \"y\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=east,half=bottom,shape=inner_right\":  { \"model\": \"" + MAIN.modID + name + "Inner\" },");
			writeToFile("		\"facing=west,half=bottom,shape=inner_right\":  { \"model\": \"" + MAIN.modID + name + "Inner\", \"y\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=south,half=bottom,shape=inner_right\": { \"model\": \"" + MAIN.modID + name + "Inner\", \"y\": 90, \"uvlock\": true },");
			writeToFile("		\"facing=north,half=bottom,shape=inner_right\": { \"model\": \"" + MAIN.modID + name + "Inner\", \"y\": 270, \"uvlock\": true },");
			writeToFile("		\"facing=east,half=bottom,shape=inner_left\":  { \"model\": \"" + MAIN.modID + name + "Inner\", \"y\": 270, \"uvlock\": true },");
			writeToFile("		\"facing=west,half=bottom,shape=inner_left\":  { \"model\": \"" + MAIN.modID + name + "Inner\", \"y\": 90, \"uvlock\": true },");
			writeToFile("		\"facing=south,half=bottom,shape=inner_left\": { \"model\": \"" + MAIN.modID + name + "Inner\" },");
			writeToFile("		\"facing=north,half=bottom,shape=inner_left\": { \"model\": \"" + MAIN.modID + name + "Inner\", \"y\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=east,half=top,shape=straight\":  { \"model\": \"" + MAIN.modID + name + "\", \"x\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=west,half=top,shape=straight\":  { \"model\": \"" + MAIN.modID + name + "\", \"x\": 180, \"y\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=south,half=top,shape=straight\": { \"model\": \"" + MAIN.modID + name + "\", \"x\": 180, \"y\": 90, \"uvlock\": true },");
			writeToFile("		\"facing=north,half=top,shape=straight\": { \"model\": \"" + MAIN.modID + name + "\", \"x\": 180, \"y\": 270, \"uvlock\": true },");
			writeToFile("		\"facing=east,half=top,shape=outer_right\":  { \"model\": \"" + MAIN.modID + name + "Outer\", \"x\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=west,half=top,shape=outer_right\":  { \"model\": \"" + MAIN.modID + name + "Outer\", \"x\": 180, \"y\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=south,half=top,shape=outer_right\": { \"model\": \"" + MAIN.modID + name + "Outer\", \"x\": 180, \"y\": 90, \"uvlock\": true },");
			writeToFile("		\"facing=north,half=top,shape=outer_right\": { \"model\": \"" + MAIN.modID + name + "Outer\", \"x\": 180, \"y\": 270, \"uvlock\": true },");
			writeToFile("		\"facing=east,half=top,shape=outer_left\":  { \"model\": \"" + MAIN.modID + name + "Outer\", \"x\": 180, \"y\": 90, \"uvlock\": true },");
			writeToFile("		\"facing=west,half=top,shape=outer_left\":  { \"model\": \"" + MAIN.modID + name + "Outer\", \"x\": 180, \"y\": 270, \"uvlock\": true },");
			writeToFile("		\"facing=south,half=top,shape=outer_left\": { \"model\": \"" + MAIN.modID + name + "Outer\", \"x\": 180, \"y\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=north,half=top,shape=outer_left\": { \"model\": \"" + MAIN.modID + name + "Outer\", \"x\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=east,half=top,shape=inner_right\":  { \"model\": \"" + MAIN.modID + name + "Inner\", \"x\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=west,half=top,shape=inner_right\":  { \"model\": \"" + MAIN.modID + name + "Inner\", \"x\": 180, \"y\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=south,half=top,shape=inner_right\": { \"model\": \"" + MAIN.modID + name + "Inner\", \"x\": 180, \"y\": 90, \"uvlock\": true },");
			writeToFile("		\"facing=north,half=top,shape=inner_right\": { \"model\": \"" + MAIN.modID + name + "Inner\", \"x\": 180, \"y\": 270, \"uvlock\": true },");
			writeToFile("		\"facing=east,half=top,shape=inner_left\":  { \"model\": \"" + MAIN.modID + name + "Inner\", \"x\": 180, \"y\": 90, \"uvlock\": true },");
			writeToFile("		\"facing=west,half=top,shape=inner_left\":  { \"model\": \"" + MAIN.modID + name + "Inner\", \"x\": 180, \"y\": 270, \"uvlock\": true },");
			writeToFile("		\"facing=south,half=top,shape=inner_left\": { \"model\": \"" + MAIN.modID + name + "Inner\", \"x\": 180, \"y\": 180, \"uvlock\": true },");
			writeToFile("		\"facing=north,half=top,shape=inner_left\": { \"model\": \"" + MAIN.modID + name + "Inner\", \"x\": 180, \"uvlock\": true }");
			writeToFile("	}");
			writeToFile("}");
		} 
		
		else if(portal) {
			writeToFile("{");
			writeToFile("	\"variants\": {");
			writeToFile("		\"axis=z\": { \"model\": \"" + MAIN.modID + name + "_ew\" },");
			writeToFile("		\"axis=x\": { \"model\": \"" + MAIN.modID + name + "_ns\" }");
			writeToFile("	}");
			writeToFile("}");
		}
		
		else if(grass) {
			writeToFile("{");
			writeToFile("	\"variants\": {");
			writeToFile("		\"normal\": { \"model\": \"" + MAIN.modID + name + "\"}");
			writeToFile("	}");
			writeToFile("}");

		} else {
			writeToFile("{");
			writeToFile("	\"variants\": {");
			writeToFile("		\"normal\": { \"model\": \"" + MAIN.modID + name + "\"}");
			writeToFile("	}");
			writeToFile("}");
		}
	}
}