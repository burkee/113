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
import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen{
	OrthographicCamera camera;
	SpriteBatch batch;
	int tempSize;

	Sprite sprite_back; //background image
	
	Random rand;
	
	Vector3 touch;
	boolean touched=false;
	
	int spellHitSpotX,spellHitSpotY; //spot where mouse was clicked
	public int asteroidX,asteroidY=0; //coordinate of where asteroid animation runs 
	
	float stateTime; //resets on mouseclick
	float currentStateTime; //set to time of mouseclick
	float enemyStateTime; //continuous time
	float expST; //explosion
	
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	
	public GameScreen(myGame game){
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1920, 1080);
		
		batch = new SpriteBatch();
		rand = new Random();
		stateTime = 0F;
		
		touch = new Vector3();
		int c= 0;
		
		//creates array of enemies
		for (int i=0;i<50;i++)
			enemies.add(new Enemy(i*3, c+=70));
		
		//creates array of asteroids
		for (int i=0;i<30;i++)
			asteroids.add(new Asteroid());
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.95F, 1F, 1F, 1F);  //starts as black
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); //clears to white
		
		camera.update();
		
		stateTime += Gdx.graphics.getDeltaTime();
		enemyStateTime += Gdx.graphics.getDeltaTime();
		expST += Gdx.graphics.getDeltaTime();
		
		batch.setProjectionMatrix(camera.combined);
		update();
		generalUpdate(touch, camera);
		draw(delta);
		//System.out.println(stateTime + "         " + enemyStateTime + "      " + currentStateTime);
		
		
	}
	
	private void draw(float delta){
		batch.begin();
		
		//background
		batch.draw(Assets.sprite_back, 0, 0, 1920, 1080);
		
		//enemies
		//this sets all the enemies to be on the same animation image
		for (int i=0;i<enemies.size();i++)
			enemies.get(i).current_frame = enemies.get(i).loading_animation.getKeyFrame(enemyStateTime, true);
		//this draws the enemies
		tempSize = (int)enemyStateTime;
		for (int i=0;i<tempSize;i++) //tempSize used to be enemies.size() - tempSize allows newly drawn crabs to start from x=0
			batch.draw(enemies.get(i).current_frame, enemies.get(i).x, enemies.get(i).y);
		
		//asteroid
		for (int i=0;i<asteroids.size();i++)
					asteroids.get(i).current_frame = Assets.asteroid.getKeyFrame(stateTime, false);
				//if (touched == true)
					//while (asteroidY > spellHitSpotY)
				//for (int i=0;i<asteroids.size();i++)
		int count=0;
		
		if (!asteroids.get(count).image.isAnimationFinished(stateTime) && touched==true){
			batch.draw(asteroids.get(count).current_frame, asteroidX+=1.5, asteroidY+=3);
			}
		else
			touched=false;
		count++;	
		
		batch.end();
	}
	
	private void update(){
		
		// update enemies
		for(int i = 0; i < tempSize; i++) {  //used to be enemies.size() - tempSize allows newly drawn crabs to start from x=0
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
	
	//collision for asteroid vs enemies
			for(int i = 0; i < enemies.size(); i++) {
				Enemy e = enemies.get(i);
				if(e.bounds.contains(spellHitSpotX, spellHitSpotY)) {
					if ((int)stateTime == (int)1.1){  //Time it takes for asteroid to hit enemy
						enemies.remove(i);
						enemies.get(i).shouldRemove=true;
						i--;
						break;
					}
				}
			}
		
}

	private void generalUpdate(Vector3 touch, OrthographicCamera camera) {
		// TODO Auto-generated method stub
//		if (Gdx.input.isKeyPressed(Keys.W)){
//			asteroid.bounds.y -= 5;
//		}
//		if (Gdx.input.isKeyPressed(Keys.S)){
//			asteroid.bounds.y += 5;
//		}	
//		if (Gdx.input.isKeyPressed(Keys.D)){
//			asteroid.bounds.x += 5;
//		}	
//		if (Gdx.input.isKeyPressed(Keys.A)){
//			asteroid.bounds.x -= 5;
//		}	
		if (Gdx.input.justTouched()){
			currentStateTime = stateTime;
			stateTime=0;
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			asteroidX = (int)touch.x - 64;
			asteroidY = (int)touch.y - 254;
			spellHitSpotX = (int)touch.x - 64;
			spellHitSpotY = (int)touch.y;
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
