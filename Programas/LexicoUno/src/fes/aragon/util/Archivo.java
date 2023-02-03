package fes.aragon.util;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Archivo {

	public static ArrayList<String> getData(String archive) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> palabras = new ArrayList<String>();
		try {
			archivo = new File(System.getProperty("user.dir") + "\\Data\\" + archive);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] palabrasLinea = linea.split(" ");
				for (String palabra : palabrasLinea) {
					palabras.add(palabra);
				}
			}
			return palabras;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}