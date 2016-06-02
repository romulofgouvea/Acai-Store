package br.com.ufv.projeto_loja.Entidades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.ufv.projeto_loja.IVendas.admVendas;

public class admCesta {

	private static Scanner scanner = new Scanner(System.in);
	private static List<Produto> produtoList = new ArrayList<Produto>();
	private static double valorCarrinho;


	public static void MenuFinalizarPedido(){
		System.out.println("*********CESTA**********");
		System.out.println("   0 - Sair");
		System.out.println("   1 - Mostrar Itens da Cesta");
		System.out.println("   2 - Alterar Itens da Cesta");
		System.out.println("   3 - Finalizar Compra");
	}

	public static boolean controllerCesta(){
		boolean controllerCesta = true;
		boolean controlFlag = true;
		
		do{
			if(admVendas.returnMenu){
				produtoList.clear();
				return true;
			}
			MenuFinalizarPedido();
			
			try {
				int escolhaMenu = scanner.nextInt();
				switch(escolhaMenu){
				case 0://SAIR
					return true;
				case 1://MOSTRAR ITENS DA CESTA
					System.out.println("*********MINHA CESTA DE PRODUTOS**********");
					mostrarProdutos();
					break;
				case 2://ALTERAR ITENS DA CESTA
					System.out.println("*********ALTERAR PRODUTOS**********");
					boolean v = true;
					do{
						System.out.println("   0 - Sair");
						mostrarProdutos();
						System.out.println("Digite o cod do produto que quer alterar:");
						int codProduto = scanner.nextInt();
						if(codProduto == 0){
							break;
						}

						if(alterarProdutosCesta(codProduto)){
							v = false;
						}

					}while(v);
					break;
				case 3://FINALIZAR COMPRA NO ADMVENDAS
					admVendas.controllerVenda();
					break;
				default:
					System.out.println("Erro - Opção Invalida!");
				}
				controlFlag = false;
			} catch (InputMismatchException e) {
				System.out.println("Erro: "+ e.getMessage());
			}catch(NullPointerException e){
				System.out.println("Erro: "+ e.getMessage());
			}
		}while(controlFlag || controllerCesta);
		return false;
	}

	
	public static boolean adicionarItem(Produto pPass){
		if(pPass == null)
			return false;
		
		int itensAdd = 1;
		boolean controlInsert = true;
		for(Produto p : produtoList){
			if(p.getCodigo() == pPass.getCodigo()){
				p.setQuantidade(p.getQuantidade()+1);
				controlInsert = false;
				System.out.println("==");
			}else{
				System.out.println("!=");
			}
			itensAdd++;
		}
		System.out.println("Itens Adicionados: " + itensAdd +" Carrinho: " + atualizaCarrinho());
		
		if(controlInsert)
			produtoList.add(pPass);
		
		return true;		
	}

	public boolean adicionarItens(List<Produto> produtoList){
		if(produtoList == null)
			return false;

		produtoList = admCesta.produtoList;
		return true;
	}

	public void removerItens(int codigoItem){}
	public void limpaCarrinho(){}
	public void precoTotal(){}


	public static boolean mostrarProdutos() {
		// i = 0;
		if(produtoList == null){
			System.out.println("Sua Cesta esta vazia!");
			return false;
		}
		System.out.println("Carrinho(R$): " + atualizaCarrinho());

		for(Produto c: produtoList){
			System.out.println("   "+ c.getCodigo() +" - " + c.getNome() + " Quantidade(Copos): "+ c.getQuantidade() + " Quantidade(ml): "+ c.getQtdML());
			//i++;
		}

		return true;
	}

	public static double atualizaCarrinho(){
		valorCarrinho = 0.0;
		for(Produto c: produtoList){
			valorCarrinho += valorQtdML(c.getQtdML(),c);
		}
		return valorCarrinho;
	}

	public static Double valorQtdML(int quantidade,Produto c){
		Double valor = 0.0;
		switch(quantidade){
		case 0 :
			c.setQuantidade(1);
			c.setQtdML(300);
		case 300:
			valor = c.getValorVenda300() * c.getQuantidade();
			break;
		case 500:
			valor = c.getValorVenda500() * c.getQuantidade();
			break;
		case 1000:
			valor = c.getValorVenda1000() * c.getQuantidade();
			break;
		case 2000:
			valor = c.getValorVenda2000() * c.getQuantidade();
			break;
		}
		return valor;
	}


	public boolean verificaCesta(){
		if(produtoList.size() == 0){
			return true;
		}
		return false;
	}

	public void mostraVVenda(int qtd){

	}

	public static boolean alterarProdutosCesta(int codProduto){
		for(Produto p: produtoList){
			if(p.getCodigo() == codProduto){
				boolean alterarPCesta = true;
				do{
					System.out.println("Alterar: ");
					System.out.println("1 - Quantidade de Copos");
					System.out.println("2 - Quantidade em ML");
					
					int escolha = scanner.nextInt();
					switch(escolha){
						case 0:
							return true;
						case 1:
							System.out.println("Quantidade: ");
							int quantidade = scanner.nextInt();
							p.setQuantidade(quantidade);
							alterarPCesta = false;
							break;
						case 2:
							verificaQtdML(p);
							alterarPCesta = false;
							break;
						default:
							System.out.println("Erro - Opção Invalida!");
					}
				}while(alterarPCesta);
			}
		}

		return true;
	}

	public static void verificaQtdML(Produto p){
		int qtd = 0;
		do{
			System.out.println("Selecione a quantidade(ml):");
			System.out.println("1 - 300ml");
			System.out.println("2 - 500ml");
			System.out.println("3 - 1 Litro");
			System.out.println("4 - 2 Litros");
			qtd = scanner.nextInt();
			switch(qtd){
			case 1:
				p.setQtdML(300);
				break;
			case 2:
				p.setQtdML(500);
				break;
			case 3:
				p.setQtdML(1000);
				break;
			case 4:
				p.setQtdML(2000);
				break;
			default:
				System.out.println("Erro - Opção Invalida!");
			}
		}while(qtd < 1 && qtd > 4);
	}
	
	
	public static List<Produto> pegarProdCesta(){
		return produtoList;
	}
}

