package br.com.ufv.projeto_loja.Entidades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.exception.SQLGrammarException;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import br.com.ufv.projeto_loja.Faceda.Fachada;
import br.com.ufv.projeto_loja.IVendas.admVendas;

public class admFrenteLoja {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Produto> produtoList = new ArrayList<Produto>();
	private static boolean verPedidos = false;

	public static void MenuFrenteLoja(){
		System.out.println("*********FRENTE DE LOJA**********");
		System.out.println("  0 - Sair");
		System.out.println("  1 - Fazer Pedidos");
		System.out.println("  2 - Meus Pedidos");
	}
	
	@SuppressWarnings("unchecked")
	public static boolean controllerFrenteLoja() throws MySQLSyntaxErrorException{
		int lerMenu;
		boolean controllerFrenteLoja = true;
		
		do{//REPETE MENU FRENTE LOJA
			if(admVendas.returnMenu){
				produtoList.clear();
				admVendas.returnMenu = false;
				verPedidos = false;
				return true;
			}
			MenuFrenteLoja();//CHAMA O MENU
			lerMenu = scanner.nextInt();
			//InputMismatchException

			//ESCOLHE 1 ITEM NO MENU
			switch(lerMenu){
			case 0:
				return true;
			case 1://FAZER PEDIDOS--------------------------------------
				boolean flag = true;
				do{
					try{
						//BUSCAR OS PRODUTOS DO BANCO--------------------------------------
						System.out.println("Buscando Produtos no Banco, Aguarde...");
						produtoList = (List<Produto>) Fachada.getInstance().listarProdutos(Produto.class);
						if(produtoList.size() == 0){
							System.out.println("Lista de Produtos Vazia!");
							break;
						}

						//MOSTRA NA TELA AS OPÇOES--------------------------------------
						System.out.println("*********TODOS OS PRODUTOS**********");
						System.out.println("	0 - Sair");
						for(Produto c: produtoList){
							System.out.println("	" + c.getCodigo() +" - " + c.getNome());
						}

						//ESCOLHE UM A PARTIR DO CODIGO--------------------------------------
						boolean escolhaProduto = true;
						do{
							int codProduto = scanner.nextInt();
							if(codProduto == 0 ){
								escolhaProduto = false;
								break;
							}

							if(codProduto - 1 < produtoList.size() && codProduto > 0){
								if(produtoList.get(codProduto-1).getCodigo() == codProduto){
									// COLOCA O ITEM NA CESTA
									boolean produtoAdicionado = admCesta.adicionarItem(produtoList.get(codProduto-1));
								
									if(produtoAdicionado){
										escolhaProduto = false;
									}
								}
							}else{
								System.out.println("Este produto nao existe, digite um codigo valido que esta dentro desta lista acima.");
							}
						}while(escolhaProduto);
						flag = false;
					}catch(InputMismatchException e){
						System.out.println("Erro: "+ e.getMessage());
					}catch(NullPointerException e){
						System.out.println("Erro: "+ e.getMessage());
					}catch(ArrayIndexOutOfBoundsException e){
						System.out.println("Erro: "+ e.getMessage());
					}catch(SQLGrammarException e){
						System.out.println("Erro: "+ e.getMessage());
					}
				}while(flag);
				verPedidos = true;
				break;
			case 2://MEUS PEDIDOS --------------------------------------
				if(verPedidos)
					controllerFrenteLoja = admCesta.controllerCesta();
				
				System.out.println("Você ainda nao fez nenhum pedido.");
				
				break;
			default:
				System.out.println("Erro - Digite entre 1 e 4 para escolher uma opção valida!");
			}
		}while((lerMenu < 1 || lerMenu > 2) || controllerFrenteLoja);
		return controllerFrenteLoja;
	}

	
}
