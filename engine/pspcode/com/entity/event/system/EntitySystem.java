package pspcode.com.entity.event.system;

import java.util.ArrayList;
import java.util.List;

import pspcode.com.entity.Entity;
import pspcode.com.entity.event.Event;

public class EntitySystem {
	
	private static List<EntityListener> listeners = new ArrayList<>();

	public static void addListener(EntityListener listener) {
		listeners.add(listener);
	}
	
	public static void onEvent(Entity entity, Event event) {
		for (EntityListener listener : listeners) {
			listener.onEvent(entity, event);
		}
	}
}
