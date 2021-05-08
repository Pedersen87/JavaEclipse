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
	
	public void saveMethod(DrawInterface drawInterfaceObjectIn) {
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
	
	public DrawInterface openMethod() {
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
