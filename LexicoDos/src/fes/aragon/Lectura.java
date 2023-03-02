package fes.aragon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Lectura {
	public static void main(String[] args) {
		try {
			Reader rd=new BufferedReader(new FileReader("fuente.txt"));
			Lexico lexico=new Lexico(rd);
			Tokens resultado;
			do {
				resultado=lexico.yylex();
				System.out.println(resultado);
			}while(resultado!=null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
