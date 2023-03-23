package clase5;

import java.time.Duration;
import java.time.LocalDateTime;

public class Persona {
	private String nombre;
	private String apellido;
	private LocalDateTime fechaNacimiento;
	private Carrito  carrito;
	
	public Persona(String nombre, String apellido, LocalDateTime fechaNacimiento, Carrito carrito) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.carrito = carrito;
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

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	
	public int edad() {
		LocalDateTime fechaActual = LocalDateTime.now();
		long dias = Duration.between(fechaNacimiento, fechaActual).toDays();
		int edad = (int)(dias/365.2425);
		return edad;
	}
	
	
}