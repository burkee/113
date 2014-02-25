package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Asset {

	public static Texture texture_back;
	public static Sprite sprite_back;
	
	public static Texture texture_sheet;
	
	public static Texture sheet;
	public static TextureRegion[] sheet_frames;
	public static TextureRegion current_frame;
	public static Animation loading_animation;
	public static Animation bill;
	
	public static Texture texture_steve;
	public static Sprite steve; 
	
	public static Texture texture_bill;
	//public static Sprite bill; 
	
	public static void load(){
		
		texture_back = new Texture(Gdx.files.internal("data/background.png"));
		texture_back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite_back = new Sprite(texture_back);
		sprite_back.flip(false, true);
		
		texture_sheet = new Texture(Gdx.files.internal("3.png"));

		sheet = new Texture(Gdx.files.internal("3.png"));
		TextureRegion[][] temp = TextureRegion.split(sheet, 128, 128);
		sheet_frames = new TextureRegion[8];
		
		int index=0;
		for (int i=0; i<4;i++){
			for (int j=0; j<2; j++){
				sheet_frames[index++] = temp[i][j];
			}
		}
		
		for (int i=0; i<8;i++){
			sheet_frames[i].flip(false, true);
		}
		
		loading_animation = new Animation(.1F, sheet_frames);
		
		texture_steve = new Texture(Gdx.files.internal("data/shock2.png"));
		steve = new Sprite(texture_steve);
		
		texture_bill = new Texture(Gdx.files.internal("3.png"));
	//	bill = new Sprite(texture_bill);
		bill = new Animation(.1F, sheet_frames);
		
	}
}