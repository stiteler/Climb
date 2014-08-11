package com.steaz.climb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverScreen implements Screen {
	
	private MyGame game;
	private SpriteBatch spriteBatch;
	private BitmapFont font;
	
	GameOverScreen(MyGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		if(Gdx.input.justTouched()) {
			game.startNewGame();
		}
		
		spriteBatch.begin();
		font.draw(spriteBatch, "Game Over! Press any key to restart", 100, 640);
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		spriteBatch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.setScale(2);
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
	}

}
