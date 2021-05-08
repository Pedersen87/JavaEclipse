import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class ViewConsole implements View {
	private Controler controler;
	private Scanner sc = new Scanner(System.in);
	private Scanner sc2 = new Scanner(System.in).useDelimiter("\n");
	private int optionInput;
	private String readpath, writeText;

	// C:\Users\Owner\OneDrive\Desktop\Myname.txt
	public ViewConsole(Controler cont) {
		controler = cont;
	}

	public void consoleMenu() {
		do {
			System.out.println("****************************");
			System.out.println("*       MENU SELECTION     *");
			System.out.println("****************************");
			System.out.println("* Options:                 *");
			System.out.println("*        1. Open file      *");
			System.out.println("*        2. Create file    *");
			System.out.println("*        0. Exit      	   *");
			System.out.println("****************************");
			optionInput = sc.nextInt();	
			switch (optionInput) {
			case 1:	
					System.out.println("Skriv in sökväg inklusive filnamn som du vill öppna: "); 
					readpath = sc.next();
					controler.eventInConsole(optionInput);			
				break;
			case 2:
				try {
					System.out.println("Skriv text du vill spara: \n");		
					writeText = sc2.next();
					System.out.println("Skriv in filnamn som du vill spara: \n");
					readpath = sc.next();					
					System.out.println("Följande har blivit sparat: " +readpath+": " +writeText);
					
					controler.eventInConsole(optionInput);
				}
				catch(InputMismatchException e) {
					System.out.println(e);
				}
				break;
			default:
				break;
			}
		} while (optionInput != 0);
	}	
		
	@Override
	public File chooseFile() {			
		File file = new File(readpath);
		return file;
	}

	@Override
	public Path chooseOpenFile() {
		Path path = Paths.get(readpath);
		return path;	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public String getViewText() {
		return writeText;
	}

	@Override
	public void setViewText(String textIn) {
		System.out.println(textIn);
	}
}
