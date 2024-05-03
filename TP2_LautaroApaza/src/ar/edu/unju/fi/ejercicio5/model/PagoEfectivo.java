package ar.edu.unju.fi.ejercicio5.model;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

import java.text.NumberFormat;
import java.time.LocalDate;

public class PagoEfectivo implements Pago {
	private double montoPagado;
	private LocalDate fechaDePago;

	@Override
	public void realizarPago(double monto) {
		setMontoPagado(getMontoPagado() - (getMontoPagado() * 0.10));
	}

	@Override
	public void imprimirRecibo() {
		NumberFormat monto = NumberFormat.getCurrencyInstance();
		System.out.println(
				"Fecha de pago: " + getFechaDePago() + '\n' + "Monto pagado: " + monto.format(getMontoPagado()) + '\n');
	}

	public PagoEfectivo() {
	}

	public PagoEfectivo(double montoPagado, LocalDate fechaDePago) {
		this.montoPagado = montoPagado;
		this.fechaDePago = fechaDePago;
	}

	@Override
	public String toString() {
		return "PagoEfectivo{" + "montoPagado=" + montoPagado + ", fechaDePago=" + fechaDePago + '}';
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}
}