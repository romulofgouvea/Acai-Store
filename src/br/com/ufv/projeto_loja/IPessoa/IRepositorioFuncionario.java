package br.com.ufv.projeto_loja.IPessoa;

import java.util.List;

import br.com.ufv.projeto_loja.Entidades.Funcionario;


public interface IRepositorioFuncionario {

	public boolean cadastroFuncionario(Funcionario f);
	public boolean atualizarFuncionario(Funcionario f);
	public boolean deletarFuncionario(Funcionario f);
	public List<?> listarFuncionarios(Class<?> classe);
	public <T> Object buscarFuncionarioPorCodigo(Class<T> clazz, long codigo);
}
