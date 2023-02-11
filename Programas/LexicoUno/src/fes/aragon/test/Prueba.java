package fes.aragon.test;

public class Prueba {
	private char[] columnas = { 'a', 'b', 'c', ':' };
	private int[][] tablas = { { 1, 0, 0, 0 }, { 2, 1, 1, 0 }, { 3, 2, 2, 0 }, { 4, 3, 3, 1 }, { 4, 4, 4, 0 } };
	private String token = "aaacbbbbb:";
	private int estado = 0;
	private int columna = 0;
	private boolean correcto = false;

	public static void main(String[] args) {
		Prueba app = new Prueba();
		for (int i = 0; i < app.token.length(); i++) {
			char simbolo = app.token.charAt(i);
			for (int j = 0; j < app.columnas.length; j++) {
				app.correcto = false;
				if (app.columnas[j] == simbolo) {
					app.columna = j;
					app.correcto = true;
					break;
				}
			}
			if (!app.correcto) {
				System.out.println("Palabra con caracteres incorrectos");
				app.estado = 0;
				break;
			}
			System.out.println("Fila: " + app.estado + " Columna: " + app.columna + " Valor: " + app.tablas[app.estado][app.columna]);
			app.estado = app.tablas[app.estado][app.columna];
		}
		if (app.estado == 1) {
			System.out.println(app.token + " Aceptada");
		} else {
			System.out.println(app.token + " Denegada");
		}
	}
}
