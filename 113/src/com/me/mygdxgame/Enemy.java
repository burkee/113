package com.me.mygdxgame;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Enemy{
	
	private SpriteBatch sb = new SpriteBatch();;
	public static TextureRegion current_frame;
	Texture texture = new Texture(Gdx.files.internal("data/crab_walking.png"));
    boolean shouldRemove = false;
    
    Texture sheet;
	TextureRegion[] sheet_frames;
	
	static Animation loading_animation;
	Animation bill;
	
	public int x, y;
	public final Rectangle bounds;
	
	public Enemy(int x, int y){
		Random r = new Random();
		int randY = r.nextInt(700);  //random 0-700
		this.y = randY;  //starts the enemies at random heights 0-700
		this.x = 0;   //Starts enemies from left side of screen
		 bounds = new Rectangle(x-128, randY, 64, 64);

        sheet = new Texture(Gdx.files.internal("data/crab_walking.png"));
		TextureRegion[][] temp = TextureRegion.split(sheet, 85, 64);
		sheet_frames = new TextureRegion[24];
		
		int index=0;
		for (int i=0; i<4;i++){
			for (int j=0; j<6; j++){
				sheet_frames[index++] = temp[i][j];
			}
		}
		
		for (int i=0; i<24;i++){
			sheet_frames[i].flip(false, true);
		}
		
		loading_animation = new Animation(.1F, sheet_frames);
    }
	
public void update() {
		bounds.x +=1;   //moves the hitbox along x axis
		x += 1; //moves the animation across the x axis
		//y += 3;
}
	
//	public void draw(OrthographicCamera camera, float st){
//		sb.setProjectionMatrix(camera.combined);
//		sb.begin();
//		Enemy.current_frame = Enemy.loading_animation.getKeyFrame(st, false);
//		sb.draw(Enemy.current_frame, 0, 0);
//		sb.end();
//	}
}
