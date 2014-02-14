package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {

	public static Texture texture_back;
	public static Sprite sprite_back;
	
	public static Texture texture_sheet;
	public static Sprite sprite_1;
	public static Sprite sprite_2;
	public static Sprite sprite_3;
	public static Sprite sprite_4;
	
	public static void load(){
		
		texture_back = new Texture(Gdx.files.internal("data/background.png"));
		texture_back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_back = new Sprite(texture_back);
		sprite_back.flip(false, true);
		
		texture_sheet = new Texture(Gdx.files.internal("data/shock2.png"));
		sprite_1 = new Sprite(texture_sheet, 0, 0, 64, 64);
	}
}
	