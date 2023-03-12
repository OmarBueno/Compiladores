package fes.aragon.test;

import fes.aragon.util.AFD;
import fes.aragon.util.Archivo;

public class Programa5 {
	public static void main(String[] args) {
		AFD automata = new AFD();
		automata.configurar("Config4");
		for (String token : Archivo.getData("Data4")) {
			System.out.println(automata.evaluar(token));
		}
	}
}
