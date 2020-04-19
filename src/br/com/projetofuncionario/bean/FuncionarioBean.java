package br.com.projetofuncionario.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.projetofuncionario.dao.FuncionarioDAO;
import br.com.projetofuncionario.model.CarteiraDeTrabalho;
import br.com.projetofuncionario.model.Funcionario;

@Named
@RequestScoped
public class FuncionarioBean {
	private Funcionario funcionario;
	private CarteiraDeTrabalho carteiraDeTrabalho;
	private FuncionarioDAO funcionarioDAO;
	private List<Funcionario> funcionarios;
	
	@PostConstruct
	public void init() {
		funcionario = new Funcionario();
		carteiraDeTrabalho = new CarteiraDeTrabalho();
		funcionarioDAO = new FuncionarioDAO();
		funcionarios = funcionarioDAO.listarTodos();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public CarteiraDeTrabalho getCarteiraDeTrabalho() {
		return carteiraDeTrabalho;
	}

	public void setCarteiraDeTrabalho(CarteiraDeTrabalho carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}

	public void cadastrarFuncionario() {
		funcionario.setCarteiraDeTrabalho(carteiraDeTrabalho);
		funcionarioDAO.inserir(funcionario);
		
		funcionarios = funcionarioDAO.listarTodos();
		limparCampo();
	}
	
	public void preparaAtualizacao(Funcionario funcionario) {
		this.funcionario = funcionario;
		
		if(this.funcionario.getCarteiraDeTrabalho() != null) {
			this.carteiraDeTrabalho = this.funcionario.getCarteiraDeTrabalho();
		}
	}
	
	public void atualizarFuncionario() {
		funcionario.setCarteiraDeTrabalho(carteiraDeTrabalho);
		funcionarioDAO.alterar(funcionario);
		funcionarios = funcionarioDAO.listarTodos();
		limparCampo();
	}
	
	public void removerFuncionario(int id) {
		funcionarioDAO.remover(id);
		funcionarios = funcionarioDAO.listarTodos();
	}
	
	public void limparCampo() {
		funcionario = new Funcionario();
		carteiraDeTrabalho = new CarteiraDeTrabalho();
	}
}
