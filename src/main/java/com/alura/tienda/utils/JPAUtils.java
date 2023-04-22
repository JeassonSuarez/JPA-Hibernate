package com.alura.tienda.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	
//	se usa el nombre que se asigno en persistence.xml donde dice persistence-unit
	public static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("tienda");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
}
