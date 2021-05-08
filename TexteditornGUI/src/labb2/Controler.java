package labb2;

import java.io.File;
import java.nio.file.Path;

import javax.imageio.stream.FileImageInputStream;

public class Controler{
	private View v;
	private Model m;
	private Boolean bool = false;
	
	Controler(){
		m = new Model();
		v = new View(this);		
	}
		public void eventIn(String choice) {
			if(choice.equals("New")) {
					v.write.setText(m.newFile());
					bool = false;	
			}
			if(choice.equals("Open")) {	
				Path file = v.chooseOpenFile();
				if(file!=null) {
					v.write.setText(m.openFile(file));	
					bool = true;
				}
				
			}
			if(choice.equals("Save")) {
				if(bool == true) {
					m.saveFile(v.write.getText());
					System.out.println("SAVE");
					//bool = false;				
				}
				if(bool == false) {
					File file = v.chooseFile();
					if(file != null) {
						m.saveAsFile(v.write.getText(),file);
						bool = true;
					}
					System.out.println("SAVE AS");
				}
			}
			if(choice.equals("Save as")) {
				File file = v.chooseFile();
				if(file != null) {
					m.saveAsFile(v.write.getText(),file);
					bool = true;
				}
			}
			if(choice.equals("Exit")) {
					m.saveFile(v.write.getText());
					m.exitMethod();	
			}
		}

	public static void main(String[] args) {
		new Controler();
	}

}
