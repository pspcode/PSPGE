package pspcode.com.renderer;

import static org.lwjgl.opengl.GL11.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.stb.STBImage.stbi_load;
import org.lwjgl.BufferUtils;

// Credits for GamesWithGabe (https://www.youtube.com/c/GamesWithGabe)

/**
 * Texture2D class, an class that help to create and load textures
 * to your application.
 * 
 * @anotherResource {@code Shader}
 * @resourceManager {@code AssetPool}
 * 
 * @type Resources
 * @api OpenGL
 * @author PSP Code/Suffler Engine
 */
public class Texture {
	
	private int texID;
	
	private String filepath;
	
	private int texWidth, texHeight;
	
	/**
	 * @param filepath is the path of your path
	 */
	public Texture(String filepath) {
		this.filepath = filepath;
		
		// generate texture on GPU
		texID = glGenTextures();
		glBindTexture(GL_TEXTURE_2D, texID);
		
		// set texture parameters
		// repeat image in both directions
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
		
		// when stretching the image (pixelate)
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		
		// when shrinking an image (pixelate)
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		
		IntBuffer width = BufferUtils.createIntBuffer(1);
		IntBuffer height = BufferUtils.createIntBuffer(1);
		IntBuffer channels = BufferUtils.createIntBuffer(1);
		ByteBuffer image = stbi_load(filepath, width, height, channels, 0);
		
		texWidth = width.get(0);
		texHeight = height.get(0);
		
		if (image != null) {
			if (channels.get(0) == 3) {
				glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width.get(0), height.get(0), 0,
						GL_RGB, GL_UNSIGNED_BYTE, image);
			} else if (channels.get(0) == 4) {
				glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width.get(0), height.get(0), 0,
						GL_RGBA, GL_UNSIGNED_BYTE, image);
			} else {
				assert false : "Error: (Texture) unknown number of channels '" + channels.get(0) + "'";
			}
		} else {
			assert false : "Error: (Texture) could not load the texture in the '" + filepath + "'";
		}
	}
	
	/**
	 * 
	 * @return to width of the texture
	 */
	public int getWidth() {
		return texWidth;
	}
	
	/**
	 * 
	 * @return to height of the texture
	 */
	public int getHeight() {
		return texHeight;
	}
	
	/**
	 * 
	 * @return to the path of the texture
	 */
	public String getFilePath() {
		return filepath;
	}

}
