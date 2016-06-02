package br.com.ufv.projeto_loja.Faceda;

import java.util.List;

import br.com.ufv.projeto_loja.Dao.Dao;
import br.com.ufv.projeto_loja.Entidades.Cliente;
import br.com.ufv.projeto_loja.Entidades.Endereco;
import br.com.ufv.projeto_loja.Entidades.Funcionario;
import br.com.ufv.projeto_loja.Entidades.Produto;
import br.com.ufv.projeto_loja.Entidades.Vendas;
import br.com.ufv.projeto_loja.IEndereco.IRepositorioEndereco;
import br.com.ufv.projeto_loja.IEndereco.RepositorioEndereco;
import br.com.ufv.projeto_loja.IPessoa.IRepositorioCliente;
import br.com.ufv.projeto_loja.IPessoa.IRepositorioFuncionario;
import br.com.ufv.projeto_loja.IPessoa.RepositorioCliente;
import br.com.ufv.projeto_loja.IPessoa.RepositorioFuncionario;
import br.com.ufv.projeto_loja.IProduto.IRepositorioProduto;
import br.com.ufv.projeto_loja.IProduto.RepositorioProduto;
import br.com.ufv.projeto_loja.IVendas.IRepositorioVendas;
import br.com.ufv.projeto_loja.IVendas.RepositorioVendas;

public class Fachada {

	private static Fachada instance;
	private IRepositorioProduto repositorioProduto;
	private IRepositorioEndereco repositorioEndereco;
	private IRepositorioCliente repositorioCliente;
	private IRepositorioFuncionario repositorioFuncionario;
	private IRepositorioVendas repositorioVendas;
	
	private Fachada(){
		repositorioProduto = new RepositorioProduto();
		repositorioEndereco = new RepositorioEndereco();
		repositorioCliente = new RepositorioCliente();
		repositorioFuncionario = new RepositorioFuncionario();
		repositorioVendas = new RepositorioVendas();
	}
	
	public static Fachada getInstance(){
		if( instance == null )
			instance = new Fachada();
		return instance;
	}

	//  ------------------------PRODUTO-------------------------------
	public boolean cadastroProduto(Produto p) {
		return repositorioProduto.cadastroProduto(p);
	}
	public boolean atualizarProduto(Produto p) {
		return repositorioProduto.atualizarProduto(p);
	}
	public boolean deletarProduto(Produto p) {
		return repositorioProduto.deletarProduto(p);
	}
	public List<?> listarProdutos(Class<?> classe) {
		return repositorioProduto.listarProdutos(classe);
	}
	public <T> Object buscarProdutoPorCodigo(Class<T> clazz, long codigo){
		return Dao.getInstance().buscarPorId(clazz, codigo);
	}

	//  ------------------------CLIENTE-------------------------------
	
	public boolean cadastroCliente(Cliente c){
		return repositorioCliente.cadastroCliente(c);
	}
	public boolean atualizarCliente(Cliente c){
		return repositorioCliente.atualizarCliente(c);
	}
	public boolean deletarCliente(Cliente c){
		return repositorioCliente.deletarCliente(c);
	}
	public List<?> listarClientes(Class<?> classe){
		return repositorioCliente.listarClientes(classe);
	}
	public <T> Object buscarClientePorCodigo(Class<T> clazz, long codigo){
		return repositorioCliente.buscarClientePorCodigo(clazz, codigo);
	}
	
	//  ------------------------FUNCIONARIO---------------------------
	
	public boolean cadastroFuncionario(Funcionario f){
		return repositorioFuncionario.cadastroFuncionario(f);
	}
	public boolean atualizarFuncionario(Funcionario f){
		return repositorioFuncionario.atualizarFuncionario(f);
	}
	public boolean deletarFuncionario(Funcionario f){
		return repositorioFuncionario.deletarFuncionario(f);
	}
	public List<?> listarFuncionarios(Class<?> classe){
		return repositorioFuncionario.listarFuncionarios(classe);
	}
	public <T> Object buscarFuncionarioPorCodigo(Class<T> clazz, long codigo){
		return repositorioFuncionario.buscarFuncionarioPorCodigo(clazz, codigo);
	}
	
	//  ------------------------ENDERECO------------------------------

	public boolean cadastroEndereco(Endereco e){
		return repositorioEndereco.cadastroEndereco(e);
	}
	public boolean atualizarEndereco(Endereco e){
		return repositorioEndereco.atualizarEndereco(e);
	}
	public boolean deletarEndereco(Endereco e){
		return repositorioEndereco.deletarEndereco(e);
	}
	public List<?> listarEnderecos(Class<?> classe){
		return repositorioEndereco.listarEnderecos(classe);
	}
	public <T> Object buscarEnderecoPorCodigo(Class<T> clazz, long codigo){
		return repositorioEndereco.buscarEnderecoPorCodigo(clazz, codigo);
	}	
	
//  ------------------------VENDAS------------------------------

	public boolean cadastroVendas(Vendas e){
		return repositorioVendas.cadastroVendas(e);
	}
	public boolean atualizarVendas(Vendas e){
		return repositorioVendas.atualizarVendas(e);
	}
	public boolean deletarVendas(Vendas e){
		return repositorioVendas.deletarVendas(e);
	}
	public List<?> listarVendas(Class<?> classe){
		return repositorioVendas.listarVendas(classe);
	}
	public <T> Object buscarVendasPorCodigo(Class<T> clazz, long codigo){
		return repositorioVendas.buscarVendasPorCodigo(clazz, codigo);
	}	
}
