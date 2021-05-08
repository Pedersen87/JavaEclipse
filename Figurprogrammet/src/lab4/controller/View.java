package lab4.controller;
import java.awt.*;
import javax.swing.*;

public class View extends JPanel{
	private Controller controller;
	private JFrame jframe;
	private DrawInterface drawObject, drawNewObject;
	public View(Controller controllerIn) {
		controller = controllerIn;
		drawObject=new ShapeContainer();		
		drawNewObject = new ShapeContainer();
		jframe=new JFrame("Graphic editor");
		jframe.add(this);
		jframe.setSize(500,500);
		drawObject.add(new Rect(10,300,400,100,30,Color.pink,Color.blue));	
		drawObject.add(new Circle(20,150,200,50,10,Color.yellow,Color.red));
		drawObject.add(new Line(50,400,600,300,5,Color.green));
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
				
	public DrawInterface drawTest() {
		return drawObject;
	}
	
	public void newDrawTest(DrawInterface drawObjectIn) {
		drawNewObject = drawObjectIn;
	}
	
	public void paintComponent(Graphics g) {
		jframe.repaint();
		drawNewObject.draw(g);
	}	
}
		
		
		

		
