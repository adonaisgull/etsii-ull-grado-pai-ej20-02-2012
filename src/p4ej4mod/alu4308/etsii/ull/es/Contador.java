package p4ej4mod.alu4308.etsii.ull.es;

import java.io.*;
import java.util.*;

public class Contador {
	
	public static void main (String[] args) {
		
		String linea;
		String regex = "[\\s,;:\\.\\?\\(\\)']+\\s?";
		String regexPalabrasReservadas = "abstract|double|int|strictfp|boolean|else|interface|super|break|extends|long|switch|byte|final|native|synchronized|case|finally|new|this|catch|float|package|throw|char|for|private|throws|class|goto|protected|transient|const|if|public|try|continue|implements|return|void|default|import|short|volatile|do|instanceof|static|while";
		//String regexOperadores = "[-+*/%]|(==)|";
		String[] palabrasEnLinea;
		String clave;
		ArrayList<Hashtable<String, ArrayList<Integer>>> AlmacenPalabras = new ArrayList<Hashtable<String,ArrayList<Integer>>>();
		Iterator<String> iter = null;
		Set<String> conjuntoClaves;
		ArrayList<Integer> lineasAparicion;
		int numeroDeLinea = 0;
		Integer contenedor;
		String palabra;
		
		for(int i = 0; i <= 4; i++)
			AlmacenPalabras.add(new Hashtable<String, ArrayList<Integer>>());
		
		try {

			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			
			while (reader.ready()) {
				numeroDeLinea++;
				linea = reader.readLine();
				palabrasEnLinea = linea.split(regex);
				for (int i = 0; i < palabrasEnLinea.length; i++) {
					
					palabra = palabrasEnLinea[i];
					// es palabra reservada
					if (palabra.matches(regexPalabrasReservadas)) {
						contenedor = 0;
					}
					
					else {
						contenedor = 5;
					}
					
					// es identificador
					// es operador
					
					// es signo de puntuacion
					
					if (contenedor != 5) {
						if (!AlmacenPalabras.get(contenedor).containsKey(palabra)) {
							lineasAparicion = new ArrayList<Integer>();
							lineasAparicion.add(numeroDeLinea);
							AlmacenPalabras.get(contenedor).put(palabra, lineasAparicion);
						}
						else {
							lineasAparicion = AlmacenPalabras.get(contenedor).get(palabra);
							AlmacenPalabras.get(contenedor).remove(palabra);		// No se si es de todo necesario
							lineasAparicion.add(numeroDeLinea);
							AlmacenPalabras.get(contenedor).put(palabra, lineasAparicion);
						}
					}
				}
			}	
			reader.close();
			
			for (int i = 0; i < 4; i++) {
				System.out.println("GRUPO " + (i+1));
				conjuntoClaves = AlmacenPalabras.get(i).keySet();	// Obtenemos el set con las claves de la tabla hash
				iter = conjuntoClaves.iterator();			// Obtenemos un iterados para recorrel de la tabla hash
				
				while (iter.hasNext()) {
					clave = iter.next();
					System.out.println(clave + " " + AlmacenPalabras.get(i).get(clave).size() + " " + AlmacenPalabras.get(i).get(clave));
				}
			}
		
		} catch (FileNotFoundException e) {
			System.out.println("Error: El fichero '" + args[0] + "' no existe.");
		} catch (IOException e) {
			System.out.println("Error: Fallo de lectura/escritura.");
		}
	}
}
