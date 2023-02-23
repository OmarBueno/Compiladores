package fes.aragon.inicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import fes.aragon.tokens.Tokens;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader;
		try {
			reader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + "/P1")));
			Analizador2 anl = new Analizador2(reader);
			Tokens token;
			
			do {
				token = anl.yylex();
				System.out.println(token);
			} while (token!=null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
