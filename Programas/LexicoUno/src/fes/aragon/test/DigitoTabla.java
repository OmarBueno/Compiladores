package fes.aragon.test;

import fes.aragon.util.Archivo;
import fes.aragon.util.Utilerias;

public class DigitoTabla {
	private char[] columnas = { 'L', 'D', ':' };
	private int[][] tablas = { { 2, 1, 0 }, { 1, 1, 0 }, { 2, 2, 1 } };
	private int estado = 0;
	private int columna = 0;
	private boolean correcto = false;

	private boolean evaluar(String token) {
		if (token.charAt(token.length() - 1) != ':') {
			this.estado = 0;
		} else {
			for (int i = 0; i < token.length(); i++) {
				char simbolo = token.charAt(i);
				if (Utilerias.digito(simbolo)) {
					simbolo = 'D';
				} else if (Utilerias.letra(simbolo)) {
					simbolo = 'L';
				}
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
				// System.out.println("Fila: " + this.estado + " Columna: " + this.columna +
				// "Valor: "
				// + this.tablas[this.estado][this.columna]);
				this.estado = this.tablas[this.estado][this.columna];
			}
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

		for (String token : Archivo.getData("Data3")) {
			DigitoTabla app = new DigitoTabla();
			System.out.println(app.evaluar(token));
		}
	}
}
