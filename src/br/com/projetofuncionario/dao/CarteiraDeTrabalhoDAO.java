package br.com.projetofuncionario.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.projetofuncionario.model.CarteiraDeTrabalho;
import br.com.projetofuncionario.util.JPAUtil;


public class CarteiraDeTrabalhoDAO implements CarteiraDeTrabalhoDAOIF {

	@Override
	public void inserir(CarteiraDeTrabalho obj) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void alterar(CarteiraDeTrabalho obj) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		CarteiraDeTrabalho carteiraDeTrabalho = em.find(CarteiraDeTrabalho.class, id);
		em.remove(carteiraDeTrabalho);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public CarteiraDeTrabalho buscarPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		CarteiraDeTrabalho carteiraDeTrabalho = em.find(CarteiraDeTrabalho.class, id);
		return carteiraDeTrabalho;
	}

	@Override
	public List<CarteiraDeTrabalho> listarTodos() {
		EntityManager em = JPAUtil.getEntityManager();
		List<CarteiraDeTrabalho> carteirasDeTrabalho = new ArrayList<>();
		String jpql = "SELECT c FROM CarteiraDeTrabalho c";
		TypedQuery<CarteiraDeTrabalho> query = em.createQuery(jpql , CarteiraDeTrabalho.class);
		carteirasDeTrabalho = query.getResultList();
		em.close();
		return carteirasDeTrabalho;
	}
}
