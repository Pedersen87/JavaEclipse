

import java.awt.event.*;
import java.io.File;
import java.nio.file.Path;
import javax.swing.*;

public class ViewGUI extends WindowAdapter implements ActionListener, View {
	private Controler controler;
	private String option;
	JTextArea write;
	JFrame jFrame;
	JMenuBar jMenuBar;
	private JFileChooser jFileChooser = new JFileChooser();
	ViewGUI(Controler cont){
		controler = cont;	
		jFrame = new JFrame("Nytt dokument"); 
		write = new JTextArea();
		jMenuBar = new JMenuBar();
		jFrame.addWindowListener(this);
			JMenu menu = new JMenu("File"); 
		        JMenuItem newItem = new JMenuItem("New"); 
		        JMenuItem openItem = new JMenuItem("Open"); 
		        JMenuItem saveItem = new JMenuItem("Save"); 
		        JMenuItem saveAsItem = new JMenuItem("Save as");
		        JMenuItem exitItem = new JMenuItem("Exit");	     
		        newItem.addActionListener(this);
		        openItem.addActionListener(this);
		        saveItem.addActionListener(this);
		        saveAsItem.addActionListener(this);
		        exitItem.addActionListener(this);
				menu.add(newItem);
				menu.add(openItem);
				menu.add(saveItem);
				menu.add(saveAsItem);
				menu.add(exitItem);
		jMenuBar.add(menu);		
        jFrame.add(write); 
        jFrame.setJMenuBar(jMenuBar);
        jFrame.setSize(500, 500); 
        jFrame.show(); 
	}

	@Override
	public File chooseFile() {
		int i = jFileChooser.showSaveDialog(null);		
		if(i == JFileChooser.APPROVE_OPTION) {
			File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());
			return file;
		}
		return null;
	}
	
	@Override
	public Path chooseOpenFile() {
		int j = jFileChooser.showOpenDialog(null);
		if(j == JFileChooser.APPROVE_OPTION) {
			Path file = jFileChooser.getSelectedFile().toPath();
			System.out.println(file);
			return file;
		}
		return null;
	}
	
	public String getViewText() {
		return write.getText();
	}
	
	public void setViewText(String textIn) {
		write.setText(textIn);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		option = e.getActionCommand();
		controler.eventInGUI(option);
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void consoleMenu() {
		// TODO Auto-generated method stub
		
	}

}
