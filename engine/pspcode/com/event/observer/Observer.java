package pspcode.com.event.observer;

import org.pspcode.com.components.GameObject;

import pspcode.com.event.Event;

public interface Observer {
	
	void onNotify(GameObject obj, Event event);
}
