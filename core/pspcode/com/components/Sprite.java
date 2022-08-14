package pspcode.com.components;

import org.joml.Vector2f;

import pspcode.com.renderer.Texture;

public class Sprite {

    private float width, height;

    private Texture texture = null;
    
    private String name;
    
    private Vector2f[] texCoords = {
                new Vector2f(1, 1),
                new Vector2f(1, 0),
                new Vector2f(0, 0),
                new Vector2f(0, 1)
        };
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    
    public Texture getTexture() {
        return this.texture;
    }

    public Vector2f[] getTexCoords() {
        return this.texCoords;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setTexture(Texture tex) {
        this.texture = tex;
    }

    public void setTexCoords(Vector2f[] texCoords) {
        this.texCoords = texCoords;
    }

    public int getTexId() {
        return texture == null ? -1 : texture.getId();
    }
}