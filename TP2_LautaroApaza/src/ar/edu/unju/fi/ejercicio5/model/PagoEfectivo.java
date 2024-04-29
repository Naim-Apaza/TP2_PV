package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	private double montoPagado;
	private LocalDate fechaDePagoDate;

	@Override
	public void realizarPago(double monto) {
		this.montoPagado = monto - (monto * 0.10);
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("Fecha de pago: ");
	}

	public PagoEfectivo() {
		super();
	}

	public PagoEfectivo(double montoPagado, LocalDate fechaDePagoDate) {
		super();
		this.montoPagado = montoPagado;
		this.fechaDePagoDate = fechaDePagoDate;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaDePagoDate() {
		return fechaDePagoDate;
	}

	public void setFechaDePagoDate(LocalDate fechaDePagoDate) {
		this.fechaDePagoDate = fechaDePagoDate;
	}

}
