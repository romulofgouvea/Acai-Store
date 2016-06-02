package br.com.ufv.projeto_loja.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Produto {
//	teste: Açai com Morango
	//valor custo / venda de cada (ml)
	@Id
	@GeneratedValue
	private int codigo;
	
	@Column
	private String nome;
	
	@Column
	private String decricao;
	
	@Column
	private int categoria;
	
	@Column
	private int quantidadeEstoque300;
	@Column
	private Double valorCusto300;
	@Column
	private Double valorVenda300;

	
	@Column
	private int quantidadeEstoque500;
	@Column
	private Double valorCusto500;
	@Column
	private Double valorVenda500;
	
	@Column
	private int quantidadeEstoque1000;
	@Column
	private Double valorCusto1000;
	@Column
	private Double valorVenda1000;
	
	@Column
	private int quantidadeEstoque2000;
	@Column
	private Double valorCusto2000;
	@Column
	private Double valorVenda2000;
	
	@Column
	private int statusProduto;

	@Transient
	private int quantidade;

	@Transient
	private int qtdML;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDecricao() {
		return decricao;
	}

	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getQuantidadeEstoque300() {
		return quantidadeEstoque300;
	}

	public void setQuantidadeEstoque300(int quantidadeEstoque300) {
		this.quantidadeEstoque300 = quantidadeEstoque300;
	}

	public int getQuantidadeEstoque500() {
		return quantidadeEstoque500;
	}

	public void setQuantidadeEstoque500(int quantidadeEstoque500) {
		this.quantidadeEstoque500 = quantidadeEstoque500;
	}

	public int getQuantidadeEstoque1000() {
		return quantidadeEstoque1000;
	}

	public void setQuantidadeEstoque1000(int quantidadeEstoque1000) {
		this.quantidadeEstoque1000 = quantidadeEstoque1000;
	}

	public int getQuantidadeEstoque2000() {
		return quantidadeEstoque2000;
	}

	public void setQuantidadeEstoque2000(int quantidadeEstoque2000) {
		this.quantidadeEstoque2000 = quantidadeEstoque2000;
	}
	
	public Double getValorCusto300() {
		return valorCusto300;
	}

	public void setValorCusto300(Double valorCusto300) {
		this.valorCusto300 = valorCusto300;
	}

	public Double getValorVenda300() {
		return valorVenda300;
	}

	public void setValorVenda300(Double valorVenda300) {
		this.valorVenda300 = valorVenda300;
	}

	public Double getValorCusto500() {
		return valorCusto500;
	}

	public void setValorCusto500(Double valorCusto500) {
		this.valorCusto500 = valorCusto500;
	}

	public Double getValorVenda500() {
		return valorVenda500;
	}

	public void setValorVenda500(Double valorVenda500) {
		this.valorVenda500 = valorVenda500;
	}

	public Double getValorCusto1000() {
		return valorCusto1000;
	}

	public void setValorCusto1000(Double valorCusto1000) {
		this.valorCusto1000 = valorCusto1000;
	}

	public Double getValorVenda1000() {
		return valorVenda1000;
	}

	public void setValorVenda1000(Double valorVenda1000) {
		this.valorVenda1000 = valorVenda1000;
	}

	public Double getValorCusto2000() {
		return valorCusto2000;
	}

	public void setValorCusto2000(Double valorCusto2000) {
		this.valorCusto2000 = valorCusto2000;
	}

	public Double getValorVenda2000() {
		return valorVenda2000;
	}

	public void setValorVenda2000(Double valorVenda2000) {
		this.valorVenda2000 = valorVenda2000;
	}

	public int getStatusProduto() {
		return statusProduto;
	}

	public void setStatusProduto(int statusProduto) {
		this.statusProduto = statusProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQtdML() {
		return qtdML;
	}

	public void setQtdML(int qtdML) {
		this.qtdML = qtdML;
	}
	
}
