package reciclarJa.model;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private float saldo;
	
	// métodos construtor do objeto pessoa.
	public Pessoa(String nome, String cpf, float saldo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.saldo = saldo;
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


	public float getSaldo() {
		return saldo;
	}


	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	public boolean sacar(float valor) {
		if (this.getSaldo() < valor) {
			System.out.println("\nSaldo insuficiente!");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	public boolean validarCpf() {
		if (getCpf().length() != 11) {
			System.out.println("\nCPF inválido!!");
			return false;
		}
		return true;
	}
	
	
	public void visualizar() {
		System.out.println("Nome: "+this.nome);
		System.out.println("CPF: "+this.cpf);
		System.out.println("Saldo disponível: "+this.saldo);
	}
	
	
	
	


}
