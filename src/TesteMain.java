import java.util.Scanner;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import br.com.ufv.projeto_loja.Entidades.admFrenteEmpresa;
import br.com.ufv.projeto_loja.Entidades.admFrenteLoja;
import br.com.ufv.projeto_loja.Utils.meuCalendar;

/*
 *erro nullPointer se estiver algum erro em outras tabelas ou nao tiver no banco
 *utilizar a classe GerarBanco para atualizar o BD 
 **/

public class TesteMain {
	private static Scanner scanner = new Scanner(System.in);	
	
	public static void main(String[] args){
		System.out.println(meuCalendar.modficaData(0,0, 0, 0));
		boolean frenteLojaBool = true;
		do{//ENQUANTO NAO DIGITAR 0 NAO SAI DO MENU
			Menu();
			int escolhaMenu = scanner.nextInt();
			switch(escolhaMenu){
			case 0:
				frenteLojaBool = false;
				break;
			case 1:
				admFrenteEmpresa.controllerFrenteEmpresa();
				break;
			case 2:
				try {
					admFrenteLoja.controllerFrenteLoja();
				} catch (MySQLSyntaxErrorException e) {
					//e.printStackTrace();
					frenteLojaBool = false;
				}
				break;
			case 3://INFORMAÇOES
				System.out.println("*********INFORMAÇÕES**********");
				System.out.println("Esta e uma area de vendas de açai,");
				System.out.println("faça o tanto de pedidos que quiserem.");
				System.out.println("Volte Sempre!");

				break;
			default:
				System.out.println("Erro - Opção Invalida!");
			}
		}while(frenteLojaBool);
	}
	public static void Menu(){
		System.out.println("*********MENU**********");
		System.out.println("0 - Sair");
		System.out.println("1 - EMPRESA");
		System.out.println("2 - LOJA");
//		System.out.println("2 - CLIENTE");
		System.out.println("3 - INFORMAÇÕES");
	}
}
