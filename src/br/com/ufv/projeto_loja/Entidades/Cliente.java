package br.com.ufv.projeto_loja.Entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
//import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class Cliente extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	//@Id
	@Column
	@GeneratedValue
	private int idCliente;
	
	@Column
	private int codCliente;
	
	@Column
	private String email;
	
	@Column
	private String senha;
	
	@Column
	private boolean status;

	@Column
	private String dataCadastro;
	
	@OneToMany
	//@JoinColumn(name="enderecoId")
	private List<Endereco> endereco = new ArrayList<Endereco>();;
	
	
	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}


	
}
