package ru.semikov.sea.ai;

import java.util.ArrayList;
import ru.semikov.sea.logic.*;


public class AIRandom extends AIBase {
	
	public AIRandom(AI ai) {
		super(ai);
	}

	public int doShot() {
		ArrayList<Cell> list = new ArrayList<Cell>();
		for (int j = 0; j < ai.getField().getWidth(); j++) {
			for (int i = 0; i < ai.getField().getHeight(); i++) {
				Cell e = ai.getField().getCell(i, j);
				if (! e.isMark() ) { 
					list.add(e);
				}
			}
		}
		if (list.size() == 0) {
			return Field.SHUT_MISSED;
		}
		Cell cell = list.get(ai.rand.nextInt(list.size()));
		int shot = cell.doShot();
		if (shot == Field.SHUT_INJURED) {
			ai.action = new AIPlace(ai);
			ai.action.setPosition(cell.x, cell.y);
		}
		return shot;
	}

}
