package br.com.projetofuncionario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_carteira_de_trabalho")
public class CarteiraDeTrabalho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 150)
	private String pis;
	@Column(length = 75)
	private int numero;
	@Column(length = 75)
	private int serie;
	@Column(length = 10)
	private String uf;
	
	@OneToOne(mappedBy = "carteiraDeTrabalho")
	Funcionario funcionario;
	
	public CarteiraDeTrabalho() {
	}

	public CarteiraDeTrabalho(Integer id, String pis, int numero, int serie, String uf) {
		super();
		this.pis = pis;
		this.numero = numero;
		this.serie = serie;
		this.uf = uf;
		this.id = id;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
