package lab4.controller;
import java.awt.Color;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Model implements DrawInterface{
	DrawInterface drawInterfaceObjectOut;
	private static String filename = "testobject.dat";	
	int width;
	int xCord, yCord, xCord2, yCord2;
	int height;
	int lineWidth;
	Color lineColor;
	Color areaColor;
	
	public void saveFile(DrawInterface drawInterfaceObjectIn) {
		try {
			ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream(filename));
			o.writeObject(drawInterfaceObjectIn);
			o.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DrawInterface openFile() {
		try {
			ObjectInputStream o = new ObjectInputStream(new FileInputStream(filename));
			drawInterfaceObjectOut = (DrawInterface) o.readObject();
			o.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return drawInterfaceObjectOut;
	}
	
	public int getXcord() { //4.2
		return xCord;
	}

	public void setXcord(int xcord) { //4.2
		this.xCord = xcord;
	}

	public int getWidth() { //4.2
		return width;
	}

	public void setWidth(int w) { //4.2
		this.width = w;
	}

	public int getYcord() { //4.2
		return yCord;
	}

	public void setYcord(int ycord) { //4.2
		this.yCord = ycord;
	}
	 
	public int getHeight() { //4.2
		return height;
	}

	public void setHeight(int height) { //4.2
		this.height = height;
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int linewidth) { //4.2
		this.lineWidth = linewidth;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color linecolor) { //4.2
		this.lineColor=linecolor;
	}

	public Color getAreaColor() {
		return areaColor;
	}

	public void setAreaColor(Color areacolor) { //4.2
		this.areaColor=areacolor;
	}
	
	@Override
	public void draw(Graphics g) {	
	}
	
	@Override
	public void add(DrawInterface s) {		
	}
	
	@Override
	public void remove(DrawInterface s) {		
	}
	
	@Override
	public DrawInterface getContainer() {
		return null;
	}

}
