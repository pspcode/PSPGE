package pspcode.com.entity.event.system;

import pspcode.com.entity.Entity;
import pspcode.com.entity.event.Event;

public interface EntityListener {

	void onEvent(Entity entity, Event event);
}
