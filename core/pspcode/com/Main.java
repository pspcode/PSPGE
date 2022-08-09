package pspcode.com;

import pspcode.com.lwjgl.LwjglConfig;
import pspcode.com.lwjgl.LwjglWindow;
import pspcode.com.renderer.Shader;

public class Main {

	public static void main(String[] args) {
		
		// testing the lwjglWindow
		new LwjglWindow(new LwjglConfig(1280, 720, "Lwjgl Window"));
		
		// testing the shader
		new Shader("assets/shaders/default.glsl");
	}
}
