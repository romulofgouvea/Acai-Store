package br.com.ufv.projeto_loja.IVendas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.ufv.projeto_loja.Entidades.Endereco;
import br.com.ufv.projeto_loja.Entidades.Produto;
import br.com.ufv.projeto_loja.Entidades.Vendas;
import br.com.ufv.projeto_loja.Entidades.admCesta;
import br.com.ufv.projeto_loja.Faceda.Fachada;
import br.com.ufv.projeto_loja.IEndereco.admEndereco;
import br.com.ufv.projeto_loja.IPessoa.admCliente;
import br.com.ufv.projeto_loja.IPessoa.admFuncionario;
import br.com.ufv.projeto_loja.Utils.meuCalendar;

public class admVendas {
	private static List<Produto> produtoList = new ArrayList<Produto>();
	private static Scanner scanner = new Scanner(System.in);
	private static Vendas vendas = new Vendas();
	public static boolean returnMenu = false;

	public static boolean controllerVenda(){

		if(produtoList != null){

			boolean v = true;
			do{
				if(admVendas.returnMenu){
					return true;
				}
				MenuVendas();
				int escolhaCesta = scanner.nextInt();
				switch(escolhaCesta){
				case 0:// VOLTAR PARA A CESTA
					return true;
				case 1://CONCLUIR COMPRA


					boolean concluirCompra = true;
					do{
						MenuCadastro();
						int escolhaCadLoja = scanner.nextInt();
						switch(escolhaCadLoja){
						case 0://VOLTAR CESTA
							concluirCompra = false;
							break;
						case 1://JA SOU CADASTRADO LOGIN

							if(!admCliente.loginCliente()){
								break;
							}
							System.out.println("Login realizado com Sucesso!");
							long idPessoaCliente = admCliente.pegarCliente(admCliente.getClienteLogado().getEmail()).getIdPessoa();
							//System.out.println("idPessoaCliente: " + idPessoaCliente);
							vendas.setCodCliente((int) idPessoaCliente);

							//ADICIONAR ALGUM CODIGO DE FUNCIONARIO
							int codFunc; 
							boolean controlCodFunc = true;
							do{
								System.out.println("Adicionar um codigo de algum Funcionario?");
								System.out.println("1 - Sim");
								System.out.println("2 - Não");
								codFunc = scanner.nextInt();
								switch(codFunc){
								case 1://sim
									boolean controlFlag = true;
									do{
										try {
											admFuncionario.mostrarFuncionarios();
											System.out.println("Digite o codigo de um deles: ");
											int cod = scanner.nextInt();
											vendas.setCodFuncionario(cod);
											controlFlag = false;
										} catch (InputMismatchException e) {
											System.out.println("Erro: "+ e.getMessage());
										}catch(NullPointerException e){
											System.out.println("Erro: "+ e.getMessage());
										}
									}while(controlFlag);
									break;
								case 2://NAO
									controlCodFunc = false;
									break;
								default:
									System.out.println("Erro  - Opção Invalida!");
								}
							}while(controlCodFunc);
							//selecionar o end de entrega 
							
							System.out.println("Escolha um endereço: ");
							boolean controlFlag = true;
							do{
								try {
									int escEnd = 1;
									System.out.println("idPessoaCliente: " + idPessoaCliente);
									List<Endereco> endCliente = admEndereco.pegarEnderecosBD();
									
									System.out.println("endCliente: " + endCliente.size());
									for(Endereco e: endCliente){
										if(e.getCliente().getIdPessoa() == idPessoaCliente){
											System.out.println(""
													+ " Cod.: "   + e.getIdEndereco()
													+ " Rua: "    + e.getRua()
													+ " Numero: " + e.getNumero()
													+ " Bairro: " + e.getBairro()
													+ " Cidade: " + e.getCidade()
													+ " Estado: " + e.getEstado()
													+ " CEP: "	 + e.getCep()
											);
										}
									}

									System.out.print("Cod.: ");
									do{
										escEnd = scanner.nextInt();	
									}while(escEnd < 1 || escEnd > endCliente.size());
									
									vendas.setIdEndereco(escEnd);
									
									controlFlag = false;
								} catch (InputMismatchException e) {
									System.out.println("Erro: "+ e.getMessage());
								}catch(NullPointerException e){
									System.out.println("Erro: "+ e.getMessage());
								}
							}while(controlFlag);

							vendas.setCodVenda(vendas.getCodVenda());//colocar randomico
							vendas.setDataHora(meuCalendar.modficaData(1, 0, 0, 0));
							vendas.setDataEntrega(meuCalendar.modficaData(1, (int) (meuCalendar.getDia() + 6), 0, 0));
							vendas.setStatusVenda(1);
							
							
							List<String> idprodutos = new  ArrayList<String>();
							for(Produto p : admCesta.pegarProdCesta()){
								idprodutos.add(p.getCodigo()+"");
							}
							vendas.setIdProduto(idprodutos.toString());

							vendas.setValorVenda(admCesta.atualizaCarrinho());




							//CADASTRA A VENDA NO BANCO
							if(Fachada.getInstance().cadastroVendas(vendas)){
								//FAZER A VENDA E ARMAZENAR NO BANCO E ATUALIZAR O PRODUTO

								System.out.println("Compra finalizada!");
								System.out.println("Temos um prazo de até "+meuCalendar.modficaData(0, (int) (meuCalendar.getDia() + 6), 0, 0) + " para entregaremos seu produto.");

								returnMenu = true;
								concluirCompra = false;
							}

							break;//JA SOU CADASTRADO LOGIN
						case 2://CADASTRAR CLIENTE
							admCliente.cadastrarCliente();
							System.out.println("Agora voce ja está cadastrado, entre no menu(Já sou cadastrado)\n"
											+ "e termine sua compra.");
							//concluirCompra = false;
							break;
						default:
							System.out.println("Erro  - Opção Invalida!");
						}
					}while(concluirCompra);



					break;//CONCLUIR COMPRA
				default:
					System.out.println("Erro - Opção Invalida!");
				}

			}while(v);
			return true;
		}else{
			System.out.println("Sua Cesta esta vazia!");
			return false;
		}
	} 
	public static void MenuVendas(){
		System.out.println("*********VENDAS**********");
		System.out.println("      0 - Voltar");
		System.out.println("      1 - Concluir Compra");
	}

