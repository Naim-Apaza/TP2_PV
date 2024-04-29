package ar.edu.unju.fi.ejercicio2.main;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner in;
	private static List<Efemeride> efemerides;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		byte opcion;
		boolean valido = true;

		while (valido) {
			try {
				do {
					System.out.println("===========================");
					System.out.println("1 – Crear efeméride");
					System.out.println("2 – Mostrar efemérides");
					System.out.println("3 – Eliminar efeméride");
					System.out.println("4 – Modificar efeméride");
					System.out.println("5 – Salir.");
					System.out.println("===========================" + '\n');

					System.out.print("Elija un opcion: ");
					opcion = Byte.parseByte(in.nextLine());

					switch (opcion) {
					case 1:
						crearEfemeride();
						break;
					case 2:
						mostrarEfemerides();
						break;
					case 3:
						eliminarEfemeride();
						break;
					case 4:
						modificarEfemeride();
						break;
					case 5:
						System.out.println("FINALIZANDO PROCESO");
						break;
					default:
						System.out.println("OPCION NO DISPONIBLE");
					}
				} while (opcion != 5);
				valido = false;
				in.close();
			} catch (NumberFormatException e) {
				System.out.println("DEBE INGRESAR UN NUMERO ENTERO");
			}
		}

	}

	public static void crearEfemeride() {
		if (efemerides == null)
			efemerides = new ArrayList<>();
		Efemeride efemeride = new Efemeride();

		System.out.println("------------------------");
		System.out.print("Ingrese codigo: ");
		efemeride.setCodigo(in.nextLine());

		mes(efemeride);

		dia(efemeride);

		System.out.print("Ingrese descripcion: ");
		efemeride.setDetalle(in.nextLine());
		System.out.println("------------------------");

		efemerides.add(efemeride);
	}

	public static void mostrarEfemerides() {
		if (efemerides == null || efemerides.isEmpty()) {
			System.out.println("LISTA VACIA");
			return;
		}
		efemerides.forEach(System.out::println);
	}

	public static void eliminarEfemeride() {
		if (efemerides == null || efemerides.isEmpty()) {
			System.out.println("LISTA VACIA");
			return;
		}
		System.out.print("Ingrese codigo del efemeride a eliminar: ");
		String codigo = in.nextLine();

		Iterator<Efemeride> iterator = efemerides.iterator();

		while (iterator.hasNext()) {
			Efemeride e = iterator.next();

			if (!(e.getCodigo().equalsIgnoreCase(codigo))) {
				System.out.println("ESE CODIGO NO EXISTE");
			} else {
				System.out.println("SE ELIMINO CON EXITO");
				iterator.remove();
			}
		}
	}

	public static void modificarEfemeride() {
		if (efemerides == null || efemerides.isEmpty()) {
			System.out.println("LISTA VACIA");
			return;
		}

		System.out.print("Ingrese codigo del efemeride a modificar: ");
		String codigo = in.nextLine();

		for (Efemeride e : efemerides) {
			if (!(e.getCodigo().equalsIgnoreCase(codigo))) {
				System.out.println("ESE CODIGO NO EXISTE");
			} else {
				System.out.println("------------------------");
				mes(e);
				dia(e);

				System.out.print("Ingrese descripcion: ");
				e.setDetalle(in.nextLine());
				System.out.println("------------------------");
			}
		}
	}

	public static void mes(Efemeride efemeride) {
		byte mes;
		boolean valido = true;

		while (valido) {
			try {
				do {
					System.out.print("Ingrese mes(1=Enero...12=Diciembre): ");
					mes = Byte.parseByte(in.nextLine());

					switch (mes) {
					case 1:
						efemeride.setMes(Mes.ENERO);
						break;
					case 2:
						efemeride.setMes(Mes.FEBRERO);
						break;
					case 3:
						efemeride.setMes(Mes.MARZO);
						break;
					case 4:
						efemeride.setMes(Mes.ABRIL);
						break;
					case 5:
						efemeride.setMes(Mes.MAYO);
						break;
					case 6:
						efemeride.setMes(Mes.JUNIO);
						break;
					case 7:
						efemeride.setMes(Mes.JULIO);
						break;
					case 8:
						efemeride.setMes(Mes.AGOSTO);
						break;
					case 9:
						efemeride.setMes(Mes.SEPTIEMBRE);
						break;
					case 10:
						efemeride.setMes(Mes.OCTUBRE);
						break;
					case 11:
						efemeride.setMes(Mes.NOVIEMBRE);
						break;
					case 12:
						efemeride.setMes(Mes.DICIEMBRE);
						break;
					default:
						System.out.println("NO HAY NINGUN MES");
					}
				} while (mes < 1 || mes > 12);
				valido = false;

			} catch (NumberFormatException e) {
				System.out.println("SE ESPERA UN VALOR NUMERICO");
			}
		}
	}

	public static void dia(Efemeride efemeride) {
		byte dia;
		boolean diaValido;
		boolean valido = true;

		while (valido) {
			try {
				do {
					System.out.print("Ingrese dia: ");
					dia = Byte.parseByte(in.nextLine());
					diaValido = true;

					if (efemeride.getMes() == Mes.FEBRERO) {
						if (dia < 1 || dia > 28) {
							System.out.println("Para febrero, ingrese un número entre 1 y 28.");
							diaValido = false;
						} else {
							efemeride.setDia(dia);
						}

					} else {
						if (dia < 1 || dia > 31) {
							System.out.println("Para otros meses, ingrese un número entre 1 y 31.");
							diaValido = false;
						} else {
							efemeride.setDia(dia);
						}
					}
				} while (!diaValido);
				valido = false;
			} catch (NumberFormatException e) {
				System.out.println("INGRESE UN NUMERO ENTERO DE ENTRE 1 Y 31");
			}
		}

	}
}