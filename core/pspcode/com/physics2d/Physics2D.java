package pspcode.com.physics2d;

public class Physics2D {
	
	private static Physics2D instance = null;
	
	public static Physics2D get() {
		if (instance == null) instance = new Physics2D();
		return instance;
	}
}
