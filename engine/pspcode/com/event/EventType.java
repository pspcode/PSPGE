package pspcode.com.event;

import java.util.HashMap;
import java.util.Map;

public enum EventType {

	// gamepad stuff
	GAMEPAD_BUTTON_PRESSED("input"),
	GAMEPAD_AXIS_ROTATE("input"),
	GAMEPAD_CONNECTED("connection"),
	
	// keyboard stuff
	KEYBOARD_BUTTON_PRESSED("input"),
	
	// mouse stuff
	MOUSE_BUTTON_PRESSED("input"),
	MOUSE_DRAGGING("input"),
	
	// collision stuff
	ON_COLLISION("physic"),
	BODY_CONTACT("physic");
	
	
	private String category = "";
	
	private Map<String, EventType> events = new HashMap<>();
	
	EventType(String category) {
		this.category = category;
		
		setupCategory();
		
	}
	
	public void setupCategory() {
		events.put(GAMEPAD_BUTTON_PRESSED.getCategory(), GAMEPAD_BUTTON_PRESSED);
		events.put(GAMEPAD_AXIS_ROTATE.getCategory(), GAMEPAD_AXIS_ROTATE);
		events.put(GAMEPAD_CONNECTED.getCategory(), GAMEPAD_CONNECTED);
		events.put(KEYBOARD_BUTTON_PRESSED.getCategory(), KEYBOARD_BUTTON_PRESSED);
		
		// mouse setup (category: "input")
		events.put(MOUSE_BUTTON_PRESSED.getCategory(), MOUSE_BUTTON_PRESSED);
		events.put(MOUSE_DRAGGING.getCategory(), MOUSE_DRAGGING);
		
		
		// collision setup (category: "physic")
		events.put(ON_COLLISION.getCategory(), ON_COLLISION);
		events.put(BODY_CONTACT.getCategory(), BODY_CONTACT);
	}
	
	public String getCategory() {
		return category;
	}
	
	public EventType get(String category) {
		return events.get(category);
	}
}
