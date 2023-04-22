package com.aluta.tienda.pruebas;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.alura.tienda.DAO.ProductoDAO;
import com.alura.tienda.modelo.Categoria;
import com.alura.tienda.modelo.Producto;
import com.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {
	
	public static void main(String[] args) {
		Producto celular = new Producto("Samsung", "Telefono Nuevo", new BigDecimal("1000"), Categoria.CELULARES);
		
		EntityManager em = JPAUtils.getEntityManager();		
		
//		metodos de conexion con la base de datos
		ProductoDAO productoDAO = new ProductoDAO(em);
		
//		se deben inicializar las transacciones con el metodo begin
		em.getTransaction().begin();
		
//		se realiza la operacion de persistencia en la base de datos
		productoDAO.guardar(celular);
		
//		se utiliza para saber si hubo la persistencia en la base de datos
		em.getTransaction().commit();
		
//		se cierra la conexion
		em.close();
	}
}
