package br.com.ufv.projeto_loja.IProduto;

import java.util.List;

import br.com.ufv.projeto_loja.Entidades.Produto;

public interface IRepositorioProduto {

	public boolean cadastroProduto(Produto p);
	public boolean atualizarProduto(Produto p);
	public boolean deletarProduto(Produto p);
	public List<?> listarProdutos(Class<?> classe);
	public <T> Object buscarProdutoPorCodigo(Class<T> clazz, long codigo);
}
