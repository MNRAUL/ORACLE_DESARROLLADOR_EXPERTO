package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionNotas {

	private static final double notaMinima = 0.0;
	private static final double notaAprobado = 5.0;
	private static final double notaMaxima = 10.0;

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		ArrayList<Double> listaNotas = new ArrayList<>();
		int opcion = 5;
		do {
			mostrarMenu();
			opcion = leerNumericoTeclado("Introduzca la opcion  de menu entre:", 1, 5).intValue();
			limpiarConsola();
			switch (opcion) {
			case 1:
				System.out.println("1. AÑADIR NOTA:");
				double nota = leerNumericoTeclado("Introduzca un numero entre:", notaMinima, notaMaxima);
				listaNotas.add(nota);
				break;
			case 2:
				System.out.println("2. APROBADOS:");
				mostrarArrayListDouble(obtenerAprobados(listaNotas));
				break;
			case 3:
				System.out.println("3. NOTA MEDIA:");
				System.out.println(obteberNotaMedia(listaNotas));
				break;
			case 4:
				System.out.println("4. TODAS LAS NOTAS:");
				mostrarArrayListDouble(listaNotas);
				break;
			}

		} while (opcion != 5);
		scanner.close();
		System.out.println("Adios");
	}

	public static Double leerNumericoTeclado(String textoUsuario, double opcionMinima, double opcionMaxima) {
		Double nota = opcionMinima - 1;
		do {
			System.out.println(textoUsuario + opcionMinima + " y " + opcionMaxima);
			try {
				String notaString = scanner.nextLine();
				nota = Double.parseDouble(notaString);
			} catch (Exception e) {
				System.out.println("Introduzca un numero valido.");
			}

			// Compruebo que el numerico es mayor que 0
			if (nota < opcionMinima || nota > opcionMaxima)
				System.out.println("Error: Ha introduzca un numero entre:" + opcionMinima + " y " + opcionMaxima);
		} while (nota < opcionMinima || nota > opcionMaxima);
		// scanner.close();

		return nota;
	}

	private static ArrayList<Double> obtenerAprobados(ArrayList<Double> notas) {
		ArrayList<Double> listaAprobados = new ArrayList<>();
		for (Double nota : notas) {
			if (nota >= notaAprobado)
				listaAprobados.add(nota);
		}
		return listaAprobados;
	}

	private static Double obteberNotaMedia(ArrayList<Double> notas) {
		double sumatorioNotas = 0.0;
		for (int i = 0; i < notas.size(); i++) {
			sumatorioNotas += notas.get(i);
		}
		return sumatorioNotas / notas.size();
	}

	private static void mostrarArrayListDouble(ArrayList<Double> notas) {
		for (int i = 0; i < notas.size(); i++) {
			System.out.println("Nota " + (i + 1) + ": " + notas.get(i));
		}
	}

	private static void mostrarMenu() {
		System.out.println("\n\n***************MENU*****************");
		System.out.println("1. Añadir nota");
		System.out.println("2. Ver aprobados");
		System.out.println("3. Nota Media");
		System.out.println("4. Mostrar Todos");
		System.out.println("5. Salir");
	}

	private static void limpiarConsola() {
		/*
		 * try { Runtime.getRuntime().exec("cls"); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		for (int i = 0; i < 20; i++) {
			System.out.println();
		}
	}

}
