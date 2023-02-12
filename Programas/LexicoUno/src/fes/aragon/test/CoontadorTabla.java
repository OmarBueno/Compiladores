package fes.aragon.test;

import fes.aragon.util.Archivo;

public class CoontadorTabla {
	private char[] columnas = { 'a', 'b', 'c', ':' };
	private int[][] tablas = { { 1, 0, 0, 0 }, { 2, 1, 1, 0 }, { 3, 2, 2, 0 }, { 4, 3, 3, 1 }, { 4, 4, 4, 0 } };
	private int estado = 0;
	private int columna = 0;
	private boolean correcto = false;

	private boolean evaluar(String token) {
		for (int i = 0; i < token.length(); i++) {
			char simbolo = token.charAt(i);
			for (int j = 0; j < this.columnas.length; j++) {
				this.correcto = false;
				if (this.columnas[j] == simbolo) {
					this.columna = j;
					this.correcto = true;
					break;
				}
			}
			if (!this.correcto) {
				System.out.println("Palabra con caracteres incorrectos");
				this.estado = 0;
				break;
			}
			// System.out.println("Fila: " + app.estado + " Columna: " + app.columna + "
			// Valor: " + app.tablas[app.estado][app.columna]);
			this.estado = this.tablas[this.estado][this.columna];
		}
		if (this.estado == 1) {
			System.out.println(token + " Aceptada");
			return true;
		} else {
			System.out.println(token + " Denegada");
			return false;
		}
	}

	public static void main(String[] args) {

		for (String token : Archivo.getData("Data2")) {
			CoontadorTabla app = new CoontadorTabla();
			System.out.println(app.evaluar(token));
		}
	}
}
