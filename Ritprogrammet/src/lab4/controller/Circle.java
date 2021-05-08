package lab4.controller;
import java.awt.*;

class Circle extends Model {
	
	public Circle(int xCord, int yCord, int width, int height, int lineWidth, Color lineColor, Color areaColor) { 
		setXcord(xCord);
		setWidth(width);
		setYcord(yCord);
		setHeight(height);
		setLineWidth(lineWidth);
		setLineColor(lineColor);
		setAreaColor(areaColor);
	}
			
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Stroke stroke = new BasicStroke(lineWidth);
		g2d.setStroke(stroke);
		g.setColor(lineColor);	
		g.fillOval(xCord, yCord, width, height);
		g.setColor(areaColor);
		g.drawOval(xCord,yCord,width,height);		
	}
	public void add(DrawInterface s) { }
	public void remove(DrawInterface s) { }
	public DrawInterface getContainer() {
		return null;
	}
}