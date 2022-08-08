package pspcode.com;

import pspcode.com.renderer.Shader;
import pspcode.com.screen.AppConfig;
import pspcode.com.screen.LwjglWindow;

public class Main {

	public static void main(String[] args) {
		new LwjglWindow(new AppConfig(1280, 720, "Lwjgl Window"));
		
		new Shader("assets/shaders/default.glsl");
	}
}
