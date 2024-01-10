package WebApp;

import java.io.*;
import java.net.*;


public class ClientMain {
	public static void main( String[] args ) {
    	try {
    		Socket s=new Socket("localhost",3333);
    		System.out.println( "Connected to server." );
    		
    		PrintWriter pw= new PrintWriter(s.getOutputStream());
    		pw.println("Client Claire");
    		pw.flush();
    		
    		BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream()));
    		String answer=br.readLine();
    		System.out.println("Answer "+ answer );
    		
    		
    		br.close();
    		pw.close();
    		
    	} catch (Exception ex) {
    		System.out.println( ex.getMessage());
        }
    }
}
