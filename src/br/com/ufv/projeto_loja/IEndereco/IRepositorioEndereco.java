package br.com.ufv.projeto_loja.IEndereco;

import java.util.List;

import br.com.ufv.projeto_loja.Entidades.Endereco;

public interface IRepositorioEndereco {

	public boolean cadastroEndereco(Endereco e);
	public boolean atualizarEndereco(Endereco e);
	public boolean deletarEndereco(Endereco e);
	public List<?> listarEnderecos(Class<?> classe);
	public <T> Object buscarEnderecoPorCodigo(Class<T> clazz, long codigo);
}
