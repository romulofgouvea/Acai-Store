package br.com.ufv.projeto_loja.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 *
 * @author ROMULO-NOTE
 */

@Entity
public class Vendas {

	@Id
	@GeneratedValue
	private int idVenda;
	
	@Column
	private int codVenda;
	
	@Column
    private int codCliente;
	
	@Column
	private int idEndereco;
	
	@Column
    private int codFuncionario;
	
	@Column
    private String dataEntrega;

	@Column
    private String dataHora;

	@Column
	private String idProduto;
	
	@Column
	private double valorVenda;
	
	@Column
    private int statusVenda;
    
    public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	public int getCodVenda() {
        return codVenda;
    }
    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodCliente() {
        return codCliente;
    }
    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodFuncionario() {
		return codFuncionario;
	}
	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

    public String getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    
    public int getStatusVenda() {
        return statusVenda;
    }
    public void setStatusVenda(int statusVenda) {
        this.statusVenda = statusVenda;
    }
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int escEnd) {
		this.idEndereco = escEnd;
	}
   
	
}
