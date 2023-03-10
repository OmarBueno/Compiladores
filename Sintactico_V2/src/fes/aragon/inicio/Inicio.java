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

	public static void main(String[] args) {
		Inicio ap = new Inicio();
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
		do {
			segundo();
			if (tokens.getLexema() == Sym.OR) {
				siguienteToken();
				segundo();
			}
			if (tokens.getLexema() != Sym.PUNTOCOMA) {
				if(tokens.getLexema() == Sym.EOF) {
					break;
				}
				errorSintactico();
			}
			else {
				if (!this.error) {
	                System.out.println("Invalida linea= " + (tokens.getLinea() + 1));
	                this.error = true;
	            } else {
	                System.out.println("Valida  linea= " + (tokens.getLinea() + 1));
	            }	
			}
		} while (tokens.getLexema() != Sym.EOF);
	}

	private void segundo() {
		do {
			tercero();
			if (tokens.getLexema() == Sym.AND||tokens.getLexema() == Sym.OR) {
				siguienteToken();
				segundo();
				if(tokens.getLexema() == Sym.EOF) {
					break;
				}
			}
			if (tokens.getLexema() != Sym.PUNTOCOMA) {
				errorSintactico();
			}
				if (!this.error) {
	                System.out.println("Invalida linea= " + (tokens.getLinea() + 1));
	                this.error = true;
	            } else {
	                System.out.println("Valida  linea= " + (tokens.getLinea() + 1));
	            }
			siguienteToken();
			if (tokens.getLexema() == Sym.SALTOLINEA) {
				siguienteToken();
			} 
			
		} while (tokens.getLexema() != Sym.EOF);
	}

	private void tercero() {
		if (tokens.getLexema() == Sym.NOT || tokens.getLexema() == Sym.TRUE || tokens.getLexema() == Sym.FALSE
				|| tokens.getLexema() == Sym.PDE || tokens.getLexema() == Sym.PIZ) {
			if (tokens.getLexema() == Sym.NOT) {
				siguienteToken();
				tercero();
			} else if (tokens.getLexema() == Sym.PIZ||tokens.getLexema() == Sym.PDE) {
				siguienteToken();
				tercero();
				siguienteToken();

			} else {
				siguienteToken();
			}
		} else {
			siguienteToken();
			errorSintactico();
		}
	}

	private void errorSintactico() {
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
