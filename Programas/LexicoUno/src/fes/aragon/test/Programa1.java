package fes.aragon.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fes.aragon.util.Archivo;

public class Programa1 {

	public static void main(String[] args) {
		ArrayList<String> datos = Archivo.getData("Data1");
		List<Character> alfabeto = new ArrayList<Character>();
		Character[] alf = { 'a', 'b', 'c' };
		alfabeto = Arrays.asList(alf);
		for (String cadena : datos) {
			int estado = 1;
			System.out.println(cadena);
			outer: for (int i = 0; i < cadena.length(); i++) {
				// System.out.println(estado);
				char simbolo = cadena.charAt(i);
				if (alfabeto.indexOf(simbolo) < 0) {
					System.out.println("La cadena tiene simbolos fuera del alfabeto");
					estado = 5;
					break;
				}
				switch (estado) {
				case 1: {
					if (simbolo == 'a') {
						estado = 2;
					}
					break;
				}
				case 2: {
					if (simbolo == 'a') {
						estado = 3;
					}
					break;
				}
				case 3: {
					if (simbolo == 'a') {
						estado = 4;
					}
					break;
				}
				case 4: {
					if (simbolo == 'a') {
						estado = 5;
					}
					break;
				}
				default:
					break outer;
				}
			}
			if (estado == 4) {
				System.out.println("palabra aceptada");
			} else {
				System.out.println("Palabra denegada");
			}
			System.out.println("------------------------");

		}
	}

}
