
import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class Controler{
	private View view;
	private ViewFactory viewFactory;
	private Model model;
	private int menuChoice;
	private boolean checkSave = false;
	
	Controler(){
		menu();
		model = new Model();		
		viewFactory = new ViewFactory(this);
		view = viewFactory.createView(menuChoice);
		view.consoleMenu();
	}
	
		public void eventInConsole(int eventIn) {
			if(eventIn==1) {
				Path file = view.chooseOpenFile();				
				if(file!=null) {
					view.setViewText(model.openFile(file));
				}
			}
			if(eventIn==2) {
				File file = view.chooseFile();
				if(file != null) {
					model.saveAsFile(view.getViewText(),file);
					
				}
			}
		}
	
		public void eventInGUI(String option) { 		
			if(option.equals("New")) {
				view.setViewText(model.newFile());
				checkSave = false;
			}
			if(option.equals("Open")) {	
				Path file = view.chooseOpenFile();
				if(file!=null) {
					view.setViewText(model.openFile(file));
					checkSave = true;
				}	
			}
			if(option.equals("Save")) {
				if(checkSave == true) {
					model.saveFile(view.getViewText());				
				}
				if(checkSave == false) {
					File file = view.chooseFile();
					if(file != null) {
						model.saveAsFile(view.getViewText(),file);
						checkSave = true;
					}
				}	
			}
			if(option.equals("Save as")) {
				File file = view.chooseFile();
				if(file != null) {
					model.saveAsFile(view.getViewText(),file);
					checkSave = true;
				}
			}
			if(option.equals("Exit")) {
					model.saveFile(view.getViewText());
					model.exitMethod();	
			}
		}

		public void menu() {
			System.out.println("Gör ditt val");
			System.out.println("Tryck 1 följt av enter för konsoll");
			System.out.println("Tryck 2 följt av enter för GUI");
			Scanner sc = new Scanner(System.in);
			menuChoice = sc.nextInt();
		}
		
	public static void main(String[] args) {
		 new Controler();
	}

}
