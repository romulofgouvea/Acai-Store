package br.com.ufv.projeto_loja.Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ROMULO-NOTE
 */
public class Cesta {

	private List<Produto> produtoList = new ArrayList<Produto>();
	private String dataHora;
	
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public List<Produto> getProdutoList() {
		return produtoList;
	}
	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
	}
	
}
