package p4ej5.alu4308.etsii.ull.es;

public class Log {

	public static void main (String args[]) throws WrongParameterException {
		
		double aDouble;
		
		try {
			
			aDouble = Double.parseDouble (args[0]);
			if (aDouble < 0)
				throw new WrongParameterException ("Logaritmo de un número menor que 0.");
			
			else
				System.out.println(Math.log(aDouble));
			
		} catch (ArrayIndexOutOfBoundsException e1) {
			throw new WrongParameterException ("Sin parámetro.", e1);
		} catch (NumberFormatException e2) {
			throw new WrongParameterException ("Parámetro no numérico.", e2);
		} catch (WrongParameterException ex) {
			System.out.println ("Parámetro Incorrecto.");
		    System.out.println(ex.getMessage());
		}
	}
}