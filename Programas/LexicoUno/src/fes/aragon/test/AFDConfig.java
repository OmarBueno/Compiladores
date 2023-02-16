package fes.aragon.test;

import fes.aragon.util.AFD;

public class AFDConfig {
	public static void main(String[] args) {
		AFD automata = new AFD();
		automata.configurar("Config1");
		automata.evaluar("aa:");
	}
}
