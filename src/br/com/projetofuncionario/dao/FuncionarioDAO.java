package br.com.projetofuncionario.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.projetofuncionario.model.Funcionario;
import br.com.projetofuncionario.util.JPAUtil;


public class FuncionarioDAO implements FuncionarioDAOIF {

	@Override
	public void inserir(Funcionario obj) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void alterar(Funcionario obj) {
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
		Funcionario funcionario = em.find(Funcionario.class, id);
		em.remove(funcionario);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Funcionario buscarPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		Funcionario funcionario = em.find(Funcionario.class, id);
		return funcionario;
	}	
		
	@Override
	public List<Funcionario> listarTodos() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Funcionario> funcionarios = new ArrayList<>();
		String jpql = "SELECT f FROM Funcionario f";
		TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);
		funcionarios = query.getResultList();
		em.close();
		return funcionarios;
	}
}
