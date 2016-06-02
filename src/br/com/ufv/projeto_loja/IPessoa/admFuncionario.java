package br.com.ufv.projeto_loja.IPessoa;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.ufv.projeto_loja.Entidades.Endereco;
import br.com.ufv.projeto_loja.Entidades.Funcionario;
import br.com.ufv.projeto_loja.Entidades.Pessoa;
import br.com.ufv.projeto_loja.Faceda.Fachada;
import br.com.ufv.projeto_loja.IEndereco.admEndereco;

public class admFuncionario {
	private static Scanner scanner = new Scanner(System.in);

	public static void menuFuncionario(){
		System.out.println("*********MENU FUNCIONARIO**********");
		System.out.println("  0 - Sair");
		System.out.println("  1 - Mostrar Funcionarios");
		System.out.println("  2 - Cadastrar Funcionarios");
		System.out.println("  3 - Editar Funcionarios");
		System.out.println("  4 - Deletar Funcionarios");
	}
	public static boolean controllerFuncionario(){
		boolean controllerFuncionario = true;
		boolean controlFlag = true;
		do{
			menuFuncionario();
			try {
				int escolhaMenu = scanner.nextInt();
				switch(escolhaMenu){
				case 0:// SAIR
					return true;
				case 1://MOSTRAR FUNCIONARIOS
					controllerFuncionario = mostrarFuncionarios();
					break;
				case 2://CADASTRAR FUNCIONARIOS
					boolean cadastroP = true;
					do{
						if(admFuncionario.cadastrarFuncionarios()){
							System.out.println("Cadastro realizado com Sucesso!");
							controllerFuncionario = true;
							System.out.println("Deseja cadastrar mais?\n1 - Sim\n2 - Não");
							int escolha  = scanner.nextInt();
							switch (escolha){
							case 1:
								cadastroP  = true;
								break;
							case 2:
								cadastroP  = false;
								break;
							default:
								System.out.println("Erro - Opção Invalida!");
							}
						}else{
							cadastroP = false;
						}
					}while(cadastroP);

					break;
				case 3:// ALTERAR FUNCIONARIOS
					controllerFuncionario = alterarFuncionario(null);
					break;
				case 4://DELETAR FUNCIONARIOS
					controllerFuncionario = deletarFuncionario(null);
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
		}while(controlFlag && controllerFuncionario);
		return controllerFuncionario;
	}

	public static boolean loginFuncionario(){
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
		}while(Pessoa.verificaLoginFuncBD(c));
		return true;
	}

	@SuppressWarnings("unchecked")
	public static boolean mostrarFuncionarios(){ 
		boolean controlFlag = true;
		do{
			try {

				List<Funcionario> funcionariosList = new ArrayList<Funcionario>();
				funcionariosList = (List<Funcionario>) Fachada.getInstance().listarFuncionarios(Funcionario.class);
				System.out.println("Funcionarios"); 
				for(Funcionario f : funcionariosList){
					System.out.println(""
							+ "Cod.: " + f.getCodFuncionario() 
							+ " Nome: " + f.getNome() 
							+ " CPF: " + f.getCpf() 
							+ " Identidade: " + f.getIdentidade() 
							+ " Telefone: " + f.getTelefone() 
							+ " Data Nascimento: " + f.getDataNascimento() 
							+ " Sexo: " + f.getSexo() 
							+ " Email: " + f.getEmail()
							+ " Cargo: " + f.getCargo()
							);
				}

				controlFlag = false;
			} catch (InputMismatchException e) {
				System.out.println("Erro: "+ e.getMessage());
			}catch(NullPointerException e){
				System.out.println("Erro: "+ e.getMessage());
			}
		}while(controlFlag);
		return true;
	}

	public static boolean cadastrarFuncionarios(){
		Funcionario c = new Funcionario();
		boolean controlFlag = true;
		do{
			try {
				do{
					String nome;
					System.out.print("Nome: ");
					do{
						nome = scanner.nextLine();
					}while(nome.equals(""));
					c.setNome(nome);

					// CPF
					boolean cpfBoolValida = true;
					boolean cpfBoolVerifica = true;
					boolean controlFlagCPF = true;
					String cpf = null;
					do{
						try {
							System.out.print("CPF: ");
							cpf = scanner.nextLine();
							// valida o cpf
							cpfBoolValida = Pessoa.validaCPF(cpf);
							// verifica no BD
							cpfBoolVerifica = Pessoa.verificaCPFFuncBD(c);

							if(cpfBoolValida && !cpfBoolVerifica){
								System.out.println("CPF ok!");
								controlFlagCPF = false;
							}else{
								System.out.println("CPF Invalido! Digite novamente um CPF valido para continuar.");
							}
						} catch (InputMismatchException e) {
							System.out.println("Erro: "+ e.getMessage());
						}catch(NullPointerException e){
							System.out.println("Erro: "+ e.getMessage());
						}
					}while(controlFlagCPF);
					c.setCpf(cpf);

					System.out.println("Identidade: ");
					String iden = scanner.nextLine();
					c.setIdentidade(iden);

					System.out.println("Telefone: ");
					String tel = scanner.nextLine();
					c.setTelefone(tel);

					System.out.println("Data Nascimento: ");
					String data = scanner.nextLine();
					c.setDataNascimento(data);

					System.out.println("Sexo: ");
					boolean sexo = true;
					int sexoC;
					do{
						System.out.println("1 - Masculino");
						System.out.println("2 - Feminino");
						System.out.println("3 - Outro");
						sexoC = scanner.nextInt();
						switch(sexoC){
						case 1:
							c.setSexo("Masculino");
							sexo = false;
							break;
						case 2:
							c.setSexo("Feminino");
							sexo = false;
							break;
						case 3:
							c.setSexo("Outro");
							sexo = false;
							break;
						default:
							System.out.println("Erro - Opção Invalida!");
						}
					}while(sexo);

					String cargo;
					System.out.println("Cargo: ");
					do{
						cargo = scanner.nextLine();
					}while(cargo.equals(""));
					c.setCargo(cargo);

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
				}while(Pessoa.verificaLoginFuncBD(c));

				controlFlag = false;
			} catch (InputMismatchException e) {
				System.out.println("Erro: "+ e.getMessage());
			}catch(NullPointerException e){
				System.out.println("Erro: "+ e.getMessage());
			}
		}while(controlFlag);

		if(Fachada.getInstance().cadastroFuncionario(c)){
			//pega o endereco e adiciona no banco
			System.out.println("Adicionar um endereço: ");
			if(admEndereco.cadastrarEnderecos()){
				c.setEndereco(admEndereco.pegarEnderecos());
			}

			for(Endereco e:c.getEndereco() ){
				e.setFuncionario(c);
				Fachada.getInstance().cadastroEndereco(e);
			}

			return true;
		}
		return false;
	}

	public static boolean alterarFuncionario(Funcionario f){ return true;} // FAZER

	public static boolean deletarFuncionario(Funcionario f){ 
		if(Fachada.getInstance().deletarFuncionario(f)){
			return true;
		}else{
			return false;
		}
	}	


}
