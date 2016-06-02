package br.com.ufv.projeto_loja.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VendaProduto {
	@Id
	@GeneratedValue
	private long idVendaProduto;
	
	@Column
	private long idVenda;
	
	@Column
	private long idProduto;

	public long getIdVendaProduto() {
		return idVendaProduto;
	}

	public void setIdVendaProduto(long idVendaProduto) {
		this.idVendaProduto = idVendaProduto;
	}

	public long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(long idVenda) {
		this.idVenda = idVenda;
	}

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

}
