package pspcode.com.screen;

public abstract class Application {

	// when the application starts
	public abstract void onStart();
	
	// is updating in all frames of your application
	public abstract void render();
	
	// free the memory (texture dispose ...)
	public abstract void free();
}
