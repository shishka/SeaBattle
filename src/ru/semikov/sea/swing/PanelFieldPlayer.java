package ru.semikov.sea.swing;

import java.awt.Color;

import ru.semikov.sea.logic.*;

public class PanelFieldPlayer extends PanelField {

	public PanelFieldPlayer(Field field) {
		super(field);
	}

	@Override
	protected Color getColorByStateElement(int state) {
		switch (state) {
		case Cell.CELL_BORDER:
			return new Color(215, 215, 255);
		case Cell.CELL_WATER:
			return new Color(225, 225, 255);
		case Cell.CELL_WELL:
			return Color.green;
		case Cell.CELL_INJURED:
			return Color.red;
		case Cell.CELL_KILLED:
			return Color.gray;
		case Cell.CELL_MISSED:
			return Color.black;
		}
		
		return Color.blue;
	}
	
}
