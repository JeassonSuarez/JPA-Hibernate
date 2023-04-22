package com.alura.tienda.pruebas;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.alura.tienda.DAO.CategoriaDAO;
import com.alura.tienda.DAO.ProductoDAO;
import com.alura.tienda.modelo.Categoria;
import com.alura.tienda.modelo.Producto;
import com.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {
	
	public static void main(String[] args) {
		
		
		registrarProducto();
		
		EntityManager em = JPAUtils.getEntityManager();		
		ProductoDAO productoDAO = new ProductoDAO(em);

		Producto producto = productoDAO.consultaId(7l);
		
		List<Producto> productos = productoDAO.consultarTodos();
		
		System.out.println(producto.getNombre());
		
		for (Producto p : productos) {
			System.out.println(p.getNombre());
		}
	
	
		List<Producto> p = productoDAO.consuPorNombre("Samsung");
		
		for (Producto producto2 : p) {
			System.out.println(producto2.getDescripcion());
		}
		
		
		
		
		
		
		
////		se utilizara para dar persistencia en la base de datos, ademas permite hacer rollback
//		em.flush();
//		
////		aguardar la conexxion, pasa a un estado detach
//		em.clear();
//		
////		EN CASO DE QUERER REALIZAR UN UPDATE DE UN REGISTRO, ES POSIBLE REALIZARLO USANDO EL METODO DE ENTITY LLAMADO MERGER,
////		EL CUAL RECIVE COMO PARAMETRO LA ENTIDAD, POR EJEMPLO EN ESTE CASO SE PASARA EL CELULARES YA QUE ES LA CATEGORIA
//		
//		celulares = em.merge(celulares);
//		
//		celulares.setNombre("SOFTWARE");
//		
////		entidad con estado managed
//		em.flush();
//		
////		entidad entra a esado detach
//		em.clear();
//		
////		entidad vuelve al estado managed
//		celulares=em.merge(celulares);
//		
//		em.remove(celulares);
//		em.flush();
		
		
		
		
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("Celulares");
		
		
		
		Producto celular = new Producto("Samsung", "Telefono Nuevo", new BigDecimal("1000"), celulares);
		
		EntityManager em = JPAUtils.getEntityManager();		
		
//		metodos de conexion con la base de datos
		ProductoDAO productoDAO = new ProductoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);


//		se deben inicializar las transacciones con el metodo begin
		em.getTransaction().begin();
		
//		se realiza la operacion de persistencia en la base de datos
		categoriaDAO.guardar(celulares);
		productoDAO.guardar(celular);
		
//		
		em.getTransaction().commit();
		em.close();
	}
}
