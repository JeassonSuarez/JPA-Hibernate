package com.alura.tienda.DAO;

import javax.persistence.EntityManager;

import com.alura.tienda.modelo.Producto;

public class ProductoDAO {
	private EntityManager em;

	public ProductoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
	
}
