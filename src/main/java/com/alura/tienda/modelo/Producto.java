package com.alura.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//para que reconozca la clase en el modelo, se debe agregar las siguientes anotaciones, debenmos mantenernos con la 
// especificacion y no con la implementacion, ya que si se cambia hibernate seria complicado cambiar otras cosas en el API

@Entity

//se utiliza la siguiente anotacion si en la base de datos la tabla no se llama igual que la clase en el api

@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//la siguiente anootacion se usa en caso que el nombre de una columna sea distinto al de la clase
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;

	@Column(name="precio")
	private BigDecimal precio;
	
	private LocalDate fechaRegistro = LocalDate.now();
	
//	la siguiente anotacion permite darle un tipo, y definir que se guardara en la base 
	
//	de datos por defecto se almacena un numero que corresponde a la posicion de la categoria
	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	public Producto(String nombre, String descripcion, BigDecimal precio, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
}
