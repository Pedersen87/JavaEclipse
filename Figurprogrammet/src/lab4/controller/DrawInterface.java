package lab4.controller;
import java.awt.*;
import java.io.Serializable;

interface DrawInterface extends Serializable {
	public void draw(Graphics g);
	public void add(DrawInterface s);
	public void remove(DrawInterface s);
	public DrawInterface getContainer();
	public int getLineWidth();
	public Color getLineColor();
	public Color getAreaColor();
}

		