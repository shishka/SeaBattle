package ru.semikov.sea.logic;

public class Cell {
	public final static int CELL_WATER = 1;
	public final static int CELL_BORDER = 2;
	public final static int CELL_WELL = 3;
	public final static int CELL_INJURED = 4;
	public final static int CELL_KILLED = 5;
	public final static int CELL_MISSED = 6;
	
	/**
	 * @uml.property  name="x"
	 */
	public int x;
	/**
	 * @uml.property  name="y"
	 */
	public int y;
	/**
	 * @uml.property  name="state"
	 */
	private int state;
	/**
	 * @uml.property  name="ship"
	 * @uml.associationEnd  inverse="listCells:ru.semikov.sea.logic.Ship"
	 */
	private Ship ship;
	/**
	 * @uml.property  name="mark"
	 */
	private boolean mark;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		this.state = CELL_WATER;
		this.mark = false;
	}
	
	/**
	 * @param state
	 * @uml.property  name="state"
	 */
	public void setState(int state) {
		this.state = state;
	}
	
	/**
	 * @return
	 * @uml.property  name="state"
	 */
	public int getState() {
		return state;
	}

	/**
	 * @return
	 * @uml.property  name="mark"
	 */
	public boolean isMark() {
		return mark;
	}
	
	/**
	 * @param mark
	 * @uml.property  name="mark"
	 */
	public void setMark(boolean mark) {
		this.mark = mark;
	}

	/**
	 * @return
	 * @uml.property  name="ship"
	 */
	public Ship getShip() {
		return ship;
	}

	/**
	 * @param ship
	 * @uml.property  name="ship"
	 */
	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public int doShot() {
		setMark(true);
		if (state == CELL_WELL) {
			setState(CELL_INJURED);
			return getShip().doShot();
		} else {
			if ( (state == CELL_BORDER) || (state == CELL_WATER)) {
				setState(CELL_MISSED);
			}
		}
		return Field.SHUT_MISSED;
	}
	
}
