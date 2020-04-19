package br.com.projetofuncionario.dao;

import java.util.List;

public interface GenericDAO <T> {
	void inserir(T obj);
	void alterar(T obj);
	void remover(int id);
	T buscarPorId(int id);
	List<T> listarTodos(); 
}
