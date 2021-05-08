
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Model implements EventListener {
	private String erase = "";
	private String readtext = "";
	private Path file;
	private String path = "";
	
	public void exitMethod() {
		System.exit(0);
	}
	 
	public String newFile() { 
		if(!path.isEmpty()) {
			path = "";
			file = null;
			return erase;			
		}
		else {
			return erase;
		}
	}
	
	public void saveFile(String s) {
		File file = new File(path);	
		if(file.exists() && !path.isEmpty()){
			if(path.contains(".txt")){
				try { 
					FileWriter fw = new FileWriter(file,false); 
					BufferedWriter bw = new BufferedWriter(fw); 
					bw.write(s); 
					bw.flush(); 
					bw.close();
				} 
				catch (Exception e) { 
					System.err.println(e); 
				} 
			}
			else {
				try { 
					FileWriter fw = new FileWriter(file+".txt",false); 
					BufferedWriter bw = new BufferedWriter(fw); 
					bw.write(s); 
					bw.flush(); 
					bw.close();
				} 
				catch (Exception e) { 
					System.err.println(e); 
				} 
			}
		}
		else {
			saveAsFile(s, file);		
		}
	}
	
	public void saveAsFile(String s, File file) {	 
			path = file.toString();     
            if(path.contains(".txt")) {
                try { 
                    FileWriter fw = new FileWriter(file, false);  
                    BufferedWriter bw = new BufferedWriter(fw); 
                    bw.write(s); 
                    bw.flush(); 
                    bw.close(); 
                } 
                catch (Exception e) { 
                	System.err.println(e); 
                } 
            }
            else {
                try { 
                    FileWriter fw = new FileWriter(file+".txt", false);  
                    BufferedWriter bw = new BufferedWriter(fw); 
                    bw.write(s); 
                    bw.flush(); 
                    bw.close(); 
                } 
                catch (Exception e) { 
                	System.err.println(e); 
                } 
            }
        } 

	public String openFile(Path file) {
			path = file.toString();
			    	try {
			    	    InputStream in = Files.newInputStream(file);
			    	    BufferedReader reader = new BufferedReader(new InputStreamReader(in)); 
			    	    String line = null;
			    	    while ((line = reader.readLine()) != null) {
			    	       readtext = line;		    	    	
			    	    }
			    	    reader.close();
			    	} catch (IOException e) {
			    	    System.err.println(e);
			    	}	    	
			    	return readtext;		
		}
	}
