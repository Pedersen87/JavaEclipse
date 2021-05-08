package lab4.controller;
import java.awt.*;

class Line extends Model {
	private int x,y,x2,y2,lineWidth;
	private Color lineColor, areaColor;
	
	public Line(int inx, int iny, int inx2, int iny2, int width, Color areaColor) {
		x=inx;
		y=iny;
		x2=inx2;
		y2=iny2;
		lineWidth=width;
		this.areaColor = areaColor;
	}
			
	public void draw(Graphics g) {
		
		java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
		g2.setStroke(new java.awt.BasicStroke(lineWidth)); 
		g2.setColor(this.areaColor);
		g2.drawLine(x,y,x2,y2);
	}
	
	public void add(DrawInterface d) { }
	public void remove(DrawInterface d) { }
	public DrawInterface getContainer() {
		return null;
	}
}