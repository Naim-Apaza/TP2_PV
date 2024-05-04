package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {
	public static void main(String[] args) {
		FelinoSalvaje gatoSalvaje = new FelinoSalvaje("Tanner", (byte) 20, 186);
		FelinoDomestico garfied = new FelinoDomestico("Garfield", (byte) 45, 12);
		FelinoDomestico noHayGato = null;

		// Gato salvaje a domestico
		Converter<FelinoSalvaje, FelinoDomestico> converterSalvaje = f -> new FelinoDomestico(f.getNombre(),
				f.getEdad(), f.getPeso());

		// Gato domestico a salvaje
		Converter<FelinoDomestico, FelinoSalvaje> converterDomestico = f -> new FelinoSalvaje(f.getNombre(),
				f.getEdad(), f.getPeso());

		// Verificamos que el gato exista
		if (Converter.isNotNull(converterSalvaje)) {
			// Conversion de felino salvaje
			FelinoDomestico felinoDomestico = converterSalvaje.convert(gatoSalvaje);

			// Mostramos al felino
			converterSalvaje.mostrarObjeto(felinoDomestico);
		}

		if (Converter.isNotNull(converterDomestico)) {
			// Conversion de felino domestico
			FelinoSalvaje felinoSalvaje = converterDomestico.convert(garfied);

			// Mostramos al felino
			converterDomestico.mostrarObjeto(felinoSalvaje);
		}

		if (!Converter.isNotNull(noHayGato)) {
			System.out.println("El gato no existe");
		}
	}

}