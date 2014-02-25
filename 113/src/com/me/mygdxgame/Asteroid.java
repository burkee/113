package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.math.Rectangle;

public class Asteroid {

	public static TextureRegion current_frame;

	public final Animation image;
	public final Rectangle bounds;
	
	public Asteroid(){
		image = Assets.asteroid;
		bounds = new Rectangle(10, 10, 128, 128);
		
		
	}
}
