package ar.edu.unju.fi.ejercicio4.model;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

import java.time.LocalDate;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaDeNacimiento;
	private String nacionalidad;
	private float peso;
	private float altura;
	private Posicion posicion;

	public Jugador() {
	}

	public Jugador(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, float peso,
			float altura, Posicion posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.peso = peso;
		this.altura = altura;
		this.posicion = posicion;
	}

	public int calcularEdad() {
		return LocalDate.now().getYear() - getFechaDeNacimiento().getYear();
	}

	@Override
	public String toString() {
		return "------------------------" + '\n' + "Jugador: '" + getNombre() + " " + getApellido() + "' \n"
				+ "- Edad: " + calcularEdad() + '\n' + "- Fecha De Nacimiento: " + getFechaDeNacimiento() + '\n'
				+ "- Nacionalidad: " + getNacionalidad() + '\n' + "- Peso: " + getPeso() + " Kg" + '\n' + "- Altura: "
				+ getAltura() + " m" + '\n' + "- Posicion: " + getPosicion() + '\n' + "------------------------";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
}