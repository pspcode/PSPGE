package pspcode.com.event;

public class Event {

	private EventType type;
	
	public Event(EventType type) {
		this.type = type;
	}
	
	public EventType getEventType() {
		return type;
	}
}
