package ar.edu.unju.fi.ejercicio5.model;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

import java.text.NumberFormat;
import java.time.LocalDate;

public class PagoTarjeta implements Pago {
	private int numeroDeTarjeta;
	private LocalDate fechaDePago;
	private double montoPagado;

	@Override
	public void realizarPago(double monto) {
		setMontoPagado(getMontoPagado() + (getMontoPagado() * 0.15));
	}

	@Override
	public void imprimirRecibo() {
		NumberFormat monto = NumberFormat.getCurrencyInstance();
		System.out.println("Numero de targeta: " + getNumeroDeTarjeta() + '\n' + "Fecha de pago: "
				+ monto.format(getMontoPagado()) + '\n' + "Monto pagado: " + getMontoPagado() + '\n');
	}

	public PagoTarjeta() {
	}

	public PagoTarjeta(int numeroDeTarjeta, LocalDate fechaDePago, double montoPagado) {
		this.numeroDeTarjeta = numeroDeTarjeta;
		this.fechaDePago = fechaDePago;
		this.montoPagado = montoPagado;
	}

	@Override
	public String toString() {
		return "PagoTarjeta{" + "numeroDeTarjeta='" + numeroDeTarjeta + '\'' + ", fechaDePago=" + fechaDePago
				+ ", montoPagado=" + montoPagado + '}';
	}

	public int getNumeroDeTarjeta() {
		return numeroDeTarjeta;
	}

	public void setNumeroDeTarjeta(int numeroDeTarjeta) {
		this.numeroDeTarjeta = numeroDeTarjeta;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}
}