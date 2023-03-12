/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.inicio;

import fes.aragon.codigo.Lexico;
import fes.aragon.codigo.Sym;
import fes.aragon.codigo.Tokens;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author MASH
 */
public class Inicio2 {
	private boolean error = true;
	private Tokens tokens = null;
	private Lexico analizador = null;

	public static void main(String[] args) {
		Inicio2 ap = new Inicio2();
		BufferedReader buf;
		try {
			buf = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/archivo.txt"));
			// se pasa archivo a analizar
			ap.analizador = new Lexico(buf);
			// verifica si es el final del archivo
			ap.siguienteToken();
			ap.primer();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void primer() {
		while (tokens.getLexema() != Sym.EOF) {
			boolean parentesis = false;
			if(tokens.getLexema()==Sym.NOT||tokens.getLexema()==Sym.PIZ) {
				if(tokens.getLexema()==Sym.PIZ) {
					parentesis = true;
				}
				siguienteToken();
				if(tokens.getLexema()==Sym.TRUE||tokens.getLexema()==Sym.FALSE){
					siguienteToken();
					if(parentesis && tokens.getLexema()!=Sym.PDE) {
						errorSintactico();
					}
				}
				else {
					errorSintactico();
				}
			}
			else if(tokens.getLexema()==Sym.TRUE||tokens.getLexema()==Sym.FALSE) {
				siguienteToken();
				if(tokens.getLexema()==Sym.AND||tokens.getLexema()==Sym.OR) {
					siguienteToken();
					if(tokens.getLexema()==Sym.TRUE||tokens.getLexema()==Sym.FALSE) {
						siguienteToken();
					}
					if(tokens.getLexema()==Sym.PUNTOCOMA) {
						siguienteToken();
					}
					else {
						errorSintactico();
					}
				}
				else {
					errorSintactico();
				}
			}
			else {
				errorSintactico();
			}
		}
	}

	private void errorSintactico() {
		this.error = false;
		// descartar todo hasta encontrar ;
		do {
			System.out.println(tokens.toString());
			if (tokens.getLexema() != Sym.PUNTOCOMA) {
				siguienteToken();
			}
		} while (tokens.getLexema() != Sym.PUNTOCOMA && tokens.getLexema() != Sym.EOF);

	}

	private void siguienteToken() {
		try {
			tokens = analizador.yylex();
			if (tokens == null) {
				tokens = new Tokens("EOF", Sym.EOF, 0, 0);
				throw new IOException("Fin Archivo");
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
