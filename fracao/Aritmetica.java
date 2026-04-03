/*
 A classe Aritmetica terá os seguintes método static:
 -> calcularMdc(x, y), que deve retornar o máximo divisor comum entre os dois parâmetros;
 -> Caso algum dos parâmetros seja não-positivo, lance uma RuntimeException
*/

public class Aritmetica {
	
	private static int euclidesRecursivo(int x, int y) {
	
		// Algoritmo de Euclides recursivo
		if(y == 0) {
			return x;
	  	}
		return euclidesRecursivo(y, x % y);
	}

	public static int calcularMdc(int x, int y) {
		
		// Verifica se os parâmetros são positivos
		if(x < 1 || y < 1) {
			throw new UnsupportedOperationException("Algum dos argumentos é não-positivo.");
		} else {
			return euclidesRecursivo(x, y);
		}
	}
}
