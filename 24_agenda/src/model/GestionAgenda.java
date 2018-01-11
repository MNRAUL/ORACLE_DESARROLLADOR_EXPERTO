package model;

import java.util.HashMap;

public class GestionAgenda {

	private HashMap<String, String> agenda = new HashMap<>();

	public boolean añadirContacto(String email, String nombre) {
		if (!agenda.containsKey(email)) {
			agenda.put(email, nombre);
			return true;
		} else {
			return false;
		}
	}

	public String buscarContacto(String email) {
		return agenda.get(email);
	}

	public boolean eliminarContacto(String email) {
		if (agenda.containsKey(email)) {
			agenda.remove(email);
			return true;
		} else {
			return false;
		}
	}

	public String[] obtenerContactos() {
		return agenda.values().toArray(new String[0]);
	}
}
