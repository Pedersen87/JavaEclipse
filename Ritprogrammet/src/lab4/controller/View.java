package lab4.controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class View extends JPanel implements ActionListener{
	private Controller controller;
	private String option;
	private JFrame jframe, sizeFrame;
	private JMenuBar jMenuBar;
	private JButton rectBtn, circleBtn, lineBtn;
	private DrawInterface drawObject;
	private int xCord, yCord, lineWidth, xCord2, yCord2, xkord,ykord,xEnd,yEnd; 
	private Color areaColor, borderColor; 
	
	public View(Controller controllerIn) {
		
		controller = controllerIn;
		drawObject=new ShapeContainer();		 
		jframe=new JFrame("Graphic editor");
		jMenuBar = new JMenuBar();		
		rectBtn = new JButton("Rectangle"); 
		circleBtn = new JButton("Circle"); 
		lineBtn = new JButton("Line"); 		
        rectBtn.addActionListener(this);
        circleBtn.addActionListener(this);
        lineBtn.addActionListener(this);
		jMenuBar.add(rectBtn);
		jMenuBar.add(circleBtn);
		jMenuBar.add(lineBtn);
		jframe.setJMenuBar(jMenuBar);		
		jframe.add(this);
		jframe.setSize(550,500);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
 
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {	
				
					xCord = me.getX();	
					yCord = me.getY();	
				
			}
			public void mouseReleased(MouseEvent e) {    
				try {
				xCord2 = e.getX();
				yCord2 = e.getY();					
				xkord = Math.min(xCord, e.getX());
				ykord = Math.min(yCord,e.getY());
				xEnd=Math.abs(xCord-e.getX());
				yEnd=Math.abs(yCord-e.getY());
				controller.eventIn(option);
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Välj figur först!", "Varning!", 1);
					System.out.println(ex);
				}
				
			}
		});
}
	
	
	public void rectangle(int x, int y,int width, int height, int linewidth, Color areacolor, Color bordercolor) { 
		drawObject.add(new Rect(xkord,ykord,xEnd,yEnd, lineWidth, areaColor, borderColor));			
	}
	
	public void circle(int x, int y,int width, int height, int linewidth, Color areacolor, Color bordercolor) { 
		drawObject.add(new Circle(xkord,ykord,xEnd,yEnd,lineWidth,areaColor, borderColor));
	}
	
	public void line(int x, int y, int width, int height,int linewidth, Color areacolor) {
		drawObject.add(new Line(xCord,yCord,xCord2,yCord2,lineWidth, areaColor));
	}
	
	public int lineWidthInput() {	
		try {
			lineWidth = Integer.parseInt(JOptionPane.showInputDialog(sizeFrame,"Enter border width"));
		} 
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Only number input!");
		}
		return lineWidth;
	}
	
	public Color areaColorInput() {	
		return areaColor = JColorChooser.showDialog(null, "Choose area color!",Color.WHITE);
	}
	
	public Color borderColorInput() {	
		return borderColor = JColorChooser.showDialog(null, "Choose border color!",Color.WHITE);
	}
	
	public DrawInterface SaveDraw() { 
		return drawObject;
	}
	
	public DrawInterface getDrawInterface() { 
		return drawObject;
	}
	
	public void setDrawInterface(DrawInterface drawObjectIn) { 			
		drawObject = drawObjectIn;
	}
	
	public View (DrawInterface dI) { 
		this.drawObject=dI;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		drawObject.draw(g);
		jframe.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		option = e.getActionCommand();
	}		
}
