package br.com.ufv.projeto_loja.Entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author ROMULO-NOTE
 */
@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class Funcionario extends Pessoa{
	private static final long serialVersionUID = 1L;


	@Column
	@GeneratedValue
	private int codFuncionario;
	
	@Column
	private String email;

	@Column
	private String senha;
	
	@Column
	private String cargo;

	@OneToMany
	//@JoinColumn(name="enderecoId")
	private List<Endereco> endereco = new ArrayList<Endereco>();
	
	public int getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
}