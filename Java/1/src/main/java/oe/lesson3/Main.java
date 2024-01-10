package oe.lesson3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	public static void main(String[] args) {
		try {
			Hello("Leonard");
			} catch (CoronaException ex) {
				System.out.println("Run you fools!");
			} catch (ShakespeareException ex) {
				System.out.println("To be or not to be?");
			}
		
	}

	static void Hello(String nev) throws CoronaException{
		if (nev.equals("Coronavirus")){
			throw new CoronaException();
		}
		if (nev.equals("Shakespeare")) {
			throw new ShakespeareException();
		}
		System.out.println("Hello "+nev);
	}
}
