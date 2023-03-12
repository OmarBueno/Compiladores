package fes.aragon.test;

import fes.aragon.util.AFD;
import fes.aragon.util.Archivo;

public class Programa4 {
	public static void main(String[] args) {
		AFD automata = new AFD();
		automata.configurar("Config3");
		// automata.evaluar("aabbcca:");
		for (String token : Archivo.getData("Data2")) {
			System.out.println(automata.evaluar(token));
		}
	}
}
