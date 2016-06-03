package br.com.ufv.projeto_loja.Entidades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.ufv.projeto_loja.Faceda.Fachada;
import br.com.ufv.projeto_loja.IPessoa.admCliente;
import br.com.ufv.projeto_loja.IPessoa.admFuncionario;
import br.com.ufv.projeto_loja.IProduto.admProduto;
import br.com.ufv.projeto_loja.IVendas.admVendas;

public class admFrenteEmpresa {
	@SuppressWarnings("unused")
	private static boolean userLogado = false;
	private static Scanner scanner = new Scanner(System.in);
	private static List<Funcionario> func = new ArrayList<Funcionario>();
	
	public static void MenuEmpresa(){
		System.out.println("*********MENU EMPRESA**********");
		System.out.println("  0 - Sair");
		System.out.println("  1 - Funcionario");
		System.out.println("  2 - Cliente");
		System.out.println("  3 - Produto");
		System.out.println("  4 - Venda");
		
	}
	
	@SuppressWarnings("unchecked")
	public static boolean controllerFrenteEmpresa(){
		boolean areaEmpresaBool = true;
		System.out.println("*********LOGIN DO FUNCIONARIO**********");
		System.out.println("Buscando informações no banco...");
		func = (List<Funcionario>) Fachada.getInstance().listarFuncionarios(Funcionario.class);
		if(func.isEmpty()){
			boolean controlFlag = true;
			do{
				try {
					System.out.println("usuario: ");
					String usuario = scanner.nextLine();
					System.out.println("Senha: ");
					String senha = scanner.nextLine();
					
					if(usuario.equals("admin") && senha.equals("admin"))
						controlFlag = false;
				} catch (InputMismatchException e) {
					System.out.println("Erro: "+ e.getMessage());
				}catch(NullPointerException e){
					System.out.println("Erro: "+ e.getMessage());
				}
			}while(controlFlag);
		} else if(loginFuncEmpresa()){
			
		}
		System.out.println("Login realizado com Sucesso!\n");
		userLogado = true;
			do{
				
					MenuEmpresa();
					int escolhaMenuEmpresa = scanner.nextInt();
					switch(escolhaMenuEmpresa){
						case 0 ://SAIR
							return true;
						case 1://FUNCIONARIO
							admFuncionario.controllerFuncionario();
							break;
						case 2://CLIENTE
							admCliente.controllerCliente();
							break;
						case 3://PRODUTO
							admProduto.controllerProduto();
							break;
						case 4://VENDA
							System.out.println("*********CONTROLE VENDAS**********");
							//mudar o status da venda
							boolean controlVenda = true;
							boolean controlFlag = true;
							do{
								try {
									System.out.println("    0 - Sair");
									System.out.println("    1 - Mostrar Vendas");
//									System.out.println("    1 - Alterar Status Venda");
									int escVenda = scanner.nextInt();
									switch(escVenda){
										case 0:
											controlVenda = false;
											break;
										case 1:
											admVendas.mostrarVendas();
											break;
										default:
											System.out.println("Erro - Opção Invalida");
									}
									controlFlag = false;
								} catch (InputMismatchException e) {
									System.out.println("Erro: "+ e.getMessage());
								}catch(NullPointerException e){
									System.out.println("Erro: "+ e.getMessage());
								}
							}while(controlFlag || controlVenda);
							break;
						default:
							System.out.println("Erro - Opção Invalida!");
			
						}
				
			}while(areaEmpresaBool);
			return true;
		}
	
	
	public static boolean loginFuncEmpresa(){
		Funcionario c = new Funcionario();
		do{
			//EMAIL
			String email;
			boolean emailB = true;
			do{
				System.out.print("Email:");
				email = scanner.next();

				if(!Pessoa.validaEmail(email)){
					System.out.println("Email Invalido!");
					emailB = false;
				}else{
					emailB = true;
				}
			}while(!emailB);
			c.setEmail(email);


			//SENHA
			String senha;
			boolean senhaB = true;
			do{
				System.out.print("Senha:");
				senha = scanner.next();
				if(!Pessoa.validaSenha(senha)){
					System.out.println("Senha tem que ser maior que 4 caracteres.");
					senhaB = false;
				}else{
					senhaB = true;
				}
			}while(!senhaB);
			c.setSenha(senha);
			System.out.println("Aguarde enquanto e feita a verificação no banco de dados..");
		}while(!Pessoa.verificaLoginFuncBD(c));
		
		if(verificaCargoFuncBD(c)){
			return true;
		}else{
			System.out.println("Você nao tem acesso a essa area.");
			return false;
		}
			
		
	}
		
	//verifica usuario e senha
    @SuppressWarnings("unchecked")
	public static boolean verificaCargoFuncBD(Funcionario f){
		List<Funcionario> funcionarioList = new ArrayList<Funcionario>();
		try{
			funcionarioList = (List<Funcionario>) Fachada.getInstance().listarFuncionarios(Funcionario.class);
			//VERIFICAR NO BANCO DE DADOS
			for(Funcionario func:funcionarioList){
				if(func.getCargo().equals("Administrador")){
					return true;
				}
			}
		}catch( NullPointerException e){
			System.out.println("Erro com banco de dados!");
		}
		//System.out.println("Erro - Login!");
		return false;
	}
	
}
