package pspcode.com.input;

public class GamepadListener {
													
	
	/**
	 * 14 buttons by default to press. 
	 * The amount of buttons vary from gamepad to gamepad.
	 		* 
	 		* 	
	 		* -> DualShock4 has 11 buttons to press
	 		* -> Ipega has 12 buttons to press
	 		* 	
	 		* 	
	 		*
	 * 		         (0) (1) (2)...........
	 *  Buttons: ->  [R2][R1][L1]..........
	 *  	
	 */
	private boolean[] gamepadButtonPressed;
	
	public GamepadListener() { 
		// For default, the gamepad has 14 buttons
		gamepadButtonPressed = new boolean[14];
	}
	
	
	public boolean isPressed(int gmpKey) {
		return gamepadButtonPressed[gmpKey];
	}
	
	// Supported Gamepad types
/**	public class DualShock4 extends GamepadListener {
		
		public final int BUTTON_AMOUNT = 11;
		
		public DualShock4() {
			gamepadButtonPressed = new boolean[BUTTON_AMOUNT];
		}

		@Override
		public boolean isPressed(int gmpKey) {
			return gamepadButtonPressed[gmpKey];
		}
	}*/
}
// DualShock4 is disabled at moment
