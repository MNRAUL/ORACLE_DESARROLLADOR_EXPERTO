package principal;

import java.util.Scanner;

import model.GestionAgenda;

public class Agenda {

	private static GestionAgenda gestionAgenda = new GestionAgenda();
	
	public static void main(String[] args) {
		String nombre, email;
		Scanner sc = new Scanner(System.in);
		int op;
		do {
			System.out.println("1.- Añadir contacto");
			System.out.println("2.- Buscar contacto");
			System.out.println("3.- Eliminar contacto");
			System.out.println("4.- Mostrar todos los contactos");
			System.out.println("5.- Salir");
			op = Integer.parseInt(sc.nextLine());
			switch (op) {
			
			case 1:
				System.out.println("Introduzca email:");
				sc.nextLine();
				email = sc.nextLine();

				System.out.println("Introduzca nombre:");
				nombre = sc.nextLine();

				boolean insertado = gestionAgenda.añadirContacto(email, nombre);
				if(insertado)
					System.out.println("Correcto");
				else
					System.out.println("El contacto ya existia");
				
				break;
			case 2:
				System.out.println("Introduzca email:");
				email = sc.nextLine();
				nombre = gestionAgenda.buscarContacto(email);
				if(nombre != null)
					System.out.println("Contacto: " + nombre);
				else
					System.out.println("El contacto no existe.");
			case 3:
				System.out.println("Introduzca email:");
				email = sc.nextLine();
				
				boolean eliminado = gestionAgenda.eliminarContacto(email);
				if(eliminado)
					System.out.println("Correcto");
				else
					System.out.println("El contacto no existia");
				
				System.out.println("Contacto: " + gestionAgenda.eliminarContacto(email));
				
				break;
			case 4:
				mostrarNotas(gestionAgenda.obtenerContactos());
				break;
			case 5:
				break;
			default:
				System.out.println("Debes escribir una opción válida");
			}
		} while (op != 5);
		sc.close();
		System.out.println("Fin.");
	}
	
	private static void mostrarNotas(String[] valores) {
		for (String valor : valores) {
			System.out.print(valor + ",");
		}
		System.out.println();
	}
}
