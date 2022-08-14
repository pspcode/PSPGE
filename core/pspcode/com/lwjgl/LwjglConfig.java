package pspcode.com.lwjgl;

public class LwjglConfig {
	
	private int width, height;
	
	private String title;

	/**
	 * LwjglConfig is the configuration to run the {@code LwjglWindow}
	 * 
	 * The attributes are acessible through the methods getters and setters
	 * 
	 * @param width of the window
	 * @param height of the window
	 * @param title of the window
	 */
	public LwjglConfig(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	

}
