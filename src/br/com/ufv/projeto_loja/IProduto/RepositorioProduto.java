package br.com.ufv.projeto_loja.IProduto;

import java.util.List;

import br.com.ufv.projeto_loja.Dao.Dao;
import br.com.ufv.projeto_loja.Entidades.Produto;

public class RepositorioProduto implements IRepositorioProduto{

	@Override
	public boolean cadastroProduto(Produto p) {
		return Dao.getInstance().salvarObjeto(p);
	}

	@Override
	public boolean atualizarProduto(Produto p) {
		return Dao.getInstance().salvarOuAtualizarObjeto(p);
	}

	@Override
	public boolean deletarProduto(Produto p) {
		return Dao.getInstance().deletarObjeto(p);
	}

	@Override
	public List<?> listarProdutos(Class<?> classe) {
		return Dao.getInstance().listarObjetos(classe);
	}

	@Override
	public <T> Object buscarProdutoPorCodigo(Class<T> clazz, long codigo) {
		return Dao.getInstance().buscarPorId(clazz, codigo);
	}


	
	
}
