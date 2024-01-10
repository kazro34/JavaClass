package IOStream;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) {
		
		try{
			/*FileOutputStream fo = new FileOutputStream("test.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fo);
			PrintWriter pw = new PrintWriter(osw);*/
			PrintWriter pw = new PrintWriter(new File("test.txt"));
			pw.println("Hello");
			pw.println("Töhötöm");
			pw.close();
			Files.write(Paths.get("test2.txt"), Arrays.asList("Hello","Béla"), StandardOpenOption.WRITE);
		} catch (FileNotFoundException ex) {	
		} catch (IOException ex) {
		}
		
		try {
			/*FileInputStream fis = new FileInputStream("test.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);*/
			BufferedReader br=Files.newBufferedReader(Paths.get("test.txt"),Charset.defaultCharset());
			/*String sor;
			while((sor = br.readLine()) != null) {
				System.out.println(sor);
			}*/
			for(Object object : br.lines().toArray()) {
				System.out.println(object);
			}
			br.lines().forEach(s->System.out.println(s));
			br.close();
			var lines=Files.readAllLines(Paths.get("test.tx"),Charset.defaultCharset());
			for(String line : lines) {
				System.out.println(line);
			}
		}catch (IOException ex) {	
		}
	}
}
