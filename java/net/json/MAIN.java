package net.json;

public class MAIN {

	public static final String modID = "eotg:", name = "", texture = "", textureSide = "_side", textureTop = "_top", textureBottom = "";
	public static final boolean DEBUG = true, isBlock = true, isTool = false, isFence = false, isSlab = false, isStairs = false, isPortal = false, isGrass = false;

	public static void main(String[] s) {
		if(!isPortal)
			JSON1.init();
		if(isBlock) {
			if(isStairs){
				INNERSTAIRS.init();
				OUTERSTAIRS.init();
			}
			if(isPortal) {
				PORTALEW.init();
				PORTALNS.init();
			}
			JSON2.init();
			JSON3.init();
		}
	}
}