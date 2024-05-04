package ar.edu.unju.fi.ejercicio7.main;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import static ar.edu.unju.fi.ejercicio5.main.Main.*;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
	public static byte opcion;
	public static Scanner in;
	public static List<Producto> productos;

	public static void main(String[] args) {
		precargaProductos();
		in = new Scanner(System.in);
		menu();
		in.close();
	}

	public static void precargaProductos() {
		if (productos == null)
			productos = new ArrayList<>();
		// Precargar 15 productos
		for (int i = 0; i < 15; i++) {
			String codigo = "P-" + (i + 1);
			float precio = (float) (100 + Math.random() * 900);
			String descripcion = "Producto " + (i + 1);

			productos.add(new Producto(codigo, descripcion, precio, fabricacion(), categoria(), estado()));
		}
	}

	public static void menu() {
		do {
			System.out.println("===================");
			System.out.println("1 – Mostrar productos.");
			System.out.println("2 – Mostrar los productos faltantes");
			System.out.println("3 – Incrementar los precios de los productos en un 20%");
			System.out.println(
					"4 – Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la\n"
							+ "venta.");
			System.out.println("5 – Ordenar los productos por precio de forma descendente.");
			System.out.println("6 - Mostrar los productos con los nombres en mayúsculas.");
			System.out.println("===================");

			switch (validacionOpcion()) {
			case 1:
				mostrarProd();
				break;
			case 2:
				prodFaltante();
				break;
			case 3:
				incrementarPrecio();
				break;
			case 4:
				mostrarCondicion();
				break;
			case 5:
				ordenarDecendente();
				break;
			case 6:
				productosMayuscula();
				break;
			default:
				System.out.println("OPCION INVALIDA..");
			}
		} while (opcion != 0);
	}

	public static byte validacionOpcion() {
		boolean validacion = false;

		while (!validacion) {
			try {
				System.out.print("Ingrese una opcion: ");
				opcion = Byte.parseByte(in.nextLine());

				validacion = true;
			} catch (NumberFormatException e) {
				System.out.println("Debe ingresar un numero entero");
			}
		}
		return opcion;
	}

	public static void mostrarProd() {
		Consumer<Producto> print = System.out::println;
		productos.stream().filter(Producto::getEstado).forEach(print);
	}

	public static void prodFaltante() {
		Predicate<Producto> predicate = Producto::getEstado;
		productos.stream().filter(predicate.negate()).forEach(System.out::println);
	}

	public static void incrementarPrecio() {
		Function<Producto, Producto> aumento = p -> {
			float nuevoPrecio = p.getPrecioUnitario() * 1.2f; // Incrementar un 20%
			p.setPrecioUnitario(nuevoPrecio);
			return p;
		};
		List<Producto> productosIncrementados = productos.stream().map(aumento).collect(Collectors.toList()); // Opción
																												// 3
		productos = productosIncrementados;
	}

	public static void mostrarCondicion() {
		Predicate<Producto> productoEstado = Producto::getEstado;
		Predicate<Producto> productoCategoria = p -> p.getCategoria() == Producto.Categoria.ELECTROHOGAR;

		productos.stream().filter(productoEstado.and(productoCategoria)).forEach(System.out::println);
	}

	public static void ordenarDecendente() {
		Comparator<Producto> productoComparator = Comparator.comparing(Producto::getPrecioUnitario).reversed();
		productos.sort(productoComparator);
		productos.forEach(System.out::println);
	}

	public static void productosMayuscula() {
		Function<Producto, Producto> productosEnMayusculas = p -> {
			p.setDescripcion(p.getDescripcion().toUpperCase());
			return p;
		};
		productos.stream().map(productosEnMayusculas).forEach(System.out::println);
	}
}