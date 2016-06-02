package br.com.ufv.projeto_loja.IPessoa;

import java.util.List;

import br.com.ufv.projeto_loja.Dao.Dao;
import br.com.ufv.projeto_loja.Entidades.Cliente;

public class RepositorioCliente implements IRepositorioCliente{

	@Override
	public boolean cadastroCliente(Cliente c) {
		return Dao.getInstance().salvarObjeto(c);
	}

	@Override
	public boolean atualizarCliente(Cliente c) {
		return Dao.getInstance().salvarOuAtualizarObjeto(c);
	}

	@Override
	public boolean deletarCliente(Cliente c) {
		return Dao.getInstance().deletarObjeto(c);
	}

	@Override
	public List<?> listarClientes(Class<?> classe) {
		return Dao.getInstance().listarObjetos(classe);
	}

	@Override
	public <T> Object buscarClientePorCodigo(Class<T> clazz, long codigo) {
		return Dao.getInstance().buscarPorId(clazz, codigo);
	}

}
