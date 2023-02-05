package fes.aragon.test;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import fes.aragon.util.Archivo;

public class Contador {

	public static void main(String[] args) {
		// String cadena = JOptionPane.showInputDialog("Cadena a analizar");
		ArrayList<String> datos = Archivo.getData("Data1");
		for (String cadena : datos) {
			int estado = 1;
			System.out.println(cadena);
			outer: for (int i = 0; i < cadena.length(); i++) {
				System.out.println(estado);
				char simbolo = cadena.charAt(i);
				if (simbolo != 'a' && simbolo != 'b' && simbolo != 'c') {
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
