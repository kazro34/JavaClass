package WebApp;

import java.io.*;
import java.net.*;


public class ServerMain 
{
    public static void main( String[] args ) {
    	try {
    		ServerSocket ss=new ServerSocket(3333);
    		System.out.println( "Server started..." );
    		Socket s=ss.accept();
    		
    		//Beolvassa a kliens üzenetét
    		BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream()));
    		String message=br.readLine();
    		System.out.println(message+ " connected" );
    		
    		
    		//Válaszol
    		PrintWriter pw= new PrintWriter(s.getOutputStream());
    		pw.println("Hello "+message);
    		pw.flush();
    	
    		br.close();
    		pw.close();
    		
    	} catch (Exception ex) {
    		System.out.println( ex.getMessage());
        }
    }
}
