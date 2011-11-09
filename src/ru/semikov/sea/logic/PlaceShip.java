package ru.semikov.sea.logic;

public abstract class PlaceShip {

	public Field field;
	
	public PlaceShip(Ship ship) {
		this.field = ship.getField();
	}
	
	protected Field getField() {
		return field;
	}
	
	abstract public boolean setShip(int x, int y);
	abstract public boolean setBorder(int x, int y);
}
