package daw.clientes.service;

import java.util.List;

import daw.clientes.model.Cliente;

public interface ClienteService {

	void insertNewCliente(Cliente cliente);
	
	void updateCliente(Cliente cliente);

	boolean getClienteByLogin(String usaurio, String password);

	boolean getClienteByUsuario(String usaurio);

	public List<Cliente> getClientes();

    void deleteCliente(Cliente c);

}
