package br.com.ufv.projeto_loja.IPessoa;

import java.util.List;

import br.com.ufv.projeto_loja.Dao.Dao;
import br.com.ufv.projeto_loja.Entidades.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario{

	@Override
	public boolean cadastroFuncionario(Funcionario f) {
		return Dao.getInstance().salvarObjeto(f);
	}

	@Override
	public boolean atualizarFuncionario(Funcionario f) {
		return Dao.getInstance().salvarOuAtualizarObjeto(f);
	}

	@Override
	public boolean deletarFuncionario(Funcionario f) {
		return Dao.getInstance().deletarObjeto(f);
	}

	@Override
	public List<?> listarFuncionarios(Class<?> classe) {
		return Dao.getInstance().listarObjetos(classe);
	}

	@Override
	public <T> Object buscarFuncionarioPorCodigo(Class<T> clazz, long codigo) {
		return Dao.getInstance().buscarPorId(clazz, codigo);
	}


}
