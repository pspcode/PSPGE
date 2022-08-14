package pspcode.com.event.observer;

import java.util.ArrayList;
import java.util.List;

import org.pspcode.com.components.GameObject;

import pspcode.com.event.Event;

public class EventSystem {
	
    private static List<Observer> observers = new ArrayList<>();

    public static void addObserver(Observer observer) {
        observers.add(observer);
    }

    public static void notify(GameObject obj, Event event) {
        for (Observer observer : observers) {
            observer.onNotify(obj, event);
        }
    }
}
