package pspcode.com.lwjgl.monitor;

public interface LwjglVideo {
	
	/**
	 * 
	 * to get the resolution just make the WIDTH + HEIGHT
	 * ex: width of the window is 1920, and the height is 1080
	 * just make 1920 + 1080, it will be: 3000, so, to get both resolutions
	 * you can do  getResolution() - height and then you'll get the width
	 * the same thing to height, getResolution() - width and then you'll get the height
	 * 
	 * @return the width of the window + height of the window
	 */
	int getResolution();
	
	/**
	 * 
	 * to get the center of the window, just make ->
	 * the value of resolution of the window / 2
	 * 
	 * the center of the window is basicly the resolution / 2
	 * 
	 * @return the center of the window
	 */
	int getCenter();
}
