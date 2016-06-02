package br.com.ufv.projeto_loja.Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.com.ufv.projeto_loja.Faceda.Fachada;
/**
 *
 * @author ROMULO-NOTE
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue
	private long idPessoa;
	
	@Column
    private String nome;
	
	@Column
    private String cpf;
	
	@Column
    private String identidade;
	
	@Column
    private String telefone;
	
	@Column
    private String dataNascimento;
	
	@Column
    private String sexo;
	
    public long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

	//verifica usuario e senha
    @SuppressWarnings("unchecked")
	public static boolean verificaLoginFuncBD(Funcionario fu){
		List<Funcionario> funcionarioList = new ArrayList<Funcionario>();
		try{
			funcionarioList = (List<Funcionario>) Fachada.getInstance().listarFuncionarios(Funcionario.class);
			//VERIFICAR NO BANCO DE DADOS
			for(Funcionario f:funcionarioList){
				if(f.getEmail().equals(fu.getEmail())){
					if(f.getSenha().equals(fu.getSenha())){
						return true;
					}
				}
			}
		}catch( NullPointerException e){
			System.out.println("Buscando no banco de dados...");
		}
		return false;
	}
    @SuppressWarnings("unchecked")
	public static boolean verificaCPFFuncBD(Funcionario fu){
    	System.out.println("Aguarde verificando seu CPF...");
    	List<Funcionario> funcionarioList = new ArrayList<Funcionario>();
		try{
			funcionarioList = (List<Funcionario>) Fachada.getInstance().listarFuncionarios(Funcionario.class);
			//VERIFICAR NO BANCO DE DADOS
			for(Funcionario f:funcionarioList){
				if(f.getCpf().equals(fu.getCpf())){
						return true;
				}
			}
		}catch( NullPointerException e){
			System.out.println("Buscando no banco de dados...");
		}
		return false;
    }
    
    @SuppressWarnings("unchecked")
    public static boolean verificaLoginClienteBD(Cliente c){
   		List<Cliente> clienteList = new ArrayList<Cliente>();
   		try{
   			clienteList = (List<Cliente>) Fachada.getInstance().listarClientes(Cliente.class);
   			//VERIFICAR NO BANCO DE DADOS
   			for(Cliente f:clienteList){
   				if(f.getEmail().equals(c.getEmail())){
   					if(f.getSenha().equals(c.getSenha())){
   						System.out.println("ok!");
   						return true;
   					}
   				}
   			}
   		}catch( NullPointerException e){
   			System.out.println("Buscando no banco de dados...");
   		}
   		//System.out.println("Erro!");
   		return false;
   	}
    @SuppressWarnings("unchecked")
	public static boolean verificaCPFClienteBD(Cliente c){ 
    	List<Cliente> clienteList = new ArrayList<Cliente>();
   		try{
   			clienteList = (List<Cliente>) Fachada.getInstance().listarClientes(Cliente.class);
   			//VERIFICAR NO BANCO DE DADOS
   			for(Cliente f:clienteList){
   				if(f.getCpf().equals(c.getCpf())){   					
   						return true;
   				}
   			}
   		}catch( NullPointerException e){
   			System.out.println("Buscando no banco de dados...");
   		}
   		
   		return false;
    }

	public static boolean validaCPF(String CPF){

		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
				CPF.equals("22222222222") || CPF.equals("33333333333") ||
				CPF.equals("44444444444") || CPF.equals("55555555555") ||
				CPF.equals("66666666666") || CPF.equals("77777777777") ||
				CPF.equals("88888888888") || CPF.equals("99999999999") ||
				(CPF.length() != 11))
			return(false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i=0; i<9; i++) {              
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0         
				// (48 eh a posicao de '0' na tabela ASCII)         
				num = (int)(CPF.charAt(i) - 48); 
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for(i=0; i<10; i++) {
				num = (int)(CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else dig11 = (char)(r + 48);			

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return(true);
			else return(false);
		} catch (InputMismatchException erro) {
			return(false);
		}
	}

	public static boolean validaEmail(String email){
	        if ((email == null) || (email.trim().length() == 0))
	            return false;

	        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
	        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	}

	public static boolean validaSenha(String senha){
		if(senha.length() > 4){
			return true;
		}
		return false;
		
		/* criptografia
		 * String senhaAdminNova = "admin";
                     
                     byte messageDigestSenhaAdminNova[] = algorithm.digest(senhaAdminNova.getBytes("UTF-8"));
                      
                     StringBuilder hexStringSenhaAdminNova = new StringBuilder();
                     for (byte b : messageDigestSenhaAdminNova) {
                              hexStringSenhaAdminNova.append(String.format("%02X", 0xFF & b));
                     }
                     String senhahexAdminNova = hexStringSenhaAdminNova.toString();
                     
                     System.out.println(senhahexAdminNova);
                     //compara com equals
		 * */
		
	}
	
	//VALIDAR DATA
		//VALIDAR IDENTIDADE
		
	
}