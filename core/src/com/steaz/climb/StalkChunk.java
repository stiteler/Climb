package com.steaz.climb;

enum ChunkType {
	LEFT_LEAF, RIGHT_LEAF, NO_LEAF;
}

public class StalkChunk {
	private ChunkType chunkType;

	public StalkChunk(ChunkType chunkType) {
		this.chunkType = chunkType;
	}

	public ChunkType getChunkType() {
		return this.chunkType;
	}
}
