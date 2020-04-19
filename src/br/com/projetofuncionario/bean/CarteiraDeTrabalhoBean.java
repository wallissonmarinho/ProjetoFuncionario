package br.com.projetofuncionario.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.projetofuncionario.dao.CarteiraDeTrabalhoDAO;
import br.com.projetofuncionario.model.CarteiraDeTrabalho;



@Named
@RequestScoped
public class CarteiraDeTrabalhoBean {
	
	private CarteiraDeTrabalho carteiraDeTrabalho;
	
	private CarteiraDeTrabalhoDAO carteiraDeTrabalhoDAO;
	
	private List<CarteiraDeTrabalho> carteirasDeTrabalho;
	
	@PostConstruct
	public void init() {
		carteiraDeTrabalho = new CarteiraDeTrabalho();
		carteiraDeTrabalhoDAO = new CarteiraDeTrabalhoDAO();
		carteirasDeTrabalho = carteiraDeTrabalhoDAO.listarTodos();
	}

	public CarteiraDeTrabalho getCarteiraDeTrabalho() {
		return carteiraDeTrabalho;
	}

	public void setCarteiraDeTrabalho(CarteiraDeTrabalho carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}

	public List<CarteiraDeTrabalho> getCarteirasDeTrabalho() {
		return carteirasDeTrabalho;
	}
	
	public void cadastrarCarteiraDeTrabalho () {
		carteiraDeTrabalhoDAO.inserir(carteiraDeTrabalho);
		carteiraDeTrabalhoDAO.listarTodos();
		carteiraDeTrabalho = new CarteiraDeTrabalho();
	}
	
	public void preparaAtualizacao(CarteiraDeTrabalho carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}
	
	public void atualizarCarteiraDeTrabalho() {
		carteiraDeTrabalhoDAO.alterar(carteiraDeTrabalho);
		carteiraDeTrabalhoDAO.listarTodos();
		carteiraDeTrabalho = new CarteiraDeTrabalho();
	}
	
	public void removerCarteiraDeTrabalho(int id) {
		carteiraDeTrabalhoDAO.remover(id);
		carteiraDeTrabalhoDAO.listarTodos();
	}
	
	public void limparCampo() {
		carteiraDeTrabalho = new CarteiraDeTrabalho();
	}
}
