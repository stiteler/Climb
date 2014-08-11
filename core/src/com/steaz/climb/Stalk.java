package com.steaz.climb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Stalk {
	private static final int NUM_CHUNKS = 10;
	
	private Queue<StalkChunk> chunks;
	private Random rand;
	private ChunkType prevChunkType;
	
	
	Stalk() {
		rand = new Random();
		chunks = generateChunks();
	}

	private Queue<StalkChunk> generateChunks() {
		Queue<StalkChunk> chunks = new LinkedList<StalkChunk>();
		
		for(int i = 0; i < NUM_CHUNKS; i++) {
			StalkChunk newChunk = generateChunk();
			chunks.add(newChunk);
			prevChunkType = newChunk.getChunkType();
			
			//need at least 1 blank chunk in between any type other than NO_LEAF
			if(newChunk.getChunkType() != ChunkType.NO_LEAF) {
				chunks.add(new StalkChunk(ChunkType.NO_LEAF));
				prevChunkType = ChunkType.NO_LEAF;
				continue;
			}
			
		}
		return chunks;
	}

	private StalkChunk generateChunk() {
		if(prevChunkType != ChunkType.NO_LEAF) {
			prevChunkType = ChunkType.NO_LEAF;
			return new StalkChunk(ChunkType.NO_LEAF);
		}
		
		int chunkTypeOrdinality = rand.nextInt(ChunkType.values().length);
		ChunkType chunkType = ChunkType.values()[chunkTypeOrdinality];
		StalkChunk newChunk = new StalkChunk(chunkType);
		prevChunkType = newChunk.getChunkType();
		return newChunk;
	}
	
	public void discardChunk() {
		chunks.remove();
		chunks.add(generateChunk());
	}
	
	public StalkChunk getNextChunk() {
		StalkChunk next = chunks.poll();
		chunks.add(generateChunk());
		return next;
	}
	
	public List<ChunkType> getStalkView() {
		// copy the queue and grab all the chunks
		List<ChunkType> stalkView = new ArrayList<ChunkType>(NUM_CHUNKS);
		Iterator it = chunks.iterator();
		while(it.hasNext()) {
			StalkChunk next = (StalkChunk) it.next();
			stalkView.add(next.getChunkType());
		}

		return stalkView;
	}
	
}
