package br.com.ufv.projeto_loja.IEndereco;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.ufv.projeto_loja.Entidades.Endereco;
import br.com.ufv.projeto_loja.Faceda.Fachada;

public class admEndereco {
	private static Scanner scanner = new Scanner(System.in);
	public static List<Endereco> enderecoList = new ArrayList<Endereco>();
	private static List<Endereco> end;


	public static void menuEndereco(){
		System.out.println("*********MENU ENDERECO**********");
		System.out.println("  0 - Sair");
		System.out.println("  1 - Mostrar Endereços");
		System.out.println("  2 - Cadastrar Endereços");
		System.out.println("  3 - Editar Endereços");
		System.out.println("  4 - Deletar Endereços");
	}

	public static boolean controllerEndereco(){

		boolean controllerEndereco = true;
		boolean controlFlag = true;
		do{
			menuEndereco();
			try {
				int escolhaMenu = scanner.nextInt();
				switch(escolhaMenu){
				case 0:
					return true;
				case 1:
					mostrarEnderecos();
					break;
				case 2:
					controllerEndereco = cadastrarEnderecos();
					break;
				case 3:
					editarEnderecos();
					break;
				case 4:
					for(Endereco e: enderecoList){
						deletarEnderecos(e);
					}

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
		return controllerEndereco;
	}

	@SuppressWarnings("unchecked")
	public static boolean mostrarEnderecos(){
		List<Endereco> endList = new ArrayList<Endereco>();
		endList = (List<Endereco>) Fachada.getInstance().listarEnderecos(Endereco.class);

		for(Endereco e : endList){
			System.out.println(""
					+ "Cod.: "   + e.getIdEndereco()
					+ "Rua: "    + e.getRua()
					+ "Numero: " + e.getNumero()
					+ "Bairro: " + e.getBairro()
					+ "Cidade: " + e.getCidade()
					+ "Estado: " + e.getEstado()
					+ "CEP: "	 + e.getCep()
			);
		}

		return true;
	}
	public static boolean cadastrarEnderecos(){
		System.out.println("Endereco: ");
		Endereco endereco = new Endereco();
		String rua,numero,bairro,cidade,estado,cep;
		boolean controlFlagEnd = true;
		System.out.print("Digite quantos endereços quer cadastrar:");
		int countEnd;
		do{
			countEnd = scanner.nextInt();
		}while(countEnd == 0);

		for(int i  = 0 ; i < countEnd ; i++){
			do{
				try {

					System.out.print("Rua: ");
					do{
						rua = scanner.nextLine();
					}while(rua.equals(""));
					endereco.setRua(rua);

					System.out.print("Numero: ");
					numero = scanner.nextLine();
					endereco.setNumero(numero);

					System.out.print("Bairro: ");
					bairro = scanner.nextLine();
					endereco.setBairro(bairro);

					System.out.print("Cidade: ");
					cidade = scanner.nextLine();
					endereco.setCidade(cidade);

					System.out.print("Estado: ");
					estado = scanner.nextLine();
					endereco.setEstado(estado);

					System.out.print("Cep: ");
					cep = scanner.nextLine();
					endereco.setCep(cep);

					enderecoList.add(endereco);
					controlFlagEnd = false;
				} catch (InputMismatchException e) {
					System.out.println("Erro: "+ e.getMessage());
				}catch(NullPointerException e){
					System.out.println("Erro: "+ e.getMessage());
				}catch(NumberFormatException e){
					System.out.println("Erro: "+ e.getMessage());
				}
			}while(controlFlagEnd);
		}
		//		int x = 0;
		//		for(Endereco e: enderecoList){
		//			Fachada.getInstance().cadastroEndereco(e);
		//			x++;
		//		}
		//		if(x == countEnd){
		//			return true;
		//		}
		return true;
	}
	public static boolean editarEnderecos(){

		return true;
	}
	public static boolean deletarEnderecos(Endereco e){
		return true;
	}

	public static List<Endereco> pegarEnderecos(){
		return enderecoList;
	}

	public static List<Endereco> pegarEnderecosIdPessoa(int id){
		end = null;
		for(Endereco f : enderecoList){
			if(f.getCliente().getIdPessoa() == id){
				System.out.println(
						  " Cod.: "   + f.getIdEndereco()
						+ " Rua: "    + f.getRua()
						+ " Numero: " + f.getNumero()
						+ " Bairro: " + f.getBairro()
						+ " Cidade: " + f.getCidade()
						+ " Estado: " + f.getEstado()
						+ " CEP: "	 + f.getCep()
						+ " idPessoaCliente: "	 + f.getCliente().getIdPessoa()
				);
				
				end.add(f);
			}
		}

		return end;
	}
}
