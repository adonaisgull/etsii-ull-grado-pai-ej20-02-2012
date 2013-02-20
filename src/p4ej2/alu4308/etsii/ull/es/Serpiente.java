/* Universidad de La Laguna
 * ETSII
 * Practica 4 - Ejercicio 2
 */

package p4ej2.alu4308.etsii.ull.es;

/**
 * Clase para representar serpientes
 * @author Adonai Suárez
 * @author Daniel Quijada
 */

public class Serpiente {
	
	int numSerpiente;
	
	public Serpiente (int numSerpiente) {
		setNumeroSerpiente(numSerpiente);
	}
	
	public void setNumeroSerpiente (int numSerpiente) {
		this.numSerpiente = numSerpiente;
	}
	
	public int getNumeroSerpiente () {
		return numSerpiente;
	}
	
	/**
	 * Muestra el numero de serpiende que esta reptando
	 */
	public void reptar() {
		System.out.println(getNumeroSerpiente());
	}
}
