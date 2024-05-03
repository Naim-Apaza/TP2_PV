package ar.edu.unju.fi.ejercicio3.constantes;

import java.text.DecimalFormat;

public enum Provincia {
	JUJUY(673307, 532442), SALTA(1214441, 1553405), TUCUMAN(1448188, 225921), CATAMARCA(367828, 1014861),
	LA_RIOJA(333642, 914937), SANTIAGO_DEL_ESTERO(874006, 1369343);

	private int cantidadPoblacion;
	private int superficie;

	private Provincia(int cantidadPoblacion, int superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	public String mostrarDatos() {
		DecimalFormat densidad = new DecimalFormat("#.#");
		DecimalFormat poblacion = new DecimalFormat("###,###,###");
		DecimalFormat superficie = new DecimalFormat("###,###,###");

		return "- cantidadPoblacion: " + poblacion.format(getCantidadPoblacion()) + " habitantes" + '\n'
				+ "- superficie: " + superficie.format(getSuperficie()) + " km^2" + '\n'
				+ "- Densidad de la poblacion: " + densidad.format(densidadPoblacion()) + " hab/km^2" + '\n'
				+ "------------------------------------------------" + '\n';
	}

	public double densidadPoblacion() {
		return (double) getCantidadPoblacion() / getSuperficie();
	}

	public int getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	private void setCantidadPoblacion(int cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	private void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
}