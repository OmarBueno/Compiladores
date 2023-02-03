package fes.aragon.test;

import javax.swing.JOptionPane;

public class Contador {

	public static void main(String[] args) {
		int estado = 1;
		String cadena = JOptionPane.showInputDialog("Cadena a analizar");
		for (int i = 0; i < cadena.length(); i++) {
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
				System.out.println("Error");
			}
		}
		System.out.println(cadena);
		if (estado == 4) {
			System.out.println("palabra aceptada");
		} else {
			System.out.println("Palabra denegada");
		}

	}

}
