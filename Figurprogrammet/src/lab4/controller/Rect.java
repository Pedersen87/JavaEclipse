package lab4.controller;
import java.awt.*;

class Rect extends Model {
	private int x,y,h,w,lineWidth;
	private Color lineColor, areaColor;
	
	public Rect(int inx, int iny, int inw, int inh, int borderWidth, Color lineColor, Color areaColor) {
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
		g2.fillRect(x,y,w,h);
		g2.setColor(this.areaColor);
		g2.drawRect(x,y,w,h);
		
		/*g.setColor(this.lineColor);
		g.fillRect(x,y,w,h);
		g.setColor(this.areaColor);
		g.drawRect(x,y,w,h);*/	
	}
	public void add(DrawInterface s) { }
	public void remove(DrawInterface s) { }
	public DrawInterface getContainer() {
		return null;
	}
}