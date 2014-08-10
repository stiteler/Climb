package com.steaz.climb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

enum ChunkType {
	LEFT_LEAF, RIGHT_LEAF, NO_LEAF;
}

public class StalkChunk {
	private ChunkType chunkType;
	private Texture texture;

	public StalkChunk(ChunkType chunkType) {
		this.chunkType = chunkType;
		//generateTexture();
	}

	private void generateTexture() {
		switch (this.chunkType) {
		case LEFT_LEAF:
			new Texture(Gdx.files.internal("leftLeaf.png"));
			break;
		case RIGHT_LEAF:
			new Texture(Gdx.files.internal("rightLeaf.png"));
			break;
		case NO_LEAF:
			new Texture(Gdx.files.internal("noLeaf.png"));
			break;
		default:
			texture = new Texture(Gdx.files.internal("noLeaf.png"));
		}
	}

	public Texture getTexture() {
		return this.texture;
	}

	public ChunkType getChunkType() {
		return this.chunkType;
	}
}
