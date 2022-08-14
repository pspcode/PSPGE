package org.pspcode.com.components;

public abstract class Component {
	
    private static int ID_COUNTER = 0;
    private int uid = -1;

    public transient GameObject gameObject = null;

    public void start() {

    }

    public void update(float dt) {

    }

    public void editorUpdate(float dt) {

    }
    

    public void destroy() {

    }
    
    public void generateId() {
        if (this.uid == -1) {
            this.uid = ID_COUNTER++;
        }
    }
    
    public int getUid() {
    	return uid;
    }
    
    public static void init(int maxID) {
    	ID_COUNTER = maxID;
    }

}
