package pspcode.com;

import pspcode.com.lwjgl.LwjglConfig;
import pspcode.com.lwjgl.LwjglWindow;

public class Main {

	public static void main(String[] args) {
		
		// lwjgl window initialize the window
		new LwjglWindow(new LwjglConfig(1280, 720, "Lwjgl Window"));
	}
}
