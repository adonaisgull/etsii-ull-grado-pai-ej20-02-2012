/* Universidad de La Laguna
 * ETSII
 * Practica 4 - Ejercicio 2
 */

package p4ej2.alu4308.etsii.ull.es;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	/**
	 * Crea un set de Serpientes y lo recorre utilizando un Iterator
	 * @param args
	 */
	public static void main(String[] args) {
		
 		List<Serpiente> misSerpientes = new ArrayList<Serpiente>();
 		int numSerpientes = Integer.parseInt(args[0]);
 		Iterator<Serpiente> iter = null;
 		
 		for(int i = 1; i <= numSerpientes; i++)
 			misSerpientes.add(new Serpiente(i));
 		
 		iter = misSerpientes.iterator();
 		while (iter.hasNext()) {
 			iter.next().reptar();
 		}
	}
}
