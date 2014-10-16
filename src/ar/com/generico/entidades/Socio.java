package ar.com.generico.entidades;

import java.math.BigDecimal;

public class Socio {

	private Integer id;
	private Long dni;
	private String nombre;
	private String apellido;
	private String direccion;
	private String localidad;
	private BigDecimal puntos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public BigDecimal getPuntos() {
		return puntos;
	}

	public void setPuntos(BigDecimal puntos) {
		this.puntos = puntos;
	}
}
