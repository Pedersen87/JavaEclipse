
public class ViewFactory {
	private Controler controller;
	//private View v; //Ej nödvändigt
	public ViewFactory(Controler con) {
		controller = con;
	}
	public View createView(int choice) {
		if(choice==1){
			return new ViewConsole(controller);
		}
		if(choice==2) {
			return new ViewGUI(controller);
		}
		return null;	
	}
}
