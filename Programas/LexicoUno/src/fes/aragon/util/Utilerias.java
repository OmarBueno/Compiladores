package fes.aragon.util;

public class Utilerias {
	public static boolean digito(char entrada) {
		if (entrada >= 48 && entrada <= 57) {
			return true;
		}
		return false;
	}

	public static boolean letra(char entrada) {
		if (entrada >= 65 && entrada <= 90 || entrada >= 97 && entrada <= 122) {
			return true;
		}
		return false;
	}
}
