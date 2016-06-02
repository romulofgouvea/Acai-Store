package br.com.ufv.projeto_loja.IEndereco;

import java.util.List;

import br.com.ufv.projeto_loja.Dao.Dao;
import br.com.ufv.projeto_loja.Entidades.Endereco;

public class RepositorioEndereco implements IRepositorioEndereco{

	@Override
	public boolean cadastroEndereco(Endereco e) {
		return Dao.getInstance().salvarObjeto(e);
	}

	@Override
	public boolean atualizarEndereco(Endereco e) {
		return Dao.getInstance().salvarOuAtualizarObjeto(e);
	}

	@Override
	public boolean deletarEndereco(Endereco e) {
		return Dao.getInstance().deletarObjeto(e);
	}

	@Override
	public List<?> listarEnderecos(Class<?> classe) {
		return Dao.getInstance().listarObjetos(classe);
	}

	@Override
	public <T> Object buscarEnderecoPorCodigo(Class<T> clazz, long codigo) {
		return Dao.getInstance().buscarPorId(clazz, codigo);
	}

}
