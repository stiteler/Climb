package com.steaz.climb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen implements Screen {

	private MyGame game;
	private SpriteBatch spriteBatch;
	private	Texture testImage;
	
	
	MenuScreen(MyGame game) {
		this.game = game;
	}
	
	@Override
	public void render(float delta) {
		//update and draw stuff
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		spriteBatch.begin();
		spriteBatch.draw(testImage, 0, 0);
		spriteBatch.end();
		
		
		// Don't need a whole inputListener here, for now. Can just check if there was just a touch event. 
		if(Gdx.input.justTouched()) {
			System.out.println("Just touched");
			game.startNewGame();
		}
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// called when the screen is invoked with game.showScreen();
		spriteBatch = new SpriteBatch();
		testImage = new Texture(Gdx.files.internal("GameArt.png"));
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
