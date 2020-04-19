package br.com.projetofuncionario.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 180)
	private String nome;
	@Column(length = 50)
	private int matricula;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	@JoinColumn(name = "fk_carteira_de_trabalho" , unique = true)
	private CarteiraDeTrabalho carteiraDeTrabalho;
	
	public Funcionario() {
	}

	public Funcionario(Integer id, String nome, int matricula, CarteiraDeTrabalho carteiraDeTrabalho) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}

	public CarteiraDeTrabalho getCarteiraDeTrabalho() {
		return carteiraDeTrabalho;
	}

	public void setCarteiraDeTrabalho(CarteiraDeTrabalho carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

}
