import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.nio.file.Path;

public interface View {
	
	public String getViewText();
	public void setViewText(String textIn);
	
	public File chooseFile();
	
	public void consoleMenu();

	public Path chooseOpenFile();

	public void actionPerformed(ActionEvent e);

	public void windowClosing(WindowEvent e);

}