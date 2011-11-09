package ru.semikov.sea.ai;

import java.util.ArrayList;
import ru.semikov.sea.logic.*;

public class AIPlace extends AIBase {

	public AIPlace(AI ai) {
		super(ai);
	}

	@Override
	public int doShot() {
		int m, n;
		ArrayList<Cell> list = new ArrayList<Cell>();
		for(int i = 0; i < 2; i++) {
			m = x + i * 2 - 1;
			n = y;
			if (ai.getField().isBound(m, n) ) {
				Cell e = ai.getField().getCell(m, n);
				if (! e.isMark() ) {
					list.add(e);
				}
			}

			m = x;
			n = y + i * 2 - 1;
			if (ai.getField().isBound(m, n) ) {
				Cell e = ai.getField().getCell(m, n);
				if (! e.isMark() ) {
					list.add(e);
				}
			}
		}

		if (list.size() > 0) {
			Cell e = list.get(ai.rand.nextInt(list.size()));
			int shot = e.doShot();
			if (  shot == Field.SHUT_INJURED ) {
				ai.action = new AIDirection(ai);
				ai.action.setPosition(x, y);
				ai.action.setDirection(e.x - x, e.y - y);
			}
			return shot;
		}

		ai.action = new AIRandom(ai);
		return ai.doShot();
	}
	
}
