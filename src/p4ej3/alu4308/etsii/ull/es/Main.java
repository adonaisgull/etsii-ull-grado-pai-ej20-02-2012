/* Universidad de La Laguna
 * ETSII
 * Practica 4 - Ejercicio 2
 */

package p4ej3.alu4308.etsii.ull.es;

import java.util.*;

public class Main {
	
	/**
	 * Crea un hash para almacenar objetos Serpiente con claves String
	 * @param args
	 */	
	public static void main (String[] args) {
		
		Hashtable<String, Serpiente> misSerpientes = new Hashtable<String,Serpiente>();
		Set<String> set;
		String tempStr;
		Iterator<String> iter = null;
		
		misSerpientes.put("Uno", new Serpiente (1));
		misSerpientes.put("Dos", new Serpiente (2));
		misSerpientes.put("Tres", new Serpiente (3));
		misSerpientes.put("Cuatro", new Serpiente (4));
		
		set = misSerpientes.keySet();	// Obtenemos el set con las claves de la tabla hash
		iter = set.iterator();			// Obtenemos un iterados para recorrel de la tabla hash
		
		while (iter.hasNext()) {
			tempStr = iter.next();
			misSerpientes.get(tempStr).reptar();
		}
	}
}
	
	

