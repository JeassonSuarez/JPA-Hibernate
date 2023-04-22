package com.alura.tienda.DAO;

import javax.persistence.EntityManager;

import com.alura.tienda.modelo.Categoria;

public class CategoriaDAO {
	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void actualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remover(Categoria cat) {
		cat = this.em.merge(cat);
		this.em.remove(cat);
	}
}
