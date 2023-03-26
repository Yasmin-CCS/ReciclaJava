package reciclarJa.model;

public class Pessoa {
	private String nome;
	private String email;
	private int cpf;
	private String contato;

	public Pessoa(String nome, String email, int cpf, String contato) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.contato = contato;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

}
