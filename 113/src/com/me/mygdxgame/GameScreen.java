package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen{

	private myGame game;
	OrthographicCamera camera;
	SpriteBatch batch;
	
	Texture texture_back;
	Sprite sprite_back;
	
	public GameScreen(myGame game){
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1920, 1080);
		
		batch = new SpriteBatch();
		
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		Gdx.gl.glClearColor(1F, 1F, 1F, 1F);  //starts as black
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); //clears to white
		
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		batch.draw(Assets.sprite_back, 0, 0, 1920, 1080);
		batch.draw(Assets.sprite_1, 256, 256);
		batch.end();
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
		
	}

}
