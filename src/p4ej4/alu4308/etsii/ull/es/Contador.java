package p4ej4.alu4308.etsii.ull.es;

import java.io.*;
import java.util.*;

public class Contador {

	public static void main (String[] args) {

		String linea;
		String regex = "[\\s,;:\\.\\?\\(\\)']+\\s?";
		String[] palabras;
		String clave;
		int valor;
		Hashtable<String, Integer> AlmacenPalabras = new Hashtable<String, Integer>();
		Iterator<String> iter = null;
		TreeSet<String> conjuntoOrdenado;
		
		try {

			BufferedReader reader = new BufferedReader(new FileReader(args[0]));

			while (reader.ready()) {
				linea = reader.readLine();
				palabras = linea.split(regex);	// obtenemos las palabras de la linea segund la expresion regular
				for(int i = 0; i < palabras.length; i++) {
					if(!palabras[i].matches("^[0-9].*")) {	// Aceptamos la palabra si no empieza con un numero
						clave = palabras[i].toLowerCase();		// Convertimos la cadena a minusculas
						if(!AlmacenPalabras.containsKey(clave)) {
							AlmacenPalabras.put(clave, 1);		// Me temos en el hash con valor 1
						}
						else {
							valor = AlmacenPalabras.get(clave);
							AlmacenPalabras.remove(valor);
							AlmacenPalabras.put(clave, valor + 1);	// metemos en el hash con valor la suma de lo que habia mas uno
						}
					}
				}
			}	
			reader.close();
			
			conjuntoOrdenado = new TreeSet<String> (AlmacenPalabras.keySet()); // Obtenemos el conjunto de claves y creamo un conjunto ordenado
			iter = conjuntoOrdenado.iterator();	// Obtenemos un iterador para el conjunto
			
			while (iter.hasNext()) {
				clave = iter.next();
				System.out.println(clave + " -> " + AlmacenPalabras.get(clave));
			}
		
		} catch (FileNotFoundException e) {
			System.out.println("Error: El fichero '" + args[0] + "' no existe.");
		} catch (IOException e) {
			System.out.println("Error: Fallo de lectura/escritura.");
		}
	}
}
