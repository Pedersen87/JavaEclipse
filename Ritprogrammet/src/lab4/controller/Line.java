package lab4.controller;
import java.awt.*;

class Line extends Model {
	
	public Line(int xCord, int yCord, int width, int height, int lineWidth,Color areaColor) {
		setXcord(xCord);
		setWidth(width);
		setYcord(yCord);
		setHeight(height);
		setLineWidth(lineWidth);
		setAreaColor(areaColor);
	}
			
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Stroke stroke = new BasicStroke(lineWidth);
		g2d.setStroke(stroke);
		g.setColor(areaColor);	
		g.drawLine(xCord,yCord,width,height);
	}
	public void add(DrawInterface s) { }
	public void remove(DrawInterface s) { }
	public DrawInterface getContainer() {
		return null;
	}
}