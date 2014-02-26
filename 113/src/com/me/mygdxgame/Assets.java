package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static Texture texture_back;
	public static Sprite sprite_back;
	
	public static Texture texture_sheet;
	public static Sprite sprite_1;
	public static Sprite sprite_2;
	public static Sprite sprite_3;
	public static Sprite sprite_4;
	
	public static Texture sheet, expSheet;
	public static TextureRegion[] sheet_frames, expSheetFrames;
	public static TextureRegion current_frame,expFrame;
	public static Animation loading_animation;
	public static Animation asteroid,explosion;
	
	public static Texture texture_steve;
	public static Sprite steve; 
	
	public static Texture texture_asteroid;
	//public static Sprite asteroid; 
	
	public static void load(){
		
		texture_back = new Texture(Gdx.files.internal("data/background.png"));
		texture_back.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		sprite_back = new Sprite(texture_back);
		sprite_back.flip(false, true);
		
		texture_sheet = new Texture(Gdx.files.internal("data/asteroid.png"));
		sprite_1 = new Sprite(texture_sheet, 0, 0, 64, 64);
		
		sheet = new Texture(Gdx.files.internal("data/asteroid.png"));
		TextureRegion[][] temp = TextureRegion.split(sheet, 128, 128);
		sheet_frames = new TextureRegion[21];
		
		int index=0;
		for (int i=0; i<7;i++){
			for (int j=0; j<3; j++){
				sheet_frames[index++] = temp[i][j];
			}
		}
		
		for (int i=0; i<18;i++){
			sheet_frames[i].flip(false, true);
		}
		
		loading_animation = new Animation(.1F, sheet_frames);
		
		texture_steve = new Texture(Gdx.files.internal("data/shock2.png"));
		steve = new Sprite(texture_steve);
		
		texture_asteroid = new Texture(Gdx.files.internal("data/asteroid.png"));
	//	asteroid = new Sprite(texture_asteroid);
		asteroid = new Animation(.1F, sheet_frames);
		
		//EXPLOSION
		texture_sheet = new Texture(Gdx.files.internal("data/explosion.png"));
		
		sheet = new Texture(Gdx.files.internal("data/explosion.png"));
		temp = TextureRegion.split(sheet, 128, 128);
		sheet_frames = new TextureRegion[8];
		
		index=0;
		for (int i=0; i<2;i++){
			for (int j=0; j<4; j++){
				sheet_frames[index++] = temp[i][j];
			}
		}
		
		for (int i=0; i<8;i++){
			sheet_frames[i].flip(false, true);
		}
		
		explosion = new Animation(.1F,sheet_frames);
		
	}
}