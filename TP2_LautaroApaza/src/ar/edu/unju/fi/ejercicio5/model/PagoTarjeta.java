package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numeroDeTargeta;
	private LocalDate fechaDePago;
	private double montoPagado;

	@Override
	public void realizarPago(double monto) {
		this.montoPagado = monto + (monto * 0.15);
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("Número de targeta: " + getNumeroDeTargeta());
		System.out.println("Fecha de pago: " + getFechaDePago());
		System.out.println("Monto pagado: " + getMontoPagado());
	}

	public PagoTarjeta() {
		super();
	}

	public PagoTarjeta(String numeroDeTargeta, LocalDate fechaDePago, double montoPagado) {
		super();
		this.numeroDeTargeta = numeroDeTargeta;
		this.fechaDePago = fechaDePago;
		this.montoPagado = montoPagado;
	}

	@Override
	public String toString() {
		return "PagoTarjeta [numeroDeTargeta=" + numeroDeTargeta + ", fechaDePago=" + fechaDePago + ", montoPagado="
				+ montoPagado + "]";
	}

	public String getNumeroDeTargeta() {
		return numeroDeTargeta;
	}

	public void setNumeroDeTargeta(String numeroDeTargeta) {
		this.numeroDeTargeta = numeroDeTargeta;
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
