package org.pspcode.com.entity.anim;

import pspcode.com.components.Sprite;

public class Frame {

	public Sprite sprite;
    public float frameTime;

    public Frame() {};
    
    public Frame(Sprite sprite, float frameTime) {
        this.sprite = sprite;
        this.frameTime = frameTime;
    }
}
