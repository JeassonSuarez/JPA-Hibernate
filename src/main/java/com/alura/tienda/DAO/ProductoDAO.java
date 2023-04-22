package com.alura.tienda.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.alura.tienda.modelo.Producto;

import net.bytebuddy.asm.Advice.Return;

public class ProductoDAO {
	private EntityManager em;

	public ProductoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
	
	public Producto consultaId(Long id) {
		return em.find(Producto.class, id);
	}
	
	public List<Producto> consultarTodos(){
		String jpql = "SELECT P FROM Producto AS P";
		return em.createQuery(jpql, Producto.class).getResultList();
	}
	
	public List<Producto> consuPorNombre(String nombre){
		String jpql = "SELECT P FROM Producto AS P WHERE P.nombre=:nombre";
		return em.createQuery(jpql, Producto.class).setParameter("nombre", nombre).getResultList();
	}
	
}
