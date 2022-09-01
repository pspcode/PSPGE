package pspcode.com.frame;

import org.pspcode.com.components.GameObject;
import org.pspcode.com.components.Component;

import java.util.*;

public class Frameskip extends Component {
  private float frameTime = 0.05f;
  private GameObject frameObject = new GameObject("FrameObject");
  
  private boolean enable = false;
 
  private List<Frameskip> skips = new ArrayList<>();
 
  public void enable() {
    this.enable = true;
    frameObject.addComponent(this);
    
    skips.add(this);
  }
 
  public void disable() {
    this.enable = false;
    frameTime = 0.0f;
   
    frameObject.removeComponent(this);
   
    skips.remove(this);
  }
 
  public void skipFrame(int frame) {
    int index = 0;
    int currentFrame = 0;
   
    if (index == 0) return;
    if (currentFrame <= 0) return;
   
    for (int current = currentFrame; current < frame; current++) {
        skips.get(current).enable();
        currentFrame = frame;
        currentFrame++;
        index++;
     
       int[] frames = new int[frame];
       
       for (int i = 0; i < frames.length; i++) {
           if (frames[i] <= 0) frames[i] = current;
           frames[index] = i;
       }
       
    }
  }
}
