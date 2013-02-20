/* Universidad de La Laguna
 * ETSII
 * Practica 4 - Ejercicio 2
 */

package p4ej1.alu4308.etsii.ull.es;

import java.util.ArrayList;

public class Main {

	/**
	 * Crea un set de Serpientes y lo recorre utilizando un bucle y next()
	 * @param args
	 */
	public static void main(String[] args) {
		
 		ArrayList<Serpiente> misSerpientes = new ArrayList<Serpiente>();
 		int numSerpientes = Integer.parseInt(args[0]);
 		
 		for(int i = 1; i <= numSerpientes; i++)
 			misSerpientes.add(new Serpiente(i));
 		
 		for(int i = 0; i < numSerpientes; i++)
 			misSerpientes.get(i).reptar();
	}
}
