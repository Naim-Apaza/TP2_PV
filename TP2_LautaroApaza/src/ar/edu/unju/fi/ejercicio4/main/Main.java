package ar.edu.unju.fi.ejercicio4.main;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner in;
	private static List<Jugador> jugadores;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		byte opcion;
		boolean valido = true;

		while (valido) {
			try {
				do {
					System.out.println("==========================");
					System.out.println("1 – Alta de jugador");
					System.out.println("2 – Mostrar todos los jugadores.");
					System.out.println(
							"3 – Modificar la posición de un jugador (el usuario debe ingresar el nombre y el apellido del\n"
									+ "jugador)");
					System.out.println(
							"4 – Eliminar un jugador (el usuario debe ingresar el nombre y apellido. Utilice Iterator).");
					System.out.println("5 – Salir.");
					System.out.println("==========================");

					System.out.print("Ingrese una Opcion: ");
					opcion = Byte.parseByte(in.nextLine());

					switch (opcion) {
					case 1:
						alta();
						break;
					case 2:
						mostrar();
						break;
					case 3:
						modificarPosicion();
						break;
					case 4:
						eliminar();
						break;
					case 5:
						System.out.println("FINALIZANDO PROCESO....");
						return;
					default:
						System.out.println("OPCION NO PERMITIDA");
					}
				} while (opcion != 8);
				valido = false;
				in.close();
			} catch (NumberFormatException e) {
				System.out.println("Se espera que se ingrese un numero entero");

			}
		}

	}

	public static void alta() {
		if (jugadores == null)
			jugadores = new ArrayList<>();
		Jugador jugador = new Jugador();

		System.out.println("----------------------");
		System.out.print("Ingrese nombre: ");
		jugador.setNombre(in.nextLine());

		System.out.print("Ingrese apellido: ");
		jugador.setApellido(in.nextLine());

		System.out.print("Ingrese nacionalidad: ");
		jugador.setNacionalidad(in.nextLine());

		verificarFecha(jugador);

		verificarDatos(jugador);

		System.out.print("Ingrese posicion: ");
		posicion(jugador);
		System.out.println("----------------------");

		jugadores.add(jugador);
	}

	public static void mostrar() {
		if (jugadores == null || jugadores.isEmpty()) {
			System.out.println("No tenemos listado de jugadores");
			return;
		}
		jugadores.forEach(System.out::println);
	}

	public static void modificarPosicion() {
		if (jugadores == null || jugadores.isEmpty()) {
			System.out.println("No tenemos listado de jugadores");
			return;
		}

		System.out.println("----------------------");
		System.out.print("Ingrese nombre del jugador: ");
		String nombre = in.nextLine();

		System.out.print("Ingrese apellido del jugador: ");
		String apellido = in.nextLine();
		System.out.println("----------------------");

		for (Jugador j : jugadores) {
			if (!(j.getNombre().equalsIgnoreCase(nombre) && j.getApellido().equalsIgnoreCase(apellido)))
				System.out.println("EL JUGADOR NO EXISTE");
			else {
				System.out.println("----------------------");

				verificarDatos(j);

				System.out.print("Ingrese posicion: ");
				posicion(j);

				System.out.println("JUGADOR  MODIFICADO");
				System.out.println("----------------------");
			}
		}
	}

	public static void eliminar() {
		if (jugadores == null || jugadores.isEmpty()) {
			System.out.println("No tenemos listado de jugadores");
			return;
		}

		System.out.println("----------------------");
		System.out.print("Ingrese nombre del jugador: ");
		String nombre = in.nextLine();

		System.out.print("Ingrese apellido del jugador: ");
		String apellido = in.nextLine();
		System.out.println("----------------------");

		Iterator<Jugador> iterator = jugadores.iterator();
		while (iterator.hasNext()) {
			Jugador j = iterator.next();
			if (!(j.getNombre().equalsIgnoreCase(nombre) && j.getApellido().equalsIgnoreCase(apellido)))
				System.out.println("EL JUGADOR NO EXISTE");
			else {
				System.out.println("JUGADOR ELIMINADO");
				iterator.remove();
			}
		}
	}

	public static void posicion(Jugador jugador) {
		byte posicion;
		boolean valido = true;

		System.out.println("========");
		System.out.println("1 - DELANTERO");
		System.out.println("2 - MEDIO");
		System.out.println("3 - DEFENSA");
		System.out.println("4 - ARQUERO");
		System.out.println("========");

		while (valido) {
			try {
				do {
					System.out.print("Ingrese una posicion: ");
					posicion = Byte.parseByte(in.nextLine());

					switch (posicion) {
					case 1:
						jugador.setPosicion(Posicion.DELANTERO);
						break;
					case 2:
						jugador.setPosicion(Posicion.MEDIO);
						break;
					case 3:
						jugador.setPosicion(Posicion.DEFENSA);
						break;
					case 4:
						jugador.setPosicion(Posicion.ARQUERO);
						break;
					default:
						System.out.println("OPCION NO DISPONIBLE...");
					}
				} while (posicion > 4 || posicion < 1);
				valido = false;
			} catch (NumberFormatException e) {
				System.out.println("SE ESPERA QUE SE INGRESE UN NUMERO ENTERO.");
			}
		}
	}

	public static void verificarFecha(Jugador jugador) {
		boolean valido = true;

		while (valido) {
			try {
				System.out.print("Ingrese fecha de nacimiento(yyyy-mm-dd): ");
				String fecha = in.nextLine();
				jugador.setFechaDeNacimiento(LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE));
				valido = false;
			} catch (DateTimeException e) {
				System.out.println("Se espera que ingrese la fecha con el formato yyyy-mm-dd");
			}
		}
	}

	public static void verificarDatos(Jugador jugador) {
		boolean validoA = true;
		boolean validoB = true;
		while (validoA) {
			try {
				System.out.print("Ingrese estatura: ");
				jugador.setAltura(Float.parseFloat(in.nextLine()));

				validoA = false;
			} catch (NumberFormatException e) {
				System.out.println("SE ESPERA UN VALOR NUMERICO. Ej: '##.##'");
			}
		}
		while (validoB) {
			try {
				System.out.print("Ingrese peso: ");
				jugador.setPeso(Float.parseFloat(in.nextLine()));

				validoB = false;
			} catch (NumberFormatException e) {
				System.out.println("SE ESPERA UN VALOR NUMERICO. Ej: '##.##'");
			}
		}
	}
}