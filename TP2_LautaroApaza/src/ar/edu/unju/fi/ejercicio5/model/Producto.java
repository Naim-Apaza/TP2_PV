package ar.edu.unju.fi.ejercicio5.model;

import java.text.NumberFormat;

public class Producto {
	public enum OrigenFabricacion {
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}

	public enum Categoria {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	private String codigo;
	private String descripcion;
	private float precioUnitario;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;
	private Boolean estado;

	public Producto() {
	}

	public Producto(String codigo, String descripcion, float precioUnitario, OrigenFabricacion origenFabricacion,
			Categoria categoria, Boolean estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
		this.estado = estado;
	}

	@Override
	public String toString() {
		NumberFormat precio = NumberFormat.getCurrencyInstance();
		String estado = getEstado() ? "Disponible" : "Sin stock";
		return "--------------------------" + '\n' + "Producto: " + '\n' + "- Codigo: " + getCodigo() + '\n'
				+ "- Descripcion: " + getDescripcion() + '\n' + "- Precio Unitario: "
				+ precio.format(getPrecioUnitario()) + '\n' + "- Origen Fabricacion: " + getOrigenFabricacion() + '\n'
				+ "- Categoria: " + getCategoria() + '\n' + "- Estado: " + estado + '\n' + "--------------------------";
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}