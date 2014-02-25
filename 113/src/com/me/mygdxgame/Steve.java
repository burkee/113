package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Steve {

	public final Sprite image;
	public final Rectangle bounds;
	
	public Steve(){
		image = Assets.steve;
		bounds = new Rectangle(10, 10, 500, 500);
		
	}
}
