package com.me.mygdxgame;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen{
	OrthographicCamera camera;
	SpriteBatch batch;

	Texture texture_back;
	Sprite sprite_back;
	public int asteroidX,asteroidY=0;
	Random rand;
	float state_time;
	Vector3 touch;
	boolean touched=false;
	Asteroid asteroid;
	int spellHitSpotX,spellHitSpotY;
	
	public float time = 0;
	
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	
	public GameScreen(myGame game){
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1920, 1080);
		
		batch = new SpriteBatch();
		rand = new Random();
		state_time = 0F;
		
		touch = new Vector3();
		asteroid = new Asteroid();
		int c= 0;
		for (int i=0;i<30;i++)
			enemies.add(new Enemy(i*3, c+=30));
		for (int i=0;i<30;i++)
			asteroids.add(new Asteroid());
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.95F, 1F, 1F, 1F);  //starts as black
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); //clears to white
		
		camera.update();
		
		state_time += Gdx.graphics.getDeltaTime();
		batch.setProjectionMatrix(camera.combined);
		update();
		generalUpdate(touch, camera);
		draw();
		
		
	}
	
	private void draw(){
		batch.begin();
		
		//background
		batch.draw(Assets.sprite_back, 0, 0, 1920, 1080);
		
		//asteroid
		for (int i=0;i<asteroids.size();i++)
			asteroids.get(i).current_frame = Assets.asteroid.getKeyFrame(state_time, false);
		//if (touched == true)
			//while (asteroidY > spellHitSpotY)
		//for (int i=0;i<asteroids.size();i++)
		int count=0;
				batch.draw(asteroids.get(count).current_frame, asteroidX+=.5, asteroidY+=3);
		count++;
		
		//enemies
		for (int i=0;i<enemies.size();i++)
			enemies.get(i).current_frame = enemies.get(i).loading_animation.getKeyFrame(state_time, true);
		for (int i=0;i<enemies.size();i++)
			batch.draw(enemies.get(i).current_frame, enemies.get(i).x, enemies.get(i).y);
		
		batch.end();
	}
	
	private void update(){
		
		// update enemies
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update();
//			if(enemies.get(i).shouldRemove) {
//				enemies.remove(i);
//				i--;
//				enemies.get(i).shouldRemove = false;
//			}
		}
		
		checkCollisions();

	}
	
private void checkCollisions() {
		
			for(int i = 0; i < enemies.size(); i++) {
				Enemy e = enemies.get(i);
				if(e.bounds.contains(asteroidX, asteroidY)) {
					enemies.remove(i);
					enemies.get(i).shouldRemove=true;
					i--;
					break;
				}
			}
		
}

	private void generalUpdate(Vector3 touch, OrthographicCamera camera) {
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Keys.W)){
			asteroid.bounds.y -= 5;
		}
		if (Gdx.input.isKeyPressed(Keys.S)){
			asteroid.bounds.y += 5;
		}	
		if (Gdx.input.isKeyPressed(Keys.D)){
			asteroid.bounds.x += 5;
		}	
		if (Gdx.input.isKeyPressed(Keys.A)){
			asteroid.bounds.x -= 5;
		}	
		if (Gdx.input.justTouched()){
			state_time=0;
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			asteroidX = (int)touch.x - 64;
			asteroidY = (int)touch.y - 254;
			spellHitSpotX = (int)touch.x - 64;
			spellHitSpotY = (int)touch.y - 254;
			touched = true;
			//if (asteroid.bounds.y > asteroidY)
				//asteroid.bounds.y += 5;
	}
//		if (Gdx.input.justTouched()){
//			//asteroid.bounds.x -= 5;
//			touched = true;
//			//touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//			camera.unproject(touch); //translates touch to screen size
//		}
		//asteroid.bounds.x += 5;
		
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		batch.dispose();
	}

}
