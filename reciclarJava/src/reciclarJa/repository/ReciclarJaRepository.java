package reciclarJa.repository;

import reciclarJa.model.Pessoa;

public interface ReciclarJaRepository {
	
	// CRUD conta do cliente
	public void cadastrar(Pessoa pessoa);
	public void listarTodas();
	public void procurarPorCpf(String cpf, float saldo);
	
	

}
