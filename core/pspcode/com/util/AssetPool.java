package pspcode.com.util;

import java.util.HashMap;
import java.util.Map;

import pspcode.com.renderer.Shader;
import pspcode.com.renderer.Texture;

public class AssetPool {
	
	private static Map<String, Shader> shaders = new HashMap<>();
	private static Map<String, Texture> textures = new HashMap<>();
	
	public static Shader getShader(String filepath) {
		return shaders.get(filepath);
	}
	
	public static Shader loadShader(String filepath) {
		Shader shader = new Shader(filepath);
		shaders.put(filepath, shader);
		return shader;
	}
	
	public static Texture getTexture(String filepath) {
		return textures.get(filepath);
	}
	
	public static Texture loadTexture(String filepath) {
		Texture texture = new Texture(filepath);
		textures.put(filepath, texture);
		return texture;
	}
	
	public static void clearTextures() {
		textures.clear();
	}
	
	public static void clearShaders() {
		shaders.clear();
	}
}
