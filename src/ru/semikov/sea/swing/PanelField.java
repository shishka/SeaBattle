package ru.semikov.sea.swing;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import ru.semikov.sea.logic.*;

abstract public class PanelField extends JPanel implements ISubscriber {
	private Field field;
	
	public Field getField() {
		return field;
	}

	public PanelField(Field field) {
		this.field = field;
	}

	private int getCellWidth() {
		return getWidth() / getField().getWidth();
	}

	private int getCellHeight() {
		return getHeight() / getField().getHeight();
	}
	
	abstract protected Color getColorByStateElement(int state);
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// рисуем решётку
		for(int i = 0; i < getField().getWidth() + 1; i++) {
			g.drawLine(i * getCellWidth(), 0, i * getCellWidth(), getCellHeight() * getField().getHeight());
		}
		
		for(int i = 0; i < getField().getHeight() + 1; i++) {
			g.drawLine(0, i * getCellHeight(), getCellWidth() * getField().getWidth(), i * getCellHeight());
		}

		
		// рисуем элементы
		for(int j = 0; j < getField().getHeight(); j++) {
			for(int i = 0; i < getField().getWidth(); i++) {
				int state = field.getCell(i, j).getState();
				g.setColor(getColorByStateElement(state));
				if (state == Cell.CELL_MISSED) {
					g.fillRect(i*getCellWidth() + (getCellWidth() / 2) - 1, j*getCellHeight() + (getCellHeight() / 2) - 1, 4, 4);
				} else {
					g.fillRect(i*getCellWidth()+1, j*getCellHeight()+1, getCellWidth() - 1, getCellHeight() - 1);
				}
				
			}
		}
	}

	@Override
	public void update() {
		this.repaint();
	}
	
}
