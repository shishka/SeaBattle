package ru.semikov.sea.logic;

public class PlaceShipCheck extends PlaceShip {

	public PlaceShipCheck(Ship ship) {
		super(ship);
	}

	@Override
	public boolean setShip(int x, int y) {
		if ( getField().isBound(x, y) ) { 
			return ( getField().getCell(x, y).getState() == Cell.CELL_WATER );
		} else {
			return false;
		}
			
	}

	@Override
	public boolean setBorder(int x, int y) {
		return true;
	}
}
