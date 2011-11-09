package ru.semikov.sea.ai;

abstract public class AIBase {

	protected AI ai;
	protected int x;
	protected int y;
	protected int dx;
	protected int dy;
	
	public AIBase(AI ai) {
		this.ai = ai;
	}

	abstract int doShot();
	
	protected void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	protected void setDirection(int x, int y) {
		this.dx = x;
		this.dy = y;
	}

}
