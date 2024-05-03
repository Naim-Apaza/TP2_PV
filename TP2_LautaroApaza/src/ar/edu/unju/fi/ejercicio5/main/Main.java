package ar.edu.unju.fi.ejercicio5.main;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;

import java.time.LocalDate;
import java.util.*;

public class Main {
	public static Scanner in;
	public static List<Producto> productos;
	public static byte opcion;
	public static LocalDate now;
	public static List<Producto> productosComprar;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		now = LocalDate.now();
		productos = new ArrayList<>(15);
		precargaProductos();

		do {
			System.out.println("============================");
			System.out.println("1 – Mostrar productos");
			System.out.println("2 – Realizar compra");
			System.out.println("3 – Salir");
			System.out.println("============================");
			validarOpcion();

			switch (opcion) {
			case 1:
				mostrar();
				break;
			case 2:
				comprar();
				break;
			case 3:
				System.out.println("FINALIZANDO PROCESO...");
				break;
			default:
				System.out.println("OPCION INVALIDA");
			}
		} while (opcion != 3);
	}

	public static void mostrar() {
		System.out.println("Productos");

		productos.forEach(System.out::println);
	}

	public static void comprar() {
		System.out.println("================");
		System.out.println("1 – Pago efectivo");
		System.out.println("2- Pago con tarjeta.");
		System.out.println("3- Volver");
		System.out.println("================");

		do {
			switch (validarOpcion()) {
			case 1:
				efectivo();
				return;
			case 2:
				tarjeta();
				return;
			case 3:
				return;
			default:
				System.out.println("OPCION INVALIDA");
			}
		} while (validarOpcion() != 3);
	}

	public static byte validarOpcion() {
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

	public static void precargaProductos() {
		// Precargar 15 productos
		for (int i = 0; i < 15; i++) {
			String codigo = "P-" + (i + 1);
			float precio = (float) (100 + Math.random() * 900);
			String descripcion = "Producto " + (i + 1);

			Producto nuevoProducto = new Producto(codigo, descripcion, precio, fabricacion(), categoria(), estado());

			productos.add(nuevoProducto);
		}
	}

	public static Producto.OrigenFabricacion fabricacion() {
		Random num = new Random();
		byte origFabr = (byte) num.nextInt(1, 4);

		switch (origFabr) {
		case 1:
			return Producto.OrigenFabricacion.ARGENTINA;
		case 2:
			return Producto.OrigenFabricacion.CHINA;
		case 3:
			return Producto.OrigenFabricacion.BRASIL;
		case 4:
			return Producto.OrigenFabricacion.URUGUAY;
		default:
			System.out.println("sin origen");
			return null;
		}
	}

	public static Producto.Categoria categoria() {
		Random num = new Random();
		byte cat = (byte) num.nextInt(1, 4);

		switch (cat) {
		case 1:
			return Producto.Categoria.ELECTROHOGAR;
		case 2:
			return Producto.Categoria.INFORMATICA;
		case 3:
			return Producto.Categoria.HERRAMIENTAS;
		case 4:
			return Producto.Categoria.TELEFONIA;
		default:
			System.out.println("sin categoria");
			return null;
		}
	}

	public static boolean estado() {
		Random num = new Random();
		byte estado = (byte) num.nextInt(1, 3);

		return estado == 1;
	}

	public static void efectivo() {
		productosComprar = new ArrayList<>();

		float total = realizandoCompra();

		if (!productosComprar.isEmpty()) {
			productosComprar.forEach(System.out::println);
			PagoEfectivo pagoEfectivo = new PagoEfectivo(total, now);
			pagoEfectivo.imprimirRecibo();
		}
	}

	public static void tarjeta() {
		productosComprar = new ArrayList<>();

		int numTarjeta = validarTarjeta();

		float total = realizandoCompra();

		if (!productosComprar.isEmpty()) {
			productosComprar.forEach(System.out::println);
			PagoTarjeta pagoTarjeta = new PagoTarjeta(numTarjeta, now, total);
			pagoTarjeta.imprimirRecibo();
		}
	}

	public static int validarTarjeta() {
		boolean valido = false;
		int numTarjeta = 0;

		while (!valido) {
			try {
				System.out.print("Ingrese su numero de targeta: ");
				numTarjeta = Integer.parseInt(in.nextLine());

				valido = true;

			} catch (NumberFormatException e) {
				System.out.println("NO AGREGUE SIGNOS, LETRAS, ETC. AL NUMERO DE TARJETA");
			}
		}
		return numTarjeta;
	}

	public static float realizandoCompra() {
		String codigo;
		float total = 0;
		do {
			System.out.print("Ingrese el código del producto (escriba 'ok' para salir): ");
			codigo = in.nextLine();

			if (!codigo.equalsIgnoreCase("ok")) {
				boolean productoEncontrado = false;

				for (Producto p : productos) {
					if (p.getCodigo().equalsIgnoreCase(codigo) && p.getEstado()) {
						System.out.println(p.getDescripcion() + " agregado");
						total += p.getPrecioUnitario();
						productosComprar.add(p);
						productoEncontrado = true;
						break;
					}
				}

				if (!productoEncontrado) {
					System.out.println("Producto no disponible o código incorrecto.");
				}
			}

		} while (!codigo.equalsIgnoreCase("ok"));

		return total;
	}
}