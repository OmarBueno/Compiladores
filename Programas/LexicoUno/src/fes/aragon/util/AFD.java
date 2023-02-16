package fes.aragon.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AFD {
	// private List<Character> alfabeto;
	private String[] alfabeto;
	private List<String[]> transiciones = new ArrayList<String[]>();
	private String[] transicion;
	private String estado = "0";
	private int columna = 0;
	private boolean correcto = false;

	public AFD() {
	}

	public AFD(String[] alf, List<String[]> trans) {
		this.alfabeto = alf;
		this.transiciones = trans;
	}

	public void configurar(String archive) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File(System.getProperty("user.dir") + "\\Config\\" + archive);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			String sAlfabeto = br.readLine();
			alfabeto = sAlfabeto.split(",");
			while ((linea = br.readLine()) != null) {
				String[] transicionLinea = linea.split(",");
				transiciones.add(transicionLinea);
			}
			System.out.println("Alfabeto: ");
			for (String letra : alfabeto) {
				System.out.println(letra);
			}
			System.out.println("Transiciones: ");
			for (String[] transicion : transiciones) {
				for (String estado : transicion) {
					System.out.println(estado);
				}
			}
			System.out.println("------------");
			System.out.println(transiciones.get(0)[0]);
		} catch (Exception e) {
			e.printStackTrace();
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
	
	public boolean evaluar(String token) {
		if (token.charAt(token.length() - 1) != ':') {
			this.estado = "0";
		} else {
			for (int i = 0; i < token.length(); i++) {
				char sim = token.charAt(i);
				String simbolo = String.valueOf(sim);
				if (Utilerias.digito(sim)) {
					simbolo = "D";
				} else if (Utilerias.letra(sim)) {
					simbolo = "L";
				}
				for (int j = 0; j < this.alfabeto.length; j++) {
					this.correcto = false;
					if (this.alfabeto[j] == simbolo) {
						this.columna = j;
						this.correcto = true;
						break;
					}
				}
				if (!this.correcto) {
					System.out.println("Palabra con caracteres incorrectos");
					this.estado = "0";
					break;
				}
				// System.out.println("Fila: " + this.estado + " Columna: " + this.columna +
				// "Valor: "
				// + this.tablas[this.estado][this.columna]);
				this.estado = this.transiciones.get(Integer.parseInt(this.estado))[this.columna];
			}
		}
		if (this.estado == "1") {
			System.out.println(token + " Aceptada");
			return true;
		} else {
			System.out.println(token + " Denegada");
			return false;
		}
	}
}
