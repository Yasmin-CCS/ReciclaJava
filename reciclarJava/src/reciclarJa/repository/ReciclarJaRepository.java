package reciclarJa.repository;

import reciclarJa.model.Pessoa;

public interface ReciclarJaRepository {
	
	// CRUD conta do cliente
	public void procurarPorCpf(String cpf);
	public void cadastrar(Pessoa pessoa);
	public void listarTodas();
	
	
	// Métodos da Conta do cliente
	public void sacar(float valor);

}
