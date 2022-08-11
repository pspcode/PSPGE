package pspcode.com.util;

import java.util.HashMap;
import java.util.Map;

import pspcode.com.jade.Sound;
import pspcode.com.renderer.Shader;
import pspcode.com.renderer.Texture;

public class AssetPool {
	
	/**
	 * 
	 * <key> String is the path where your shader will be found
	 * <value> Shader is the shader that your <key>path gets
	 * 
	 * for you to have access to the <value>Shader of shaders 
	 * use the getShader(<key>path) method
	 */
	private static Map<String, Shader> shaders = new HashMap<>();
	/**
	 * 
	 * <key> String is the path where your texture will be found
	 * <value> Texture is the Texture that your <key>path gets
	 * 
	 * for you to have access to the <value>Texture of textures 
	 * use the getTexture(<key>path) method
	 */
	private static Map<String, Texture> textures = new HashMap<>();
	/**
	 * 
	 * <key> String is the path where your sound will be found
	 * <value> Sound is the sound that your <key>path gets
	 * 
	 * for you to have access to the <value>Sound of sounds
	 * use the getSound(<key>path) method
	 */
	private static Map<String, Sound> sounds = new HashMap<>();
	

	/**
	 * 
	 * accessed through the <list>shader list
	 * 
	 * @param <key>filepath is the path where your <value>Shader is
	 * @return the shader that is in <key>filepath
	 */
	public static Shader getShader(String filepath) {
		return shaders.get(filepath);
	}
	
	/** @param filepath is the path where your list of shader
	 * <list>shaders will try to find and load the contents of this shaders
	 * @return the shader that is in the <key>filepath path
	 */
	public static Shader loadShader(String filepath) {
		Shader shader = new Shader(filepath);
		shaders.put(filepath, shader);
		return shader;
	}
	

	/**
	 * 
	 * accessed through the <list>textures list
	 * 
	 * @param <key>filepath is the path where your <value>Texture is
	 * @return the texture that is in <key>filepath
	 */
	public static Texture getTexture(String filepath) {
		return textures.get(filepath);
	}
	
	/** @param filepath is the path where your list of texture
	 * <list>textures will try to find and load the contents of this texture
	 * @return the texture that is in the <key>filepath path
	 */
	public static Texture loadTexture(String filepath) {
		Texture texture = new Texture();
		texture.init(filepath);
		textures.put(filepath, texture);
		return texture;
	}
	
	/**
	 * 
	 * Loops are disabled in this method
	 * 
	 * @param filepath is the path where your list of sounds
	 * <list>sounds will try to find and load the contents of this sound
	 * @return the sound that is in the <key>filepath path
	 */
	public static Sound loadSound(String filepath) {
		Sound sound = new Sound(filepath, false);
		sounds.put(filepath, sound);
		return sound;
	}
	
	/**
	 * 
	 * Loops are selectable in this method
	 * 
	 * @param filepath is the path where your list of
	 * <list>sounds will try to find and load the contents of this sound
	 * @param loops defines whether your sound will be repeated or not
	 * @return the sound that is in the <key>filepath path
	 */
	public static Sound loadSound(String filepath, boolean loops) {
		Sound sound = new Sound(filepath, loops);
		sounds.put(filepath, sound);
		return sound;
	}
	
	/**
	 * 
	 * accessed through the <list>sounds list
	 * 
	 * @param <key>filepath is the path where your <value>Sound is
	 * @return the sound that is in <key>filepath
	 */
	public static Sound getSound(String filepath) {
		return sounds.get(filepath);
	}
	
	/**
	 * removes all <value>Texture from assetpool texture list
	 */
	public static void clearTextures() {
		textures.clear();
	}
	

	/**
	 * removes all <value>Sound from assetpool sounds list
	 */
	public static void clearSounds() {
		sounds.clear();
	}
	

	/**
	 * removes all <value>Shader from assetpool shaders list
	 */
	public static void clearShaders() {
		shaders.clear();
	}
}
