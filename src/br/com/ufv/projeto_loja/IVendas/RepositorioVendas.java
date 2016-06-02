package br.com.ufv.projeto_loja.IVendas;

import java.util.List;

import br.com.ufv.projeto_loja.Dao.Dao;
import br.com.ufv.projeto_loja.Entidades.Vendas;

public class RepositorioVendas implements IRepositorioVendas{

	@Override
	public boolean cadastroVendas(Vendas v) {
		return Dao.getInstance().salvarObjeto(v);
	}

	@Override
	public boolean atualizarVendas(Vendas v) {
		return Dao.getInstance().salvarOuAtualizarObjeto(v);
	}

	@Override
	public boolean deletarVendas(Vendas v) {
		return Dao.getInstance().deletarObjeto(v);
	}

	@Override
	public List<?> listarVendas(Class<?> classe) {
		return Dao.getInstance().listarObjetos(classe);
	}

	@Override
	public <T> Object buscarVendasPorCodigo(Class<T> clazz, long codigo) {
		return Dao.getInstance().buscarPorId(clazz, codigo);
	}

	
	
}
