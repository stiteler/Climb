package com.steaz.climb;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen, InputProcessor {
	
	private static final int stalkX = 168;
	private static final int stalkHeight = 128;
	private static final int climberY = 32;
	private static final int climberXLeft = 272;
	private static final int climberXRight = 416;
	
	private MyGame game;
	private SpriteBatch spriteBatch;
	private Climber climber;
	private Stalk stalk;
	private Texture climberRightTexture;
	private Texture climberLeftTexture;
	private Texture rightLeafTexture;
	private Texture leftLeafTexture;
	private Texture noLeafTexture;
	private Texture backgroundTexture;
	private BitmapFont startFont;
	private boolean stalkChanged;
	private List<ChunkType> stalkView;
	private boolean isPlaying = false;
	

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
		climberLeftTexture = new Texture(Gdx.files.internal("climberLeft.png"));
		climberRightTexture = new Texture(Gdx.files.internal("climberRight.png"));
		startFont = new BitmapFont();
		startFont.setColor(Color.WHITE);
		startFont.setScale(2);
		stalkView = stalk.getStalkView();
		
		// climber can't spawn on a leaf.
		if(stalkView.get(0) == ChunkType.LEFT_LEAF) {
			climber = new Climber(Side.RIGHT);
		} else {
			climber = new Climber(Side.LEFT);
		}
		
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
		drawClimber();
		if(!isPlaying) {
			startFont.draw(spriteBatch, "press any key to start game", 100, 640);
		}
		spriteBatch.end();
		
	}

	private void drawClimber() {
		Side side = climber.getSide();
		if(side == Side.LEFT) {
			spriteBatch.draw(climberLeftTexture, climberXLeft, climberY);
		} else {
			spriteBatch.draw(climberRightTexture, climberXRight, climberY);
		}
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
			
			//change model			
			stalk.discardChunk();
			stalkView = stalk.getStalkView();
			stalkChanged = false;
			
			// check win/loss state
			checkClimberCollision();
		}
		
	}

	private void checkClimberCollision() {
		if(stalkView.get(0) == ChunkType.LEFT_LEAF && climber.getSide() == Side.LEFT) {
			gameOver();
		}
		
		if(stalkView.get(0) == ChunkType.RIGHT_LEAF && climber.getSide() == Side.RIGHT) {
			gameOver();
		}
	}

	private void gameOver() {
		game.gameOver();
	}

	private void touchedRightScreen() {
		isPlaying = true;
		System.out.println("Touched Right Screen");
		if(climber != null) {
			climber.setSide(Side.RIGHT);
		}
		stalkChanged = true;
	}

	private void touchedLeftScreen() {
		isPlaying = true;
		System.out.println("Touched Left Screen");
		if(climber != null) {
			climber.setSide(Side.LEFT);
		}
		stalkChanged = true;
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
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
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
	
}
