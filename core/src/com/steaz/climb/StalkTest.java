package com.steaz.climb;

public class StalkTest {
	public static void main(String[] args) {
		Stalk stalk = new Stalk();

		for (int i = 0; i < 20; i++) {
			//System.out.println(stalk.getNextChunk().getChunkType());
		}

		checkStalk(stalk);
	}

	private static void checkStalk(Stalk stalk) {
		StalkChunk prevChunk = stalk.getNextChunk();
		StalkChunk nextChunk;
		
		if(prevChunk == null) {
			System.out.println("Empty Stalk");
			return;
		}
		// get next Chunk will never be null, so infinite loop here.
		for(int i = 100; i >= 0; i--) {
			nextChunk = stalk.getNextChunk();
			System.out.println("    Next Chunk Type: " + nextChunk.getChunkType());
			System.out.println("Previous Chunk Type: " + prevChunk.getChunkType());
			if (nextChunk.getChunkType() != ChunkType.NO_LEAF
					&& prevChunk.getChunkType() != ChunkType.NO_LEAF) {
				System.out.println("Invalid stalk: two left/rights ");
			}
		}
	}
}
