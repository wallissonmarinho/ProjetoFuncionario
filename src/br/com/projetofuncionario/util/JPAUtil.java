package br.com.projetofuncionario.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-funcionario");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
