package lab4.controller;
import java.awt.*;

class Circle extends Model {
	private int x,y,h,w,lineWidth;
	private Color lineColor, areaColor;
	
	public Circle(int inx, int iny, int inw, int inh, int borderWidth, Color lineColor, Color areaColor) {
		x=inx;
		y=iny;
		h=inh;
		w=inw;
		lineWidth=borderWidth;
		this.lineColor = lineColor;
		this.areaColor = areaColor;
	}
			
	public void draw(Graphics g) {
		
		java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
		g2.setStroke(new java.awt.BasicStroke(lineWidth)); 
		g2.setColor(this.lineColor);
		g2.fillOval(x, y, h, w);
		g2.setColor(this.areaColor);
		g2.drawOval(x,y,h,w);
	}
	public void add(DrawInterface d) { }
	public void remove(DrawInterface d) { }
	public DrawInterface getContainer() {
		return null;
	}
}