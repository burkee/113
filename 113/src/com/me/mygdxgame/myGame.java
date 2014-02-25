package com.me.mygdxgame;

import com.badlogic.gdx.Game;

public class myGame extends Game {

	public GameScreen gscreen;
	
	public void create(){
		Assets.load();
		
		
		gscreen = new GameScreen(this);
		
		setScreen(gscreen);
	}
}
