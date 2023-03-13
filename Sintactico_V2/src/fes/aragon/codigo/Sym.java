/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.codigo;

/**
 *
 * @author MASH
 */
public class Sym {
  public static final int OR = 0;
  public static final int AND = 1;  
  public static final int NOT = 2;
  public static final int TRUE = 3;  
  public static final int FALSE = 4;
  public static final int PIZ = 5;
  public static final int PDE = 6;
  public static final int PUNTOCOMA = 7;
  public static final int SALTOLINEA = 8;
  public static final int EOF = 9;
  public static final String[] terminales = new String[] {
  "OR",  
  "AND",
  "NOT",
  "TRUE",
  "FALSE",
  "PIZ",
  "PDE",
  "PUNTOCOMA",
  "SALTOLINEA",
  "EOF"
  };
}
