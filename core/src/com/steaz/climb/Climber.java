package com.steaz.climb;

enum Side {
	LEFT, RIGHT;
}

public class Climber {
	private Side side;
	
	public Climber(Side side) {
		this.side = side;
	}
	
	public Side getSide() {
		return this.side;
	}
	
	public void setSide(Side side) {
		this.side = side;
	}
}
