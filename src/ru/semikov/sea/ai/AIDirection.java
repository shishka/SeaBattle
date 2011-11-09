package ru.semikov.sea.ai;

import java.util.ArrayList;

import ru.semikov.sea.logic.*;

public class AIDirection extends AIBase {
	
	public AIDirection(AI ai) {
		super(ai);
	}

	
	public void draw(ArrayList<Cell> list, int i, int j) {
		int m = x;
		int n = y;
		do {
			m+= i;
			n+= j;
		} while ( ai.getField().isBound(m, n) && (ai.getField().getCell(m, n).getState() == Cell.CELL_INJURED) );
		
		if (ai.getField().isBound(m, n) ) {
			Cell e = ai.getField().getCell(m, n);
			if (! e.isMark() ) {
				list.add(e);
			}
		}
	}

	@Override
	public int doShot() {
		ArrayList<Cell> list = new ArrayList<Cell>();
		draw(list, dx, dy);
		draw(list, -dx, -dy);

		if (list.size() > 0) {
			return list.get(ai.rand.nextInt(list.size())).doShot();
		}

		ai.action = new AIRandom(ai);
		return ai.doShot();
	}

}
