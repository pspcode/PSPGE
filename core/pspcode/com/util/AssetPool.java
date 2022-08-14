package pspcode.com.util;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import pspcode.com.components.Spritesheet;
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
	 * <key> String is the path where your spritesheet will be found
	 * <value> Spritesheet is the spritesheet that your <key>path gets
	 * 
	 * for you to have access to the <value>Spritesheet of spritesheets
	 * use the getSpritesheet(<key>path) method
	 */
	private static Map<String, Spritesheet> spritesheets = new HashMap<>();
	
	/**
	 * 
	 * accessed through the <list>shader list
	 * 
	 * @param <key>filepath is the path where your <value>Shader is
	 * @return the shader that is in <key>filepath
	 */
	public static Shader getShader(String resourceName) {
		File file = new File(resourceName);
		
		if (file.getAbsolutePath().contains(resourceName)) {
			return shaders.get(file.getAbsolutePath());
		} else {
			Shader shader = new Shader(resourceName);
			shader.use();
			shaders.put(resourceName, shader);
			return shader;
		}
	}

	/**
	 * 
	 * accessed through the <list>sounds list
	 * 
	 * @param <key>resourceName is the path where your <value>Texture is
	 * @return the texture that is in <key>filepath
	 */
	public static Texture getTexture(String resourceName) {
		File file = new File(resourceName);
		
		if (file.getAbsolutePath().contains(resourceName)) {
			return textures.get(file.getAbsolutePath());
		} else {
			Texture texture = new Texture();
			texture.init(resourceName);
			textures.put(resourceName, texture);
			return texture;
		}
	}
	
	/**
	 * 
	 * accessed through the <list>sounds list
	 * 
	 * @param <key>resourceName is the path where your <value>Sound is
	 * @param <key>loops defines wheiter it will be repeat or not
	 * @return the sound that is in <key>filepath
	 */
	public static Sound getSound(String resourceName, boolean loops) {
		File file = new File(resourceName);
		
		if (file.getAbsolutePath().contains(resourceName)) {
			return sounds.get(file.getAbsolutePath());
		} else {
			Sound sound = new Sound(resourceName, loops);
			sounds.put(resourceName, sound);
			return sound;
		}
	}
	
	/**
	 * 
	 * accessed through the <list>sounds list
	 * 
	 * @param <key>resourceName is the path where your <value>Spritesheet is
	 * @return the spritesheet that is in <key>filepath
	 */
	public static Spritesheet getSpritesheet(String resourceName) {
        File file = new File(resourceName);
        if (!AssetPool.spritesheets.containsKey(file.getAbsolutePath())) {
            assert false : "Error: Tried to access spritesheet '" + resourceName + "' and it has not been added to asset pool.";
        }
        return AssetPool.spritesheets.getOrDefault(file.getAbsolutePath(), null);
    }
	
	/**
	 * 
	 * @param resourceName is the path where your <value>Spritesheet is
	 * @param spritesheet is the spritesheet to add
	 */
	 public static void addSpritesheet(String resourceName, Spritesheet spritesheet) {
	        File file = new File(resourceName);
	        if (!AssetPool.spritesheets.containsKey(file.getAbsolutePath())) {
	            AssetPool.spritesheets.put(file.getAbsolutePath(), spritesheet);
	        }
	    }
	/**
	 * 
	 * @param soundFile is the file where your <value>Sound is
	 * @param loops defines wheiter the sound will be repeat or not
	 * @return to the sound that was added
	 */
	 public static Sound addSound(String soundFile, boolean loops) {
	        File file = new File(soundFile);
	        if (sounds.containsKey(file.getAbsolutePath())) {
	            return sounds.get(file.getAbsolutePath());
	        } else {
	            Sound sound = new Sound(file.getAbsolutePath(), loops);
	            AssetPool.sounds.put(file.getAbsolutePath(), sound);
	            return sound;
	        }
	    }
	/**
	 * @return all sounds of the list
	 */
	 public static Collection<Sound> getAllSounds() {
	        return sounds.values();
	    }
	/**
	 * removes all <value>Texture from assetpool textures list
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
	
	/**
	 * removes all <value>Spritesheet from assetpool spritesheets list
	 */
	public static void clearSpritesheets() {
		spritesheets.clear();
	}
}
