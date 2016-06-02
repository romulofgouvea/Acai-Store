package br.com.ufv.projeto_loja.IPessoa;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.ufv.projeto_loja.Entidades.Cliente;
import br.com.ufv.projeto_loja.Entidades.Endereco;
import br.com.ufv.projeto_loja.Entidades.Funcionario;
import br.com.ufv.projeto_loja.Entidades.Pessoa;
import br.com.ufv.projeto_loja.Faceda.Fachada;
import br.com.ufv.projeto_loja.IEndereco.admEndereco;
import br.com.ufv.projeto_loja.Utils.meuCalendar;

public class admCliente {
	private static Scanner scanner = new Scanner(System.in);
	private static Cliente clienteLogado = new Cliente();

	public static void menuCliente(){
		System.out.println("*********MENU CLIENTE**********");
		System.out.println("  0 - Sair");
		System.out.println("  1 - Mostrar Clientes");
		System.out.println("  2 - Cadastrar Clientes");
		System.out.println("  3 - Editar Clientes");
		System.out.println("  4 - Deletar Clientes");
	}

	public static boolean controllerCliente(){
		boolean controlFlag = true;
		do{
			menuCliente();
			try {
				int escolhaMenu = scanner.nextInt();
				switch(escolhaMenu){
				case 0:
					return true;
				case 1:
					mostrarCliente();
					break;
				case 2:
					cadastrarCliente();
					break;
				case 3:
					alterarCliente(null);
					break;
				case 4:
					deletrarCliente(null);
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
		}while(controlFlag);
		return false;
	}

	public static boolean loginCliente(){
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
			clienteLogado.setEmail(email);


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
			clienteLogado.setSenha(senha);
			System.out.println("Aguarde enquanto e feita a verificação no banco de dados..");
		}while(!Pessoa.verificaLoginClienteBD(clienteLogado));
		
		return true;
	}

	@SuppressWarnings("unchecked")
	public static boolean mostrarCliente(){ 
		boolean controlFlag = true;
		do{
			try {

				List<Cliente> clienteList = new ArrayList<Cliente>();
				clienteList = (List<Cliente>) Fachada.getInstance().listarFuncionarios(Cliente.class);
				System.out.println("Clientes");
				for(Cliente f : clienteList){
					System.out.println("" 
							+ "Nome: " + f.getNome() 
							+ " CPF: " + f.getCpf() 
							+ " Identidade: " + f.getIdentidade() 
							+ " Telefone: " + f.getTelefone() 
							+ " Data Nascimento: " + f.getDataNascimento() 
							+ " Sexo: " + f.getSexo() 
							+ " Email: " + f.getEmail()
							+ " Data Cadastro: " + f.getDataCadastro()
							);
				}

				controlFlag = false;
			} catch (InputMismatchException e) {
				System.out.println("Erro: "+ e.getMessage());
			}catch(NullPointerException e){
				System.out.println("Erro: "+ e.getMessage());
			}
		}while(controlFlag);
		return false;
	}

	public static boolean cadastrarCliente(){ 
		Cliente c = new Cliente();
		boolean controlFlag = true;
		//boolean verCadastro = true;
		do{
			try {
				//do{			
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
							cpfBoolVerifica = Pessoa.verificaCPFClienteBD(c);

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
					
					c.setDataCadastro(meuCalendar.modficaData(1, 0, 0, 0));
					
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
					}while(Pessoa.verificaLoginClienteBD(c));
					
				//}while(verCadastro);
				controlFlag = false;
			} catch (InputMismatchException e) {
				System.out.println("Erro: "+ e.getMessage());
			}catch(NullPointerException e){
				System.out.println("Erro: "+ e.getMessage());
			}
		}while(controlFlag);

		if(Fachada.getInstance().cadastroCliente(c)){
			//pega o endereco e adiciona no banco
			System.out.println("Adicionar um endereço: ");
			if(admEndereco.cadastrarEnderecos()){
				c.setEndereco(admEndereco.pegarEnderecos());
			}

			for(Endereco e:c.getEndereco() ){
				//System.out.println("vvvv: "+e.getBairro()+ "id : "+ c.getIdPessoa());
				e.setCliente(c);
				Fachada.getInstance().cadastroEndereco(e);
			}

			return true;
		}
		return false;
	}
	public static boolean alterarCliente(Funcionario f){ return false;}
	public static boolean deletrarCliente(Funcionario f){ return false;}
	
	@SuppressWarnings("unchecked")
	public static Cliente pegarCliente(String email){
		List<Cliente> clienteList = new ArrayList<Cliente>();
		clienteList = (List<Cliente>) Fachada.getInstance().listarFuncionarios(Cliente.class);
		System.out.println("Clientes");
		for(Cliente f : clienteList){
			if(f.getEmail().equals(email)){
				return f;
			}
		}
		return null;
	}

	public static Cliente getClienteLogado() {
		return clienteLogado;
	}

	public static void setClienteLogado(Cliente clienteLogado) {
		admCliente.clienteLogado = clienteLogado;
	}
	
}
