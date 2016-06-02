package br.com.ufv.projeto_loja.IProduto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.ufv.projeto_loja.Entidades.Produto;
import br.com.ufv.projeto_loja.Faceda.Fachada;

public class admProduto {
	
	private static Scanner scanner = new Scanner(System.in);
	private static List<Produto> produtoList = new ArrayList<Produto>();
	
	public static void menuProduto(){
		System.out.println("*********MENU CLIENTE**********");
		System.out.println("  0 - Sair");
		System.out.println("  1 - Mostrar Produtos");
		System.out.println("  2 - Cadastrar Produtos");
		System.out.println("  3 - Editar Produtos");
		System.out.println("  4 - Deletar Produtos");
	}
	
	public static boolean controllerProduto(){
		boolean controllerProduto = true;
		boolean controlFlag = true;
		do{
			menuProduto();
			try {
				int escolhaMenu = scanner.nextInt();
				switch(escolhaMenu){
					case 0:
						return true;
					case 1:
						System.out.println("*********TODOS OS PRODUTOS**********");
						mostrarProdutos();
						break;
					case 2:
						cadastrarProdutos();
						break;
					case 3:
						editarProdutos();
						break;
					case 4:
						deletarProdutos();
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
		}while(controlFlag || controllerProduto);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean mostrarProdutos() {
		System.out.println("Aguarde, buscando do banco de dados...");
		produtoList = (List<Produto>) Fachada.getInstance().listarProdutos(Produto.class);
		for(Produto c: produtoList){
			System.out.println("   "+c.getCodigo() +" - " + c.getNome() + " Quantidade Estoque(300-500-1L-2L): "+ c.getQuantidadeEstoque300()+" - "+c.getQuantidadeEstoque500()+" - "+c.getQuantidadeEstoque1000()+" - "+c.getQuantidadeEstoque2000());
		}
		
		return false;
		
	}
	
	public static boolean cadastrarProdutos() {
		System.out.println("*********CADASTRO DE PRODUTO**********");
		Produto p = new Produto();
		boolean flag = true;
		String nome = null,desc = null;
		double vCusto300 = 0.0,vVenda300 = 0.0,vCusto500 = 0.0,vVenda500 = 0.0,vCusto1000 = 0.0,vVenda1000 = 0.0,vCusto2000 = 0.0,vVenda2000 = 0.0;
		int qtdEstoque300,qtdEstoque500,qtdEstoque1000,qtdEstoque2000 ;
		do {
			try {
				System.out.print("Nome:");
				do{
				nome = scanner.nextLine();
				p.setNome(nome);
				}while(nome.equals(""));
				
				System.out.print("Descriçao: ");
				desc = scanner.nextLine();
				p.setDecricao(desc);

				//COPO 300
				System.out.print("Quantidade estoque (300ml):");
				qtdEstoque300 = Integer.parseInt( scanner.nextLine() );
				p.setQuantidadeEstoque300(qtdEstoque300);
				
				System.out.print("Valor Custo (300ml):");
				vCusto300 = Double.parseDouble( scanner.nextLine() );
				p.setValorCusto300(vCusto300);

				System.out.print("Valor Venda (300ml):");
				vVenda300 = Double.parseDouble( scanner.nextLine() );
				p.setValorVenda300(vVenda300);

				//COPO 500
				System.out.print("Quantidade estoque (500ml):");
				qtdEstoque500 = Integer.parseInt( scanner.nextLine() );
				p.setQuantidadeEstoque500(qtdEstoque500);
				
				System.out.print("Valor Custo (500ml):");
				vCusto500 = Double.parseDouble( scanner.nextLine() );
				p.setValorCusto500(vCusto500);

				System.out.print("Valor Venda (500ml):");
				vVenda500 = Double.parseDouble( scanner.nextLine() );
				p.setValorVenda500(vVenda500);
				
				//COPO1000
				System.out.print("Quantidade estoque (1 Litro):");
				qtdEstoque1000 = Integer.parseInt( scanner.nextLine() );
				p.setQuantidadeEstoque1000(qtdEstoque1000);
				
				System.out.print("Valor Custo (1 Litro):");
				vCusto1000 = Double.parseDouble( scanner.nextLine() );
				p.setValorCusto300(vCusto1000);

				System.out.print("Valor Venda (1 Litro):");
				vVenda1000 = Double.parseDouble( scanner.nextLine() );
				p.setValorVenda300(vVenda1000);
				
				//COPO 2000
				System.out.print("Quantidade estoque (2 Litros):");
				qtdEstoque2000 = Integer.parseInt( scanner.nextLine() );
				p.setQuantidadeEstoque2000(qtdEstoque2000);
				
				System.out.print("Valor Custo (2 Litros):");
				//		Double vCusto = scanner.nextDouble();//NumberFormatException
				vCusto2000 = Double.parseDouble( scanner.nextLine() );
				p.setValorCusto2000(vCusto2000);

				System.out.print("Valor Venda (2 Litros):");
				vVenda2000 = Double.parseDouble( scanner.nextLine() );
				p.setValorVenda2000(vVenda2000);
				
				if(!nome.equals(""))
					flag = false;

			} catch ( InputMismatchException e ) {
				System.out.println("Erro.");
			}catch( NumberFormatException e ){
				System.out.println("Erro.");
			}
		} while(flag);
		return Fachada.getInstance().cadastroProduto(p);
	}
	
	public static boolean editarProdutos() {
		System.out.println("*********EDITAR PRODUTOS**********");
		return false;
	}
	
	public static boolean deletarProdutos() {
		System.out.println("*********DELETAR PRODUTOS**********");
		return false;
	}

}
