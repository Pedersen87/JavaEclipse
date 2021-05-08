package lab4.controller;

import java.awt.Graphics;

public class Controller {
	private View view;
	private Model model;
	
	Controller(){
		model = new Model();
		view = new View(this);		
		model.saveMethod(view.drawTest());	
		view.newDrawTest(model.openMethod());
	}
	
	public static void main(String[] args) {
		new Controller();
	}

}
