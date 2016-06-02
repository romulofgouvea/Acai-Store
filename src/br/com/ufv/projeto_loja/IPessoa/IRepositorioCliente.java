package br.com.ufv.projeto_loja.IPessoa;

import java.util.List;

import br.com.ufv.projeto_loja.Entidades.Cliente;

public interface IRepositorioCliente {
	public boolean cadastroCliente(Cliente c);
	public boolean atualizarCliente(Cliente c);
	public boolean deletarCliente(Cliente c);
	public List<?> listarClientes(Class<?> classe);
	public <T> Object buscarClientePorCodigo(Class<T> clazz, long codigo);
}
