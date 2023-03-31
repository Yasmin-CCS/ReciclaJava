package reciclarJa.repository;

import reciclarJa.model.Cliente;

public interface ReciclarJaRepository {
	
	// CRUD conta do cliente
	public void cadastrar(Cliente pessoa);
	public void listarTodas();
	
	

}
