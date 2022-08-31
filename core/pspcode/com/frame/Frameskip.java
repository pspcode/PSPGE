package pspcode.com.frame;

import org.pspcode.com.components;

public class Frameskip {
 private float frameTime = 0.05f;
 private GameObject frameObject = new GameObject("FrameObject");
  
 private boolean frameSkipEnable = false;
  
 public Frameskip() {
    
    this.frameSkipEnable = true;
    if (frameSkipEnable) {
      frameTime = 0.0f; 
    }
 }
}
