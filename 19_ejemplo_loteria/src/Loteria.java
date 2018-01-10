
public class Loteria {
	/**
	 * Ejercicio que saca 9 numeros aleatorios ordenados sin que se repitan.
	 * 
	 * @param args
	 */

	private final static int numerosBoleto = 6;
	private final static int numeroMaximoBoleto = 50;

	public static void main(String[] args) {
		int[] boleto = new int[numerosBoleto];
		for (int i = 0; i < boleto.length; i++) {
			int numeroAleatorio = 0;
			// Genero numero aleatorio
			do {
				numeroAleatorio = generarNumeroAleatorio();
			}
			// Compruebo si existe el numero aleatorio en el array
			while (existeNumero(numeroAleatorio, boleto, i));

			// Asigno el numero al array
			boleto[i] = numeroAleatorio;
		}

		// Ordeno el boleto
		boleto = ordenarArrayAscendente(boleto);
		// Imprimo el boleto
		System.out.println("Boleto generado:");
		System.out.println(generarCadenaArray(boleto));
	}

	public static int generarNumeroAleatorio() {
		return (int) Math.floor((Math.random() * numeroMaximoBoleto) + 1);
	}

	/**
	 * Metodo para ordenar los datos
	 * 
	 * @param datos
	 * @return
	 */
	public static int[] ordenarArrayAscendente(int datos[]) {
		int datosClonados[] = datos.clone();
		for (int i = 0; i < datosClonados.length; i++) {
			for (int j = i + 1; j < datosClonados.length; j++) {
				if (datosClonados[j] < datosClonados[i]) {
					int datoI = datosClonados[i];
					datosClonados[i] = datosClonados[j];
					datosClonados[j] = datoI;
				}
			}
		}
		return datosClonados;
	}

	/**
	 * Metodo que comprueba si un numero esta en un array
	 * 
	 * @param numero
	 * @param datos
	 * @param generados
	 *            Variable para
	 * @return
	 */
	public static boolean existeNumero(int numero, int datos[], int generados) {
		for (int i = 0; i < generados; i++) {
			int dato = datos[i];
			if (dato == numero)
				return true;
		}
		return false;
	}

	/**
	 * Metodo que concatena los valores de un array en un String
	 * 
	 * @param datos
	 * @return
	 */
	public static String generarCadenaArray(int datos[]) {
		String cadena = "";
		for (int dato : datos) {
			cadena += dato + "-";
		}
		return cadena.substring(0, cadena.length() - 1);
	}
}
