package lab4.controller;
import java.awt.*;
import java.util.*;

class ShapeContainer implements DrawInterface {
	private Vector vector;
	
	public ShapeContainer() {
		vector=new Vector();
	}
			
	public void draw(Graphics g) {
		DrawInterface drawInterface;
		Enumeration e=vector.elements();
		while(e.hasMoreElements()) {
			drawInterface=(DrawInterface) e.nextElement();
			drawInterface.draw(g);
		}
	}
	public void add(DrawInterface s) {
		vector.add(s);
	}
	public void remove(DrawInterface s) {
		vector.remove(s);
	}
	public DrawInterface getContainer() {
		return this;
	}

	@Override
	public int getLineWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Color getLineColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getAreaColor() {
		// TODO Auto-generated method stub
		return null;
	}
}