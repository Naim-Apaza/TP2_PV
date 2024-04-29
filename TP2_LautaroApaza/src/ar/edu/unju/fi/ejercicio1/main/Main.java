package ar.edu.unju.fi.ejercicio1.main;

import ar.edu.unju.fi.ejercicio1.model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner in;
	private static List<Producto> productos;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		byte opcion;
		boolean valido = true;

		while (valido) {
			try {
				do {
					System.out.println("=========================");
					System.out.println("1 – Crear Producto");
					System.out.println("2 – Mostrar productos");
					System.out.println(
							"3 – Modificar producto (sólo puede modificar: descripción, precio unitario, origen fabricación\n"
									+ "o categoría).");
					System.out.println("4 – Salir.");
					System.out.println("=========================" + '\n');

					System.out.print("Ingrese una opcion: ");
					opcion = Byte.parseByte(in.nextLine());

					switch (opcion) {
					case 1:
						crearProducto();
						break;
					case 2:
						mostrarProductos();
						break;
					case 3:
						modificarProducto();
						break;
					case 4:
						System.out.println("FINALIZANDO PROCESO");
						break;
					default:
						System.out.println("OPCION NO PERMITIDA");
					}
				} while (opcion != 4);
				valido = false;
				in.close();
			} catch (NumberFormatException e) {
				System.out.println("SE ESPERA UN NUMERO ENTERO");
			}

		}
	}

	public static void crearProducto() {
		if (productos == null)
			productos = new ArrayList<>();
		Producto producto = new Producto();

		producto.setOrigenFabricacion(origenFabricacion());
		producto.setCategoria(categoria());

		System.out.print("Ingrese codigo: ");
		producto.setCodigo(in.nextLine());

		System.out.print("Ingrese descripcion: ");
		producto.setDescripcion(in.nextLine());

		verificarPrecio(producto);

		productos.add(producto);
	}

	public static void mostrarProductos() {
		if (productos == null || productos.isEmpty()) {
			System.out.println("LA LISTA ESTA VACIA");
			return;
		}
		productos.forEach(System.out::println);
	}

	public static void modificarProducto() {
		if (productos == null || productos.isEmpty()) {
			System.out.println("LA LISTA ESTA VACIA");
			return;
		}

		System.out.print("Ingrese codigo del producto a modificar: ");
		String codigo = in.nextLine();
		for (Producto p : productos) {
			if (p.getCodigo().equals(codigo)) {

				p.setOrigenFabricacion(origenFabricacion());
				p.setCategoria(categoria());

				System.out.print("Ingrese una nueva descripcion: ");
				p.setDescripcion(in.nextLine());

				verificarPrecio(p);

			} else {
				System.out.println("ESTE PRODUCTO NO EXISTE");
				return;
			}
		}
	}

	public static Producto.OrigenFabricacion origenFabricacion() {
		boolean valido = true;
		byte opcion;
		System.out.println("---- Origen de fabricación ------");
		System.out.println("1 - Argentina");
		System.out.println("2 - China");
		System.out.println("3 - Brasil");
		System.out.println("4 – Uruguay" + '\n');

		while (valido) {
			try {
				do {
					System.out.print("Elija una opción: ");
					opcion = Byte.parseByte(in.nextLine());

					switch (opcion) {
					case 1:
						return Producto.OrigenFabricacion.ARGENTINA;
					case 2:
						return Producto.OrigenFabricacion.CHINA;
					case 3:
						return Producto.OrigenFabricacion.BRASIL;
					case 4:
						return Producto.OrigenFabricacion.URUGUAY;
					default:
						System.out.println("OPCION NO PERMITIDA");
					}
				} while (opcion > 4 || opcion < 1);
				valido = false;
			} catch (NumberFormatException e) {
				System.out.println("SE ESPERA UN VALOR NUMERICO ENTERO");
			}
		}
		return null;
	}

	public static Producto.Categoria categoria() {
		boolean valido = true;
		byte opcion;
		System.out.println("------ Categoría ------");
		System.out.println("1 – Telefonía");
		System.out.println("2 – Informática");
		System.out.println("2 – Informática");
		System.out.println("4 – Herramientas" + '\n');

		while (valido) {
			try {
				do {
					System.out.print("Elija una opción: ");
					opcion = Byte.parseByte(in.nextLine());

					switch (opcion) {
					case 1:
						return Producto.Categoria.TELEFONIA;
					case 2:
						return Producto.Categoria.INFORMATICA;
					case 3:
						return Producto.Categoria.ELECTROHOGAR;
					case 4:
						return Producto.Categoria.HERRAMIENTAS;
					default:
						System.out.println("OPCION NO PERMITIDA");
					}
				} while (opcion < 4 || opcion > 1);
				valido = false;
			} catch (NumberFormatException e) {
				System.out.println("SE ESPERA UN VALOR NUMERICO ENTERO");
			}
		}

		return null;
	}

	public static void verificarPrecio(Producto producto) {
		boolean valido = true;
		while (valido) {
			try {
				System.out.print("Ingrese precio unitario: ");
				producto.setPrecioUnitario(Float.parseFloat(in.nextLine()));

				valido = false;
			} catch (NumberFormatException e) {
				System.out.println("SE ESPERA UN VALOR NUMERICO. EJ: ##.##");
			}
		}
	}
}