	public static void MenuCadastro(){
		System.out.println("*********CADASTRO**********");
		System.out.println("      0 - Voltar");
		System.out.println("      1 - Já sou cadastrado");
		System.out.println("      2 - Quero me cadastrar");
	}


	@SuppressWarnings("unchecked")
	public static void mostrarVendas(){
		List<Vendas> vendasList = new ArrayList<Vendas>();
		boolean controlFlag = true;
		do{
			try {
				vendasList = (List<Vendas>) Fachada.getInstance().listarVendas(Vendas.class);
				System.out.println("Relatório de Vendas: ");
				for(Vendas v: vendasList){
					System.out.println(
							" Id:" + v.getIdVenda()
							+ " Cod. Venda: " + v.getCodVenda()
							+ " Cod. Cliente: " + v.getCodCliente()
							+ " Cod. Funcionario: " + v.getCodFuncionario() 
							+ " Data Venda: " + v.getDataHora() 
							+ " Data Entrega: " + v.getDataEntrega()
							+ " Status Venda: " + statusVenda( v.getStatusVenda() )
							);
				}

				controlFlag = false;
			} catch (InputMismatchException e) {
				System.out.println("Erro: "+ e.getMessage());
			}catch(NullPointerException e){
				System.out.println("Erro: "+ e.getMessage());
			}
		}while(controlFlag);

	}

	public static String statusVenda(int status){
		String stat;
		switch(status){
		case 0:
			stat = "Pendente";
			break;
		case 1:
			stat = "Andamento";
			break;
		case 2:
			stat = "Entregue";
			break;
		default:
			stat = "Sem status!";
		}
		return stat;
	}
}
