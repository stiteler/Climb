package com.steaz.climb;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen, InputProcessor {
	
	private MyGame game;
	private SpriteBatch spriteBatch;
	private Stalk stalk;
	private Texture rightLeafTexture;
	private Texture leftLeafTexture;
	private Texture noLeafTexture;
	private Texture backgroundTexture;
	private static final int stalkX = 168;
	private static final int stalkHeight = 128;
	private boolean stalkChanged;
	private List<ChunkType> stalkView;
	

	public GameScreen(MyGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		spriteBatch = new SpriteBatch();
		stalk = new Stalk();
		backgroundTexture = new Texture(Gdx.files.internal("background.png"));
		rightLeafTexture = new Texture(Gdx.files.internal("rightLeaf.png"));
		leftLeafTexture = new Texture(Gdx.files.internal("leftLeaf.png"));
		noLeafTexture = new Texture(Gdx.files.internal("noLeaf.png"));
		stalkView = stalk.getStalkView();
		stalkChanged = false;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		updateGameState();
		
		spriteBatch.begin();
		spriteBatch.draw(backgroundTexture, 0, 0);
		drawStalkView();
		spriteBatch.end();
		
	}

	private void drawStalkView() {
		int stalkY = 0;
		for(int i = 0; i < 10; i++) {
			switch(stalkView.get(i)) {
			case RIGHT_LEAF:
				spriteBatch.draw(rightLeafTexture, stalkX, stalkY);
				break;
			case LEFT_LEAF:
				spriteBatch.draw(leftLeafTexture, stalkX, stalkY);
				break;
			case NO_LEAF:
				spriteBatch.draw(noLeafTexture, stalkX, stalkY);
				break;
			}
			stalkY += stalkHeight;
		}
	}

	private void updateGameState() {
		if(stalkChanged == true) {
			// do stuff for game logic.
			System.out.println("Updating game state");
			stalkView = stalk.getStalkView();
			stalkChanged = false;
		}
		
	}

	private void touchedRightScreen() {
		System.out.println("Touched Right Screen");
		stalkChanged = true;
		
	}

	private void touchedLeftScreen() {
		System.out.println("Touched Left Screen");
		stalkChanged = true;
		
	}
	
	@Override
	public void resize(int width, int height) {
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

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(screenX < 360) {
			touchedLeftScreen();
		} else {
			touchedRightScreen();
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
