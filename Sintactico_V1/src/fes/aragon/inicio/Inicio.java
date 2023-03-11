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
public class Inicio {
	private boolean error = true;
	private Tokens tokens = null;
	private Lexico analizador = null;
	int linea = 0;
	int columna =0;

	public static void main(String[] args) {
		Inicio ap = new Inicio();
		BufferedReader buf;
		try {
			buf = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/archivo.txt"));
			// se pasa archivo a analizar
			ap.analizador = new Lexico(buf);
			// verifica si es el final del archivo
			ap.siguienteToken();
			ap.sentencia();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sentencia() throws IOException {
		do {
			asignacion();
			if (!this.error) {
				System.out.println("Invalida linea= " + (tokens.getLinea() + 1));
				this.error = true;
			} else {
				System.out.println("Valida  linea= " + (tokens.getLinea() + 1));
			}
			if(tokens.getLexema()==Sym.EOF) {
				throw new IOException("Fin Archivo");
			}
			siguienteToken();
			if (tokens.getLexema() == Sym.SALTOLINEA) {
					siguienteToken();
				} 	
		} while (tokens.getLexema() != Sym.EOF);
		
	}

	private void asignacion() throws IOException {
		if (tokens.getLexema() == Sym.ID) {
			siguienteToken();
			if (tokens.getLexema() == Sym.IGUAL) {
				siguienteToken();
				expresion();
			} else {
				errorSintactico();
			}
		} else {
			errorSintactico();
		}
	}

	private void expresion() throws IOException {
		if (tokens.getLexema() == Sym.ID || tokens.getLexema() == Sym.ENTERO) {
			siguienteToken();
			if (tokens.getLexema() == Sym.MAS || tokens.getLexema() == Sym.MENOS) {
				siguienteToken();
				expresion();
			} else {
				if (tokens.getLexema() != Sym.PUNTOCOMA) {
					errorSintactico();
				}
			}
		} else {
			if (tokens.getLexema() != Sym.PUNTOCOMA) {
				errorSintactico();
			}
		}
	}

	private void errorSintactico() throws IOException {
		this.error = false;
		// descartar todo hasta encontrar ;
		do {
			System.out.println(tokens.toString());
			if (tokens.getLexema() != Sym.PUNTOCOMA) {
				if (tokens.getLexema() == Sym.SALTOLINEA||tokens.getLexema()==Sym.EOF) {
					break;
				}
				siguienteToken();
			}
		} while (tokens.getLexema() != Sym.PUNTOCOMA && tokens.getLexema() != Sym.EOF);

	}

	private void siguienteToken() throws IOException {
			tokens = analizador.yylex();
			if (tokens == null) {
				tokens = new Tokens("EOF", Sym.EOF, linea, columna);
			}else {
				linea = tokens.getLinea();
				columna = tokens.getColumna();
			}

	}

}
