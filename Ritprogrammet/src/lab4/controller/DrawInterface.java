package lab4.controller;
import java.awt.*;
import java.io.Serializable;

interface DrawInterface extends Serializable {
	public void draw(Graphics g);
	public void add(DrawInterface s);
	public void remove(DrawInterface s);
	public DrawInterface getContainer();
	public Color getLineColor();
	public Color getAreaColor();
	public int getXcord();
	public int getHeight();	
	public int getYcord();	
	public int getWidth();
	public int getLineWidth();
}

		