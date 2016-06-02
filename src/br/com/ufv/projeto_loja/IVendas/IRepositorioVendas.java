package br.com.ufv.projeto_loja.IVendas;

import java.util.List;

import br.com.ufv.projeto_loja.Entidades.Vendas;

public interface IRepositorioVendas {

	public boolean cadastroVendas(Vendas v);
	public boolean atualizarVendas(Vendas v);
	public boolean deletarVendas(Vendas v);
	public List<?> listarVendas(Class<?> classe);
	public <T> Object buscarVendasPorCodigo(Class<T> clazz, long codigo);
}
