package reciclarJa.model;

public abstract class Pessoa {
	
	private String nome;
	private int cpf;
	private float saldo;
	
	
	public Pessoa(String nome, int cpf, float saldo) {
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


	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
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
	
	
	
	public void visualizar() {
		System.out.println("Nome: "+this.getNome());
		System.out.println("CPF: "+this.getCpf());
		System.out.println("Saldo disponível: "+this.getSaldo());
	}
	
	
	
	


}
