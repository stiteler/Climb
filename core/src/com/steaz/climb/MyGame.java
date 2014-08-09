package com.steaz.climb;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MyGame extends Game {
	
	private static final int GAME_WIDTH = 720;
	private static final int GAME_HEIGHT = 1280;
	
	private MenuScreen menuScreen;
	private GameScreen gameScreen;
	
	@Override
	public void create () {

		menuScreen = new MenuScreen(this);
		gameScreen = new GameScreen(this);
		Gdx.graphics.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
		
		setScreen(menuScreen);
	}

	@Override
	public void render () {
		super.render();
	}
	
	public void gotoMenu() {
		setScreen(menuScreen);
	}
	
	public void startNewGame() {
		setScreen(gameScreen);
	}
}
